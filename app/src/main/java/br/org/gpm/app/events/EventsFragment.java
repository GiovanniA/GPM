package br.org.gpm.app.events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.org.gpm.app.R;
import br.org.gpm.app.routing.NavigationFragment;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fabio.munhoz on 30/07/2016.
 */
public class EventsFragment extends NavigationFragment {
    private List<Event> eventList;
    private RecyclerView recyclerView;
    private EventsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setFragmentId(R.string.events_title, R.layout.fragment_events);
        this.setTitle();

        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(this.getFragmentId(), container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.event_recycler_view);
        adapter = new EventsAdapter(eventList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return v;
    }

    private void loadData() {
        eventList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            Event e = new Event();
            e.setTitle("Event " + i);
            e.setType("Type Event " + i);
            e.setDate(new Date());

            eventList.add(e);
        }
    }
}
