
package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;


    public Earthquake(double eMagnitude, String eLocation, long eMilliseconds) {
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

    public double getMagnitude() {
        return magnitude;
    }
}