package br.org.gpm.app.events;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.org.gpm.app.R;

import java.util.List;

/**
 * Created by fabio.munhoz on 06/08/2016.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {
    private List<Event> eventList;

    public EventsAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    static class EventHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView type;
        TextView date;

        EventHolder(View v) {
            super(v);

            this.title = (TextView) v.findViewById(R.id.event_card_title);
            this.type = (TextView) v.findViewById(R.id.event_card_type);
            this.date = (TextView) v.findViewById(R.id.event_card_date);
        }
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, parent, false);
        return new EventHolder(v);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Event event = eventList.get(position);
        holder.title.setText(event.getTitle());
        holder.type.setText(event.getType());
        holder.date.setText(event.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
