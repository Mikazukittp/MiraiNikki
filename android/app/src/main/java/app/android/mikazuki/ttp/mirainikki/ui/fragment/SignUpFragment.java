package app.android.mikazuki.ttp.mirainikki.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.android.mikazuki.ttp.mirainikki.R;


public class SignUpFragment extends Fragment {

    private InteractionListener mListener;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("mylog", "SignUpFragment");

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        Button bt = (Button) view.findViewById(R.id.submitUserInfoButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mylog", "SignUpFragment#onClick");
                mListener.goToPlanList();
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
        public void goToPlanList();
    }

}
