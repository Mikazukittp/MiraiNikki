module UserHelper

  def return_user_object(user)
    {
      id: user.id,
      username: user.username,
      email: user.email,
      birthday: user.birthday,
      token: user.token
      }
  end
end
