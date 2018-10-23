
package com.example.android.quakereport;

public class Earthquake {
    private String location;
    private String date;
    private double magnitude;

    public Earthquake(String eLocation, String eDate, double eMagnitude) {
        location = eLocation;
        date = eDate;
        magnitude = eMagnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getMagnitude() {
        return String.valueOf(magnitude);
    }
}