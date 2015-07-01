package app.android.mikazuki.ttp.mirainikki.ui.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.android.mikazuki.ttp.mirainikki.R;


public class CreatePlanFragment extends Fragment {

    private InteractionListener mListener;

    public CreatePlanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("mylog", "CreatePlanFragment");

        View view = inflater.inflate(R.layout.fragment_create_plan, container, false);

        Button bt = (Button) view.findViewById(R.id.submitPlanButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mylog", "CreatePlanFragment#onClick");
                mListener.goToSignUp();
            }
        });
//
//
//        //open db
//        PlanOpenHelper planOpenHelper = new PlanOpenHelper(getActivity().getApplicationContext());
//        SQLiteDatabase db = planOpenHelper.getWritableDatabase();
//
//        ContentValues newPlan = new ContentValues();
//        newPlan.put(PlanContract.Plans.COL_DATE, "yymmdd");
//        newPlan.put(PlanContract.Plans.COL_CONTENT, "hogehoge");
//        long newId = db.insert(
//                PlanContract.Plans.TABLE_NAME,
//                null,
//                newPlan
//        );
//
//        Cursor c = null;
//        c = db.query(
//                PlanContract.Plans.TABLE_NAME,
//                null, //fields
//                null, //where
//                null, //where arg
//                null, //group by
//                null, //having
//                null  //order by
//        );
//        Log.d("mylog", "Count: " + c.getCount());
//
//        while (c.moveToNext()) {
//            int id = c.getInt(c.getColumnIndex(PlanContract.Plans._ID));
//            String date = c.getString(c.getColumnIndex(PlanContract.Plans.COL_DATE));
//            String content = c.getString(c.getColumnIndex(PlanContract.Plans.COL_CONTENT));
//            Log.d("mylog", "id: " + id + " date: " + date + " content: " + content);
//        }
//        c.close();
//
//        // close db
//        db.close();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (InteractionListener) activity;
        } catch (ClassCastException e) {
            Log.e("TAG", e.getMessage());
        }
    }

    public interface InteractionListener {
        public void goToSignUp();
    }


    public void submitPlan(View view) {
        // EditTextを取得
        EditText planContent = (EditText) view.findViewById(R.id.planContent);

        // EditTextの中身を取得
        String pc = planContent.getText().toString().trim();

        // 中身を観て条件分岐
        if (pc.equals("")) {
            // エラー処理
            Toast.makeText(
                    CreatePlanFragment.this.getActivity().getApplicationContext(),
                    "Please enter your name!",
                    Toast.LENGTH_LONG
            ).show();

        } else {
            // 次の画面へ

        }
    }
}
