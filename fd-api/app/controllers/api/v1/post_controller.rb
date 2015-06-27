class Api::V1::PostController < ApplicationController

  def index
    @posts = Post.all
    render :json => @posts, status: :ok
  end

  def show
    #TODO 404処理
    @post = Post.find_by_id(id: params[:id])
    render :json => @post, status: :ok
  end

  def create
    @post = Post.new(post_params)
    if @post.save
      render :json => @post, status: :ok
    else
      
    end
  end

  def update
    #今回未実装？
  end

  def destroy
    #今回未実装？
  end

  def post_params
    params.require(:post).permit(:content, :date, :user_id)
  end

end
