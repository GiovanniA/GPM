package br.org.gpm.app.routing;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public class NavigationFragment extends Fragment {
    private String title;
    private int fragmentId;
    private int titleId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle() {
        this.title = getString(this.titleId);
    }

    protected int getFragmentId() {
        return fragmentId;
    }

    protected void setFragmentId(int titleId, int fragmentId) {
        this.titleId = titleId;
        this.fragmentId = fragmentId;
    }
}
