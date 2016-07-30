package br.org.gpm.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import br.org.gpm.app.home.HomeFragment;
import br.org.gpm.app.routing.MenuNavigationRouter;
import br.org.gpm.app.routing.NavigationFragment;
import br.org.gpm.app.routing.OptionsNavigationRouter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private MenuNavigationRouter menuNavigationRouter;
    private OptionsNavigationRouter optionsNavigationRouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer != null) {
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

            if (navigationView != null) {
                navigationView.setNavigationItemSelectedListener(this);
            } else {
                Log.e("main", "naviagionView not found for id: " + R.id.nav_view);
            }
        } else {
            Log.e("main", "drawer not found for id: " + R.id.drawer_layout);
        }

        menuNavigationRouter = new MenuNavigationRouter();
        optionsNavigationRouter = new OptionsNavigationRouter();

        routeToNavigationFragment(new HomeFragment());
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount() - 1;

        //TODO: VOLTAR
        if (count <= 0) {
            super.onBackPressed();
            super.onBackPressed();
        } else {
            fragmentManager.popBackStack();
            routeToNavigationFragment(new HomeFragment());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return routeToNavigationFragment(optionsNavigationRouter.routeItem(menuItem));
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return routeToNavigationFragment(menuNavigationRouter.routeItem(menuItem));
    }

    private boolean routeToNavigationFragment(NavigationFragment fragment) {
        if (fragment != null) {
            FragmentManager fm = getSupportFragmentManager();
            int count = fm.getBackStackEntryCount() - 1;
            while (count > 0) {
                fm.popBackStack();
                count--;
            }

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content_frame, fragment, "" + R.id.content_frame);
            ft.addToBackStack(null);
            ft.commit();

            fm.executePendingTransactions();

            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(fragment.getTitle());
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer != null) {
                drawer.closeDrawer(GravityCompat.START);
            }

            return true;
        }

        return false;
    }
}
