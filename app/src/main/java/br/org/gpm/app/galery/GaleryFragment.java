package br.org.gpm.app.galery;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.org.gpm.app.R;
import br.org.gpm.app.routing.NavigationFragment;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public class GaleryFragment extends NavigationFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setFragmentId(R.string.galery_title, R.layout.fragment_galery);
        this.setTitle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(this.getFragmentId(), container, false);
    }
}
