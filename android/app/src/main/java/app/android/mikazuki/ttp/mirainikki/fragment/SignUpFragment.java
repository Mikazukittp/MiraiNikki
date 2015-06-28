package app.android.mikazuki.ttp.mirainikki.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.android.mikazuki.ttp.mirainikki.R;


public class SignUpFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Intent intent = getIntent();
    }

    public void submitUserInfo(View view) {
        Intent intent = new Intent(this, PlanListFragment.class);
        startActivity(intent);
    }
}
