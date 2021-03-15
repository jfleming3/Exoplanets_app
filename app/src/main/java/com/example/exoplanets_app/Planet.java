package com.example.exoplanets_app;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Planet implements Serializable {

    private String name;
    private String host;
    private String dist;
    private String orbit;
    private String travel;
    private String url;


    public Planet() {
    }


    public Planet(String name, String host, String dist, String orbit, String travel, String url) {
        this.name = name;
        this.host = host;
        this.dist = dist;
        this.orbit = orbit;
        this.travel = travel;
        this.url = url;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
