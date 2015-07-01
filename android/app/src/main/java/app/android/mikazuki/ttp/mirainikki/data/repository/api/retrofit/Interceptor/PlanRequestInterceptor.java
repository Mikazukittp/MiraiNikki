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
        request.addHeader("uid", "");
        request.addHeader("token", "");
    }

};

