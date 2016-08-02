package br.org.gpm.app.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.org.gpm.app.MainActivity;
import br.org.gpm.app.R;
import br.org.gpm.app.routing.NavigationFragment;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public class LoginFragment extends NavigationFragment {
    private MainActivity mainActivity;
    private int appBarHeight = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setFragmentId(R.string.login_title, R.layout.fragment_login);
        this.setTitle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(this.getFragmentId(), container, false);

        this.toggleAppBarHeight();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getActivity().findViewById(R.id.login_facebook).setOnClickListener(this);
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_facebook:
                routeToApp();
                break;
            default:
                Log.e("login", "Invalid button clicked.");
                break;
        }
    }

    private void routeToApp() {
        this.toggleAppBarHeight();

        FragmentManager fm = mainActivity.getSupportFragmentManager();
        fm.popBackStack();

        Toolbar toolbar = (Toolbar) mainActivity.findViewById(R.id.toolbar);
        mainActivity.setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) mainActivity.findViewById(R.id.drawer_layout);

        if (drawer != null) {
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    mainActivity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) mainActivity.findViewById(R.id.nav_view);

            if (navigationView != null) {
                navigationView.setNavigationItemSelectedListener(mainActivity);
            } else {
                Log.e("main", "naviagionView not found for id: " + R.id.nav_view);
            }
        } else {
            Log.e("main", "drawer not found for id: " + R.id.drawer_layout);
        }
    }

    private void toggleAppBarHeight() {
        View appBar = mainActivity.findViewById(R.id.app_bar);

        if (appBar != null) {
            ViewGroup.LayoutParams layout = appBar.getLayoutParams();

            if (layout != null) {
                int previousHeight = layout.height;
                layout.height = this.appBarHeight;
                this.appBarHeight = previousHeight;

                appBar.setLayoutParams(layout);
            }
        }
    }
}
