
package com.example.android.quakereport;

public class Earthquake {
    private String magnitude;
    private String location;
    private long date;


    public Earthquake(String eMagnitude, String eLocation, long eMilliseconds) {
        magnitude = eMagnitude;
        location = eLocation;
        date = eMilliseconds;
    }

    public String getLocation() {
        return location;
    }

    public long getDate() {
        return date;
    }

    public String getMagnitude() {
        return magnitude;
    }
}