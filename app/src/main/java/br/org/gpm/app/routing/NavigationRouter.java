package br.org.gpm.app.routing;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public interface NavigationRouter {
    Fragment routeItem(MenuItem menuItem);
}
