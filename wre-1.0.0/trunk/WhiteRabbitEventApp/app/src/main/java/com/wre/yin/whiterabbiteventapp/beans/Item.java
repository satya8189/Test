package com.wre.yin.whiterabbiteventapp.beans;

/**
 * Created by YINSOL on 5/2/2016.
 */

public class Item {
    int id;
    String title;

    public Item(int id, String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
