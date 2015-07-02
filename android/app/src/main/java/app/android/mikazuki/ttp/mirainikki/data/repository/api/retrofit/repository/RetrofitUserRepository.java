package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import app.android.mikazuki.ttp.mirainikki.data.repository.api.ApiUtil;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.RetrofitUserService;
import app.android.mikazuki.ttp.mirainikki.domain.entity.User;
import app.android.mikazuki.ttp.mirainikki.domain.repository.BaseCallback;
import app.android.mikazuki.ttp.mirainikki.domain.repository.UserRepository;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public class RetrofitUserRepository implements UserRepository {

    Gson GSON = new GsonBuilder().create();

    RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(ApiUtil.API_URL)
            .setConverter(new GsonConverter(GSON))
            .build();

    final RetrofitUserService API = REST_ADAPTER.create(RetrofitUserService.class);

    @Override
    public void get(int id, final BaseCallback<User> cb) {
        API.getuser(id, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                cb.onFailure();
            }

            @Override
            public void failure(RetrofitError error) {
                cb.onFailure();
            }
        });
    }

    @Override
    public void create(User user, final BaseCallback<User> cb) {
        API.createUer(user, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                cb.onFailure();
            }

            @Override
            public void failure(RetrofitError error) {
                cb.onFailure();
            }
        });
    }

    @Override
    public void signIn(String username, String password, final BaseCallback<User> cb) {
        API.signIn(username, password, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                cb.onSuccess(user);
            }

            @Override
            public void failure(RetrofitError error) {
                cb.onFailure();
            }
        });
    }

    @Override
    public void getAll(final BaseCallback<List<User>> cb) {
        // do nothing
    }

    @Override
    public void update(User user, final BaseCallback<User> cb) {
        // do nothing
    }

    @Override
    public void delete(int id, final BaseCallback<User> cb) {
        // do nothing
    }

}
