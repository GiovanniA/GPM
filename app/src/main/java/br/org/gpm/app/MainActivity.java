package br.org.gpm.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import br.org.gpm.app.home.HomeFragment;
import br.org.gpm.app.login.LoginFragment;
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

        menuNavigationRouter = new MenuNavigationRouter();
        optionsNavigationRouter = new OptionsNavigationRouter();

        //TODO: Verificar se usuário está autenticado
        if (false) {
            routeToNavigationFragment(new HomeFragment());
        }
        else {
            LoginFragment login = new LoginFragment();
            login.setMainActivity(this);
            routeToNavigationFragment(login);
        }
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
