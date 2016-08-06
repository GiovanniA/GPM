package br.org.gpm.app.events;

import java.util.Date;

/**
 * Created by fabio.munhoz on 06/08/2016.
 */
public class Event {
    private String title;
    private String type;
    private Date date;
    private String place;
    private int interested;
    private int openedPositions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getInterested() {
        return interested;
    }

    public void setInterested(int interested) {
        this.interested = interested;
    }

    public int getOpenedPositions() {
        return openedPositions;
    }

    public void setOpenedPositions(int openedPositions) {
        this.openedPositions = openedPositions;
    }
}
