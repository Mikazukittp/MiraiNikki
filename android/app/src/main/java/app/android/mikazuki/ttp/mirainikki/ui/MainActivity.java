package app.android.mikazuki.ttp.mirainikki.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import app.android.mikazuki.ttp.mirainikki.R;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.CreatePlanFragment;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.MainActivityFragment;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.PlanListFragment;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.SignUpFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.InteractionListener, PlanListFragment.InteractionListener, CreatePlanFragment.InteractionListener,SignUpFragment.InteractionListener {

    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new PlanListFragment();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void goToPlanList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 遷移先のFragmentを指定
        Fragment fragment = new PlanListFragment();
        //
        transaction.replace(R.id.fragment_container, fragment);
        Log.d("mylog", "MainActivity#goToPlanList");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void goToIntroduction() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 遷移先のFragmentを指定
        Fragment fragment = new MainActivityFragment();
        //
        transaction.replace(R.id.fragment_container, fragment);
        Log.d("mylog", "MainActivity#goToCreatePlan");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void goToCreatePlan() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 遷移先のFragmentを指定
        Fragment fragment = new CreatePlanFragment();
        //
        transaction.replace(R.id.fragment_container, fragment);
        Log.d("mylog", "MainActivity#goToCreatePlan");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void goToSignUp() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 遷移先のFragmentを指定
        Fragment fragment = new SignUpFragment();
        //
        transaction.replace(R.id.fragment_container, fragment);
        Log.d("mylog", "MainActivity#goToSignUp");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
