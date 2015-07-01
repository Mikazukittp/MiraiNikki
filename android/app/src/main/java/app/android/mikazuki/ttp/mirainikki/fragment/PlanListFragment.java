package app.android.mikazuki.ttp.mirainikki.fragment;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import app.android.mikazuki.ttp.mirainikki.R;
import butterknife.InjectView;


public class PlanListFragment extends Fragment {

    private InteractionListener mListener;

    public ArrayList<Plan> plans = new ArrayList<>();

    public PlanListFragment() {
    }

    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("mylog", "PlanListFragment");

        View view = inflater.inflate(R.layout.fragment_plan_list, container, false);
        ListView planListView = (ListView) view.findViewById(R.id.planListView);
        int planListLength = planListView.getCount();

        // 遷移先のxmlを指定
//        if (planListLength < 1) {
//            mListener.goToIntroduction();
//        }
        //データを準備
        plans.add(new Plan("YYYY/MM/DD1", "future planing_1"));
        plans.add(new Plan("YYYY/MM/DD2", "future planing_2"));
        plans.add(new Plan("YYYY/MM/DD3", "future planing_3"));


        //Adapter - ArrayAdapter
        PlanAdapter adapter = new PlanAdapter(getActivity().getApplicationContext(), 0, plans);

        // ListViewに表示
        planListView.setAdapter(adapter);
        planListView.setEmptyView(view.findViewById(R.id.emptyView));

        Button bt = (Button) view.findViewById(R.id.createPlanButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mylog", "PlanListFragment#onClick");
                mListener.goToCreatePlan();
            }
        });

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
        public void goToCreatePlan();
        public void goToIntroduction();
    }


    public class PlanAdapter extends ArrayAdapter<Plan> {
        private LayoutInflater layoutInflater;

        public PlanAdapter(Context c, int id, ArrayList<Plan> plans) {
            super(c, id, plans);
            this.layoutInflater = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = layoutInflater.inflate(
                        R.layout.list_item,
                        parent,
                        false
                );
                holder = new ViewHolder();
                holder.date = (TextView) convertView.findViewById(R.id.date);
                holder.content = (TextView) convertView.findViewById(R.id.content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Plan plan = (Plan) getItem(pos);

            holder.date.setText(plan.getDate());
            holder.content.setText(plan.getContent());

            return convertView;
        }

    }


    static class ViewHolder {
        TextView date;
        TextView content;
    }

    public class Plan {
        private String date;
        private String content;

        public Plan(String date, String content) {
            setDate(date);
            setContent(content);
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

}