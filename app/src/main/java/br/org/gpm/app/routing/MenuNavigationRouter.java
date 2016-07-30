package br.org.gpm.app.routing;

import android.util.Log;
import android.view.MenuItem;
import br.org.gpm.app.R;
import br.org.gpm.app.events.EventsFragment;
import br.org.gpm.app.galery.GaleryFragment;

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
                break;
            case R.id.nav_utilities:
                break;
            case R.id.nav_maps:
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
