package app.android.mikazuki.ttp.mirainikki.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.android.mikazuki.ttp.mirainikki.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroFragment extends Fragment {

    @Bind(R.id.loginLink)
    TextView mLoginLink;
    private InteractionListener mListener;

    public IntroFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_intro, container, false);
        ButterKnife.bind(this, view);
        setLoginLinkText();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.createPlan)
    public void onBtnClick(View v) {
        mListener.goToCreatePlan();
    }

    public interface InteractionListener {
        public void goToCreatePlan();
        public void goToSignUp();
    }


    public void setLoginLinkText() {
        String LOGIN_LINK_TEXT = getString(R.string.relogin);

        final SpannableStringBuilder sb = new SpannableStringBuilder();
        sb.append(LOGIN_LINK_TEXT);
        sb.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                mListener.goToSignUp();
            }
        }, LOGIN_LINK_TEXT.length() - 3, LOGIN_LINK_TEXT.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mLoginLink.setText(sb);
        mLoginLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
