package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        DecimalFormat decimalFormatter = new DecimalFormat("0.0");
        String magnitude = decimalFormatter.format(currentEarthquake.getMagnitude());
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.earthquake_magnitude);
        magnitudeTextView.setText(magnitude);

        TextView distanceTextView = (TextView) listItemView.findViewById(R.id.earthquake_distance);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.earthquake_location);

        String location = currentEarthquake.getLocation();
        String[] locationData = location.split("of");

        if (locationData.length == 2) {
            distanceTextView.setText(locationData[0] + "of");
            locationTextView.setText(locationData[1]);
        } else {
            distanceTextView.setText("Near the");
            locationTextView.setText(locationData[0]);
        }

        Date dateObject = new Date(currentEarthquake.getDate());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String date = dateFormatter.format(dateObject);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.earthquake_date);
        dateTextView.setText(date);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm  a");
        String time = timeFormatter.format(dateObject);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.earthquake_time);
        timeTextView.setText(time);


        return listItemView;
    }
}