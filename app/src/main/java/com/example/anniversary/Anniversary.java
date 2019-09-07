package com.example.anniversary;

import java.io.Serializable;
import java.util.Date;

public class Anniversary implements Serializable {

    private String name;
    private Date date;

    public Anniversary() {
    }

    public Anniversary(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
