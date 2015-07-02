package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit;

import app.android.mikazuki.ttp.mirainikki.domain.entity.User;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public interface RetrofitUserService {

    static final String PATH_USER = "/user";
    static final String PATH_USER_WITH_ID = "/user/{id}";
    static final String PATH_USER_SIGN_IN = "/user/sign_in";

    @POST(PATH_USER)
    public void createUer(@Query("user") User user, Callback<User> cb);
//    public User createUer(@Query("user") User user);

    @GET(PATH_USER_WITH_ID)
    public void getuser(@Path("id") int id, Callback<User> cb);
//    public User getuser(@Path("id") int id);

    @POST(PATH_USER_SIGN_IN)
    public void signIn(@Query("username") String username, @Query("password") String password, Callback<User> cb);
//    public User signIn(@Query("username") String username, @Query("password") String password);


}
