require 'digest/md5'

class User < ActiveRecord::Base

  has_many :posts

  soft_deletable

  validates :username, presence: true, uniqueness: true
  validates :password, presence: true

  before_create :hash

  # 認証を行う。
  def authoricate(password)
    return false if User.crypt_password(password, self.salt) != self.password
    true
  end

  # DB格納前のフック
  # saltと暗号化されたパスワードを生成
  def hash
    self.salt = User.new_salt
    self.password = User.crypt_password(self.password, self.salt)
  end

  # tokenの新規作成
  def new_token
    s = SecureRandom.base64(24)
    s[0, if s.size > 32 then 32 else s.size end]
    self.token = s
    s
  end

  private

  # パスワードを暗号化する
  def self.crypt_password(password, salt)
    Digest::MD5.hexdigest(password + salt)
  end

  # パスワード暗号化のためのsalt生成
  def self.new_salt
    # s = rand.to_s.tr('+', '.')
    s = SecureRandom.base64(24)
    s[0, if s.size > 32 then 32 else s.size end]
  end

end
