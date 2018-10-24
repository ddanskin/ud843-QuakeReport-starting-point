
package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;
    private String url;


    public Earthquake(double eMagnitude, String eLocation, long eMilliseconds, String eUrl) {
        magnitude = eMagnitude;
        location = eLocation;
        date = eMilliseconds;
        url = eUrl;
    }

    public String getLocation() {
        return location;
    }

    public long getDate() {
        return date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getUrl() {
        return url;
    }
}