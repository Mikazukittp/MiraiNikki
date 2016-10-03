package app.android.mikazuki.ttp.mirainikki.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import app.android.mikazuki.ttp.mirainikki.R;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.CreatePlanFragment;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.IntroFragment;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.PlanListFragment;
import app.android.mikazuki.ttp.mirainikki.ui.fragment.SignUpFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ToolBarListener, PlanListFragment.InteractionListener, CreatePlanFragment.InteractionListener, SignUpFragment.InteractionListener, IntroFragment.InteractionListener {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation)
    NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private boolean network;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        setSupportActionBar(mToolbar);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
////        mDrawerToggle.setDrawerIndicatorEnabled(true);
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        final ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayShowHomeEnabled(true);
//        }
//        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "yeah!!!", Toast.LENGTH_SHORT).show();
//            }
//        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.account) {
                    menuItem.setChecked(true);
//                    Intent i = new Intent(UserActivity.this, PresentationActivity.class);
//                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(i);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new PlanListFragment())
                .commit();
    }

    @Override
    public void goToPlanList() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new PlanListFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToCreatePlan() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new CreatePlanFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToSignUp() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SignUpFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToIntro() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new IntroFragment())
                .commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMenuClick() {
        Toast.makeText(getApplicationContext(), "yeah!!!", Toast.LENGTH_SHORT).show();
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

}

