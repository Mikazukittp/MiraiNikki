package app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit;

import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public interface RetrofitPlanService {

    static final String PATH_PLAN = "/post";
    static final String PATH_PLAN_WITH_ID = "/post/{id}";

    @POST(PATH_PLAN)
    public Plan createPlan(@Query("post") Plan plan);

    @GET(PATH_PLAN_WITH_ID)
    public Plan getPlan(@Path("id") int id);

    @GET(PATH_PLAN)
    public Plan getAllPlan();


}
