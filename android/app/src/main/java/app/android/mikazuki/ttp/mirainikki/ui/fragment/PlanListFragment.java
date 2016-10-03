package app.android.mikazuki.ttp.mirainikki.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.android.mikazuki.ttp.mirainikki.R;
import app.android.mikazuki.ttp.mirainikki.data.repository.api.retrofit.repository.RetrofitPlanRepository;
import app.android.mikazuki.ttp.mirainikki.domain.entity.Plan;
import app.android.mikazuki.ttp.mirainikki.domain.repository.BaseCallback;
import app.android.mikazuki.ttp.mirainikki.ui.adapter.PlanAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class PlanListFragment extends Fragment {

    @Bind(R.id.planListView)
    StickyListHeadersListView mPlanListView;

    private InteractionListener mListener;
    private RetrofitPlanRepository mPlanRepository;
    private boolean network;

    public PlanListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_plan_list, container, false);
        ButterKnife.bind(this, view);

        mPlanRepository = new RetrofitPlanRepository();
        setListData();
        return view;
    }

    private boolean isDataConnected() {
        try {
            ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception e) {
            return false;
        }
    }

    private void setListData() {
//        List<Plan> plans = new ArrayList<Plan>();
//        plans.add(new Plan(1, "plan1", "2020-04-01"));
//        plans.add(new Plan(2, "plan2", "2020-04-01"));
//        plans.add(new Plan(3, "plan3", "2025-04-01"));
//        plans.add(new Plan(4, "plan4", "2030-04-01"));
//        plans.add(new Plan(5, "plan5", "2030-04-01"));
//        plans.add(new Plan(6, "plan6", "2030-04-01"));
//        PlanAdapter adapter = new PlanAdapter(getActivity().getApplicationContext(), 0, plans);
//        mPlanListView.setAdapter(adapter);
        mPlanRepository.getAll(new BaseCallback<List<Plan>>() {
            @Override
            public void onSuccess(List<Plan> plans) {
                if (plans.size() > 0) {
                    PlanAdapter adapter = new PlanAdapter(getActivity().getApplicationContext(), 0, plans);
                    mPlanListView.setAdapter(adapter);
                } else {
                    mListener.goToIntro();
                }
            }

            @Override
            public void onFailure() {
                mListener.goToIntro();
            }
        });
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.fab)
    public void onFabClick(View v) {
        mListener.goToCreatePlan();
    }

    public interface InteractionListener {
        public void goToCreatePlan();

        public void goToIntro();
    }

}
