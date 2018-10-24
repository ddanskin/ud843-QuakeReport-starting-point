package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
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

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorId = R.color.magnitude9;
                break;
            default:
                magnitudeColorId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorId);
    }
}