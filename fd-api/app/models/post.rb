class Post < ActiveRecord::Base

  belongs_to :user

  soft_deletable

  validates :content, presence: true
  validates :date, presence: true
  validates :user_id, presence: true

end
