package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.wre.yin.whiterabbiteventapp.beans.EventBean;
import com.wre.yin.whiterabbiteventapp.beans.ParticipantEventBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.DirectionsJSONParser;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    GoogleMap map;
    Bundle b;
    ArrayList<LatLng> markerPoints;
    double destLatitude = 18.320491;
    double destLongitude = 80.241609;
    double sourceLatitude, sourceLongitude;
    GPSTracker gpsTracker;
    private TextView inviteTime, inviteDate, inviteAddress;
    private boolean mPermissionDenied = false;

    private Button yesButton, noButton, maybeButtun;
    private String eventId, partId;
    private ImageView qrCodeImage;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // DetailsActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);

        setContentView(R.layout.activity_details);

        String nameTxt = getIntent().getExtras().getString("name");

        markerPoints = new ArrayList<LatLng>();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        eventId = getIntent().getExtras().getString("eventId");
        prefs = getSharedPreferences("Chat", 0);
        partId = prefs.getString("partId", null);

        inviteTime = (TextView) findViewById(R.id.invite_time);
        inviteDate = (TextView) findViewById(R.id.invite_date);
        inviteAddress = (TextView) findViewById(R.id.invite_address_text);
        qrCodeImage = (ImageView) findViewById(R.id.invite_qr_image);
        if (Constants.isNetworkAvailable(DetailsActivity.this)) {
            new MyAsyncTask(Constants.ABOUT_EVENT + eventId + "&type=app", null, DetailsActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    EventBean eventBean = Utils.getObject(result, EventBean.class);
                    if (eventBean != null) {
                        inviteTime.setText(eventBean.getEventTime());
                        inviteDate.setText(eventBean.getDate());
                        inviteAddress.setText(eventBean.getEventAddress());
                    }
                }
            }).execute();
        } else {
            Constants.createDialogSend(DetailsActivity.this, "error", "Please connect to internet");
        }

        yesButton = (Button) findViewById(R.id.partStatusYes);
        noButton = (Button) findViewById(R.id.partStatusNo);
        maybeButtun = (Button) findViewById(R.id.partStatusMaybe);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStatus("Yes");
                /*EventDashboardActivity.attendStatus.setText("I will attend");
                EventDashboardActivity.attendStatus.setTextColor(Color.GREEN);*/
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStatus("No");
            }
        });
        maybeButtun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStatus("MayBe");
            }
        });

        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);


        gpsTracker = new GPSTracker(DetailsActivity.this);
        if (gpsTracker.isGPSEnabled) {
            Location loc = gpsTracker.getLocation();
            sourceLatitude = gpsTracker.getLatitude();
            sourceLongitude = gpsTracker.getLongitude();
        } else {
            gpsTracker.showSettingsAlert();
        }

        map = fm.getMap();
        if (map != null) {

            // Getting Map for the SupportMapFragment


            // Enable MyLocation Button in the Map

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            map.setMyLocationEnabled(true);
            LatLng latLan = new LatLng(destLatitude, destLongitude);
            MarkerOptions option = new MarkerOptions();
            option.position(latLan);
            option.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            //CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLan, 15);
            //map.animateCamera(yourLocation);
            map.addMarker(option);

            LatLng sourceLatLan = new LatLng(sourceLatitude, sourceLongitude);
            MarkerOptions sourceOption = new MarkerOptions();
            option.position(sourceLatLan);
            option.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(sourceLatLan, 18);
            map.animateCamera(yourLocation);
            map.addMarker(option);

            String url = getDirectionsUrl(sourceLatLan, latLan);

            DownloadTask downloadTask = new DownloadTask();

            // Start downloading json data from Google Directions API
            downloadTask.execute(url);
        }
    }

    public void saveStatus(String status) {
        if (Constants.isNetworkAvailable(DetailsActivity.this)) {
            ParticipantEventBean participantEventBean = new ParticipantEventBean();
            participantEventBean.setEventId(Long.parseLong(eventId));
            participantEventBean.setParticipantId(Long.parseLong(partId));
            participantEventBean.setStatus(status);
            new MyAsyncTask(Constants.PARTICIPANT_EVENT_STATUS, Utils.getJson(participantEventBean), DetailsActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    String res = Utils.getString("result", result);
                    if (res.equals("suucess")) {
                        Toast.makeText(DetailsActivity.this, "Your status has been submitted successfully...", Toast.LENGTH_LONG).show();

                    }
                }
            }).execute();
        } else {
            Constants.createDialogSend(DetailsActivity.this, "error", "Please connect to internet");
        }
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;


        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;


        return url;
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            //Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
             //   DetailsActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  DetailsActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            try {
                for (int i = 0; i < result.size(); i++) {
                    points = new ArrayList<LatLng>();
                    lineOptions = new PolylineOptions();

                    // Fetching i-th route
                    List<HashMap<String, String>> path = result.get(i);

                    // Fetching all the points in i-th route
                    for (int j = 0; j < path.size(); j++) {
                        HashMap<String, String> point = path.get(j);

                        double lat = Double.parseDouble(point.get("lat"));
                        double lng = Double.parseDouble(point.get("lng"));
                        LatLng position = new LatLng(lat, lng);

                        points.add(position);
                    }

                    // Adding all the points in the route to LineOptions
                    lineOptions.addAll(points);
                    lineOptions.width(4);
                    lineOptions.color(Color.BLUE);

                }

                // Drawing polyline in the Google Map for the i-th route
                // map.addPolyline(lineOptions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
