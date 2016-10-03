package app.android.mikazuki.ttp.mirainikki.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import app.android.mikazuki.ttp.mirainikki.R;
import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import butterknife.Bind;
import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by haijimakazuki on 15/07/03.
 */
public class PlanAdapter extends ArrayAdapter<Plan> implements StickyListHeadersAdapter {
    private LayoutInflater layoutInflater;

    public PlanAdapter(Context c, int id, List<Plan> plans) {
        super(c, id, plans);
        this.layoutInflater = (LayoutInflater) c.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Plan plan = getItem(position);
        SimpleDateFormat inFmt = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN);
        SimpleDateFormat outFmt = new SimpleDateFormat("MM月", Locale.JAPAN);
        try {
            holder.date.setText(outFmt.format(inFmt.parse(plan.getDate())));
        } catch (ParseException e) {
            Log.e("TAG", "Date parse error: " + plan.getDate());
            Log.e("TAG", e.getMessage());
            holder.date.setText(plan.getDate());
        }
        holder.content.setText(plan.getContent());
        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_header, parent, false);
            holder = new HeaderViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        String headerText = getItem(position).getDate().subSequence(0, 4).toString()+"年";
        holder.year.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return Long.parseLong(getItem(position).getDate().subSequence(0, 4).toString());
    }

    static class ViewHolder {
        @Bind(R.id.date)
        TextView date;
        @Bind(R.id.content)
        TextView content;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class HeaderViewHolder {
        @Bind(R.id.headerYear)
        TextView year;

        public HeaderViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
