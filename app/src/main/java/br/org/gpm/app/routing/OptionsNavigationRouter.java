package br.org.gpm.app.routing;

import android.util.Log;
import android.view.MenuItem;
import br.org.gpm.app.R;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public class OptionsNavigationRouter implements NavigationRouter {
    @Override
    public NavigationFragment routeItem(MenuItem menuItem) {
        int id = menuItem.getItemId();
        Log.d("routing", "Option Routing to :" + id);

        NavigationFragment fragment = null;

        switch (id) {
            case R.id.action_settings:
                fragment = new NavigationFragment();
                break;
            default:
                Log.e("routing", "Error routing to option: " + id);
                break;
        }

        return fragment;
    }
}
