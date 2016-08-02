package br.org.gpm.app.routing;

import android.util.Log;
import android.view.MenuItem;
import br.org.gpm.app.R;
import br.org.gpm.app.courses.CoursesFragment;
import br.org.gpm.app.events.EventsFragment;
import br.org.gpm.app.galery.GaleryFragment;
import br.org.gpm.app.trails.TrailsFragment;
import br.org.gpm.app.utilities.UtilitiesFragment;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public class MenuNavigationRouter implements NavigationRouter {
    @Override
    public NavigationFragment routeItem(MenuItem menuItem) {
        int id = menuItem.getItemId();
        Log.d("routing", "Menu Routing to :" + id);

        NavigationFragment fragment = null;

        switch (id) {
            case R.id.nav_events:
                fragment = new EventsFragment();
                break;
            case R.id.nav_gallery:
                fragment = new GaleryFragment();
                break;
            case R.id.nav_courses:
                fragment = new CoursesFragment();
                break;
            case R.id.nav_utilities:
                fragment = new UtilitiesFragment();
                break;
            case R.id.nav_maps:
                fragment = new TrailsFragment();
                break;
            case R.id.nav_facebook:
                break;
            case R.id.nav_site:
                break;
            default:
                Log.e("routing", "Error routing to option: " + id);
                break;
        }

        return fragment;
    }
}
