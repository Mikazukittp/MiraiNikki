package app.android.mikazuki.ttp.mirainikki.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.android.mikazuki.ttp.mirainikki.model.PlanContract;
import app.android.mikazuki.ttp.mirainikki.PlanOpenHelper;
import app.android.mikazuki.ttp.mirainikki.R;


public class CreatePlanFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan);

        Intent intent = getIntent();

        //open db
        PlanOpenHelper planOpenHelper = new PlanOpenHelper(this);
        SQLiteDatabase db = planOpenHelper.getWritableDatabase();

//        ContentValues newPlan = new ContentValues();
//        newPlan.put(PlanContract.Plans.COL_DATE, "yymmdd");
//        newPlan.put(PlanContract.Plans.COL_CONTENT, "hogehoge");
//        long newId = db.insert(
//                PlanContract.Plans.TABLE_NAME,
//                null,
//                newPlan
//        );

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
        Log.v("DB_TEST", "Count: " + c.getCount());

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex(PlanContract.Plans._ID));
            String date = c.getString(c.getColumnIndex(PlanContract.Plans.COL_DATE));
            String content = c.getString(c.getColumnIndex(PlanContract.Plans.COL_CONTENT));
            Log.v("DB_TEST", "id: " + id + " date: " + date + " content: " + content);
        }
        c.close();

        // close db
        db.close();

    }

    public void submitPlan(View view) {
        // EditTextを取得
        EditText planContent = (EditText) findViewById(R.id.planContent);

        // EditTextの中身を取得
        String pc = planContent.getText().toString().trim();

        // 中身を観て条件分岐
        if (pc.equals("")) {
            // エラー処理
            Toast.makeText(
                    this,
                    "Please enter your name!",
                    Toast.LENGTH_LONG
            ).show();

        } else {
            // 次の画面へ
            Intent intent = new Intent(this, SignUpFragment.class);
            startActivity(intent);

        }
    }
}
