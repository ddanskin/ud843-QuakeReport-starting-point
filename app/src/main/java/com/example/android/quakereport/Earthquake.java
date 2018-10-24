
package com.example.android.quakereport;

public class Earthquake {
    private String magnitude;
    private String location;
    private String date;
    private String time;


    public Earthquake(String eMagnitude, String eLocation, String eDate, String eTime) {
        magnitude = eMagnitude;
        location = eLocation;
        date = eDate;
        time = eTime;

    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getMagnitude() {
        return magnitude;
    }
}