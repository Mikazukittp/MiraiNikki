package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.repository;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import app.android.mikazuki.ttp.mirainikki.data.repository.api.ApiUtil;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.Interceptor.PlanRequestInterceptor;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.RetrofitPlanService;
import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import app.android.mikazuki.ttp.mirainikki.domain.repository.BaseCallback;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public class RetrofitPlanRepository {


    Gson GSON = new GsonBuilder().create();

    RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(ApiUtil.API_URL)
            .setConverter(new GsonConverter(GSON))
            .setRequestInterceptor(new PlanRequestInterceptor())
            .build();

    final RetrofitPlanService API = REST_ADAPTER.create(RetrofitPlanService.class);

    public void get(int id, final BaseCallback<Plan> cb) {
        API.getPlan(id, new Callback<Plan>() {
            @Override
            public void success(Plan plan, Response response) {
                cb.onSuccess(plan);
            }

            @Override
            public void failure(RetrofitError error) {
                cb.onFailure();
            }
        });
    }

    public void getAll(final BaseCallback<List<Plan>> cb) {
        API.getAllPlan(new Callback<List<Plan>>() {
            @Override
            public void success(List<Plan> plans, Response response) {
                cb.onSuccess(plans);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("!!!!!", error.getResponse().getStatus()+" "+error.getMessage());
                cb.onFailure();
            }
        });
    }

    public void create(Plan plan, final BaseCallback<Plan> cb) {
        API.createPlan(plan, new Callback<Plan>() {
            @Override
            public void success(Plan plan, Response response) {
                cb.onSuccess(plan);
            }

            @Override
            public void failure(RetrofitError error) {
                cb.onFailure();
            }
        });
    }

//    public Plan update(Plan plan) {
//        // do nothing
//        return null;
//    }
//
//    public void delete(int id) {
//        // do nothing
//    }

}
