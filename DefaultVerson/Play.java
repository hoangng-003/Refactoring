package com.company;

public class Play {

    private String name;
    private String type;
    private int audiance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAudiance() {
        return audiance;
    }

    public String getType() {
        return type;
    }

    public void setAudiance(int audiance) {
        this.audiance = audiance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Play(String name, String type, int audiance) {
        this.audiance = audiance;
        this.name = name;
        this.type = type;

    }
}
