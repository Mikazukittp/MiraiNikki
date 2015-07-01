package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import app.android.mikazuki.ttp.mirainikki.data.repository.api.ApiUtil;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.Interceptor.PlanRequestInterceptor;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.RetrofitPlanService;
import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import app.android.mikazuki.ttp.mirainikki.domain.repository.PlanRepository;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public class RetrofitPlanRepository implements PlanRepository {


    Gson GSON = new GsonBuilder().create();

    RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(ApiUtil.API_URL)
            .setConverter(new GsonConverter(GSON))
            .setRequestInterceptor(new PlanRequestInterceptor())
            .build();

    final RetrofitPlanService API = REST_ADAPTER.create(RetrofitPlanService.class);

    @Override
    public Plan get(int id) {
        API.getPlan(id, new Callback<Plan>() {
            @Override
            public void success(Plan plan, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return null;
    }

    @Override
    public List<Plan> getAll() {
        API.getAllPlan(new Callback<List<Plan>>() {
            @Override
            public void success(List<Plan> plans, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return null;
    }

    @Override
    public Plan create(Plan plan) {
        API.createPlan(plan, new Callback<Plan>() {
            @Override
            public void success(Plan plan, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return null;
    }

    @Override
    public Plan update(Plan plan) {
        // do nothing
        return null;
    }

    @Override
    public void delete(int id) {
        // do nothing
    }

}
