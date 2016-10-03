package app.android.mikazuki.ttp.mirainikki.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import app.android.mikazuki.ttp.mirainikki.R;
import app.android.mikazuki.ttp.mirainikki.ui.ToolBarListener;
import butterknife.Bind;
import butterknife.ButterKnife;


public class CreatePlanFragment extends Fragment {


    @Bind(R.id.tool_bar)
    Toolbar mToolbar;
    @Bind(R.id.planDate)
    EditText planDate;
    @Bind(R.id.planContent)
    EditText planContent;
    @Bind(R.id.submitPlanButton)
    Button bt;

    private InteractionListener mListener;
    private ToolBarListener mToolbarListener;

    public CreatePlanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("mylog", "CreatePlanFragment");
        View view = inflater.inflate(R.layout.fragment_create_plan, container, false);
        ButterKnife.bind(this,view);

        mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mToolbarListener.onMenuClick();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (InteractionListener) activity;
            mToolbarListener = (ToolBarListener) activity;
        } catch (ClassCastException e) {
            Log.e("TAG", e.getMessage());
        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface InteractionListener {
        public void goToSignUp();
    }

}
