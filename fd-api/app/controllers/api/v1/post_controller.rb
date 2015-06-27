class Api::V1::PostController < ApplicationController

  before_action :authenticate!

  def index
    @posts = Post.where(user_id: @user.id)
    render :json => @posts, status: :ok
  end

  def show
    @post = Post.find_by(id: params[:id])
    if @post.present?
      render :json => @post, status: :ok
    else
      render :json => {error: "指定されたIDの投稿が見つかりません"}, status: :not_found
    end
  end

  def create
    @post = Post.new(post_params)
    @post.user_id = @user.id
    if @post.save
      render :json => @post, status: :ok
    else
      render :json => {error: "投稿に失敗しました"}, status: :internal_server_error
    end
  end

  def update
    # 今回未実装？
  end

  def destroy
    # 今回未実装？
  end

  def post_params
    params.require(:post).permit(:content, :date)
  end

  private
    def authenticate!
      # 認証処理をする
      # 認証に失敗したらログインページにリダイレクトする
      uid = request.headers[:UID]
      token = request.headers[:TOKEN]
      @user = User.find_by(id: uid)
      if @user.present? and token == @user.token
        return true
      else
        render :json => {error: "認証に失敗しました"}, status: :unauthorized
        return false
      end
    end
end
