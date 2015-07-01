package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit;

import app.android.mikazuki.ttp.mirainikki.domain.entity.User;
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
    public User createUer(@Query("user") User user);

    @GET(PATH_USER_WITH_ID)
    public User getuser(@Path("id") int id);

    @POST(PATH_USER_SIGN_IN)
    public User signIn(@Query("username") String username, @Query("password") String password);


}
