package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.Interceptor;

import retrofit.RequestInterceptor;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public class PlanRequestInterceptor implements RequestInterceptor {

    public PlanRequestInterceptor() {
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("uid", "1");
        request.addHeader("token", "a8ucn23a6hlPL6PG61c4gQ6aIWruS81X");
    }

};

