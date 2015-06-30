package app.android.mikazuki.ttp.mirainikki.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.android.mikazuki.ttp.mirainikki.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private InteractionListener mListener;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button bt = (Button) view.findViewById(R.id.welcomeButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToPlanList();
            }
        });

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mListener = (InteractionListener)activity;
        }catch(ClassCastException e){
            Log.e("TAG", e.getMessage());
        }
    }

    public interface InteractionListener {
        public void goToPlanList();
    }


}
