
package com.example.android.quakereport;

public class Earthquake {
    private String location;
    private String date;
    private String magnitude;

    public Earthquake(String eLocation, String eDate, String eMagnitude) {
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
        return magnitude;
    }
}