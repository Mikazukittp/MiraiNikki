package app.android.mikazuki.ttp.mirainikki;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.InjectView;


public class DiaryList extends AppCompatActivity {

    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list);

        Intent intent = getIntent();

        ListView myListView = (ListView) findViewById(R.id.myListView);

        //データを準備
        ArrayList<Plan> plans = new ArrayList<>();

        String[] dates = {
                "YYYY/MM/DD1",
                "YYYY/MM/DD2",
                "YYYY/MM/DD3",
                "YYYY/MM/DD4",
                "YYYY/MM/DD5",
                "YYYY/MM/DD6",
                "YYYY/MM/DD7",
                "YYYY/MM/DD8"
        };
        String[] contents = {
                "future plaing_1",
                "future plaing_2",
                "future plaing_3",
                "future plaing_4",
                "future plaing_5",
                "future plaing_6",
                "future plaing_7",
                "future plaing_8"
        };

        for (int i = 0; i < dates.length; i++) {
            Plan plan = new Plan();
            plan.setDate(dates[i]);
            plan.setContent(contents[i]);
            plans.add(plan);
        }


        //Adapter - ArrayAdapter
        PlanAdapter adapter = new PlanAdapter(this, 0, plans);

        // ListViewに表示
        myListView.setAdapter(adapter);
        //myListView.setEmptyView(findViewById(R.id.emptyView));

        //Event
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> adapterView,
                    View view, // タップされたView
                    int i, // 何番目？
                    long l // View id
            ) {
                TextView content = (TextView) view.findViewById(R.id.content);
                Toast.makeText(
                        DiaryList.this,
                        Integer.toString(i) + ":" + content.getText().toString(),
                        Toast.LENGTH_SHORT
                ).show();
                content.setText("Tapped!");
            }
        });

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
                holder.contnet = (TextView) convertView.findViewById(R.id.content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Plan plan = (Plan) getItem(pos);

            holder.date.setText(plan.getDate());
            holder.contnet.setText(plan.getContent());

            return convertView;
        }

    }


    static class ViewHolder {
        TextView date;
        TextView contnet;
    }

    public class Plan {
        private String date;
        private String content;

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
