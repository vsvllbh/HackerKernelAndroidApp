package com.sample.hackerkernelandroidapp;

import java.io.Serializable;

public class SpinnerPojo implements Serializable {

    private String id;
    private String Name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
