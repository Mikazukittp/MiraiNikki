package app.android.mikazuki.ttp.mirainikki.data.repository.db.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.android.mikazuki.ttp.mirainikki.data.repository.db.PlanOpenHelper;
import app.android.mikazuki.ttp.mirainikki.data.repository.db.model.PlanContract;
import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import app.android.mikazuki.ttp.mirainikki.domain.repository.BaseCallback;
import app.android.mikazuki.ttp.mirainikki.domain.repository.PlanRepository;

/**
 * Created by haijimakazuki on 15/07/02.
 */
public class DBPlanRepository implements PlanRepository {

    Context mContext;

    DBPlanRepository() {

    }

    DBPlanRepository(Context context) {
        this.mContext = context;
    }

    @Override
    public void get(int id, BaseCallback<Plan> cb) {

    }

    @Override
    public void getAll(BaseCallback<List<Plan>> cb) {
        //open db
        PlanOpenHelper planOpenHelper = new PlanOpenHelper(mContext);
        SQLiteDatabase db = planOpenHelper.getWritableDatabase();

        Cursor c = null;
        c = db.query(
                PlanContract.Plans.TABLE_NAME,
                null, //fields
                null, //where
                null, //where arg
                null, //group by
                null, //having
                null  //order by
        );
        ArrayList<Plan> plans = new ArrayList<>();
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex(PlanContract.Plans._ID));
            String content = c.getString(c.getColumnIndex(PlanContract.Plans.COL_CONTENT));
            String date = c.getString(c.getColumnIndex(PlanContract.Plans.COL_DATE));
            Log.d("mylog", "id: " + id + " date: " + date + " content: " + content);
            plans.add(new Plan(id, content, date));
        }
        c.close();
        db.close();
    }

    @Override
    public void create(Plan plan, BaseCallback<Plan> cb) {
        //open db
        PlanOpenHelper planOpenHelper = new PlanOpenHelper(mContext);
        SQLiteDatabase db = planOpenHelper.getWritableDatabase();

        ContentValues newPlan = new ContentValues();
        newPlan.put(PlanContract.Plans.COL_DATE, String.valueOf(plan.getDate()));
        newPlan.put(PlanContract.Plans.COL_CONTENT, String.valueOf(plan.getContent()));
        long newId = db.insert(
                PlanContract.Plans.TABLE_NAME,
                null,
                newPlan
        );

        Cursor c = null;
        c = db.query(
                PlanContract.Plans.TABLE_NAME,
                null, //fields
                null, //where
                null, //where arg
                null, //group by
                null, //having
                null  //order by
        );
        Log.d("mylog", "Count: " + c.getCount());

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex(PlanContract.Plans._ID));
            String date = c.getString(c.getColumnIndex(PlanContract.Plans.COL_DATE));
            String content = c.getString(c.getColumnIndex(PlanContract.Plans.COL_CONTENT));
            Log.d("mylog", "id: " + id + " date: " + date + " content: " + content);
        }
        // close db
        c.close();
        db.close();
    }

    @Override
    public void update(Plan plan, BaseCallback<Plan> cb) {

    }

    @Override
    public void delete(int id, BaseCallback<Plan> cb) {

    }

}
