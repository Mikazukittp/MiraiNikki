package app.android.mikazuki.ttp.mirainikki.domain.repository;

import app.android.mikazuki.ttp.mirainikki.domain.entity.User;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public interface UserRepository extends BaseRepository<User> {

    public User signIn(String username, String password);

}
