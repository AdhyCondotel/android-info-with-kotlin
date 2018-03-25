package com.android.kc.digitalinfo;

/**
 * Created by ammase on 3/6/18.
 */

public class DataPojo {
    private String Title, update, tema, room, tgl;

    public DataPojo() {
    }

    public DataPojo(String Title, String update, String tema, String room, String tgl) {
        this.Title = Title;
        this.update = update;
        this.tema = tema;
        this.room = room;
        this.tgl = tgl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}
