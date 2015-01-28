package com.cainwong.demo.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cwong on 1/27/15.
 */
public class Item {

    public String title;

    public String body;

    public Date date;

    public Item(String title, String body, Date date) {
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public String getDateStr(){
        return (new SimpleDateFormat("MMMM d, yyyy")).format(date);
    }

}
