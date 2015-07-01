package app.android.mikazuki.ttp.mirainikki.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import app.android.mikazuki.ttp.mirainikki.R;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.repository.RetrofitPlanRepository;
import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import app.android.mikazuki.ttp.mirainikki.domain.repository.BaseCallback;
import butterknife.InjectView;


public class PlanListFragment extends Fragment {

    private InteractionListener mListener;
    private RetrofitPlanRepository mPlanRepository;

    public PlanListFragment() {
    }

    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("mylog", "PlanListFragment");
        // 遷移先のxmlを指定
        final View view = inflater.inflate(R.layout.fragment_plan_list, container, false);

        final ListView planListView = (ListView) view.findViewById(R.id.planListView);

        mPlanRepository = new RetrofitPlanRepository();
        mPlanRepository.getAll(new BaseCallback<List<Plan>>() {
            @Override
            public void onSuccess(List<Plan> plans) {
                //Adapter - ArrayAdapter
                PlanAdapter adapter = new PlanAdapter(getActivity().getApplicationContext(), 0, plans);
                // ListViewに表示
                planListView.setAdapter(adapter);
                planListView.setEmptyView(view.findViewById(R.id.emptyView));
            }

            @Override
            public void onFailure() {

            }
        });

        Button bt = (Button) view.findViewById(R.id.createPlanButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mylog", "PlanListFragment#onClick");
                mListener.goToCreatePlan();
            }
        });

        //Event
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(
//                    AdapterView<?> adapterView,
//                    View view, // タップされたView
//                    int i, // 何番目？
//                    long l // View id
//            ) {
//                TextView content = (TextView) view.findViewById(R.id.content);
//                Toast.makeText(
//                        PlanListFragment.this.getActivity().getApplicationContext(),
//                        Integer.toString(i) + ":" + content.getText().toString(),
//                        Toast.LENGTH_SHORT
//                ).show();
//                content.setText("Tapped!");
//            }
//        });

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
    }


    public class PlanAdapter extends ArrayAdapter<Plan> {
        private LayoutInflater layoutInflater;

        public PlanAdapter(Context c, int id, List<Plan> plans) {
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

            SimpleDateFormat inFmt = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outFmt = new SimpleDateFormat("yyyy年 MM月", Locale.JAPAN);
            try {
                holder.date.setText(outFmt.format(inFmt.parse(plan.getDate())));
            }catch(ParseException e){
                Log.e("TAG", "Date parse error: "+plan.getDate());
                Log.e("TAG", e.getMessage());
                holder.date.setText(plan.getDate());
            }
            holder.content.setText(plan.getContent());

            return convertView;
        }

    }


    static class ViewHolder {
        TextView date;
        TextView content;
    }

}
