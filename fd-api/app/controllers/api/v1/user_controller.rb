class Api::V1::UserController < ApplicationController
  include UserHelper

  def index
    # 今回未実装？
  end

  def show
    @user = User.find_by(id: params[:id])
    if @user.present?
      render :json => return_user_object(@user), status: :ok
    else
      render :json => {error: "指定されたIDのユーザが見つかりません"}, status: :not_found
    end
  end

  def create
    @user = User.new(user_params)
    @user.new_token
    if @user.save
      render :json => return_user_object(@user), status: :ok
    else
      render :json => {error: "ユーザの作成に失敗しました"}, status: :internal_server_error
    end
  end

  def update
    @user = User.find_by(id: params[:id])
    if @user.present?
      if @user.update(user_params)
        render :json => return_user_object(@user), status: :ok
      else
        render :json => {error: "ユーザの更新に失敗しました"}, status: :internal_server_error
      end
    else
      render :json => {error: "指定されたIDのユーザが見つかりません"}, status: :not_found
    end
  end

  def destroy
    #今回未実装？
  end

  def sign_in
    #usernameとpasswordを受け取って、正しければ、tokenを再生成して、DBに上書く&返す
    @user = User.find_by(username: params[:username])
    if @user.blank?
      render :json => {error: "ユーザー名かパスワードが正しくありません"}, status: :unauthorized
      return
    end

    if @user.authoricate(params[:password])
      @user.new_token
      @user.save
      render :json => return_user_object(@user), status: :ok
    else
      render :json => {error: "ユーザー名かパスワードが正しくありません"}, status: :unauthorized
    end
  end

  def user_params
    params.require(:user).permit(:username, :password, :birthday, :email)
  end

end
