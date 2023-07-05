package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private ArrayList<Play> playList = new ArrayList<Play>();
    private String name;

    public ArrayList<Play> getPlayList() {
        return playList;
    }

    public String getName() {
        return name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addPlay(Play p) {
        playList.add(p);
    }
}
