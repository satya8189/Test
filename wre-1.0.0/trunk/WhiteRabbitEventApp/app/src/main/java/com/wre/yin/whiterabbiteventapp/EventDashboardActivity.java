package com.wre.yin.whiterabbiteventapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderViewDashboard;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.wre.yin.whiterabbiteventapp.adapters.CustomGridViewAdapter;
import com.wre.yin.whiterabbiteventapp.beans.Item;
import com.wre.yin.whiterabbiteventapp.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventDashboardActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private GridView gridView;
    private ArrayList<Item> gridArray = new ArrayList<Item>();
    private CustomGridViewAdapter customGridAdapter;
    private SliderLayout mDemoSlider;
    private TextView eventNameTxt;
    private String eventName;
    private boolean mPermissionDenied = false;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dashboard);


        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();

        if (Constants.checkAndRequestPermissions(this)) {

        }
        eventName = getIntent().getExtras().getString("eventName");
        eventNameTxt = (TextView) findViewById(R.id.event_name);
        eventNameTxt.setText(eventName + " Event");

        // mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Event 1", R.drawable.event_image1);
        file_maps.put("Event 2", R.drawable.event_image2);
        file_maps.put("Event 3", R.drawable.event_image3);


        for (String name : file_maps.keySet()) {
            TextSliderViewDashboard textSliderView = new TextSliderViewDashboard(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }

        //set grid view item
        Bitmap deatailIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.details_pic);
        Bitmap agendaIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.agenda_pic);
        Bitmap newsIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.news_feed_pic);
        Bitmap galleryIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.gallery_pic);
        Bitmap crowdIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.crowd_pic);
        Bitmap videoIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.videos_pic);
        Bitmap docIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.doc_pic);
        Bitmap qaIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.qa_pic);
        Bitmap messageIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.message_pic);
        Bitmap surveyIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.survey_pic);
        Bitmap qrIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.qr_pic);
        Bitmap socialIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.social_pic);
        Bitmap networkIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.net_pic);
        Bitmap venueIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.venue_pic);
        Bitmap sponsorsIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.sponsors_pic);
        Bitmap speakerIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.speaker_pic);
        Bitmap inviteIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.invite_pic);

        gridArray.add(new Item(deatailIcon, "Details"));
        gridArray.add(new Item(inviteIcon, "Invite"));
        gridArray.add(new Item(agendaIcon, "Agenda"));
        gridArray.add(new Item(newsIcon, "News Feed"));
        gridArray.add(new Item(galleryIcon, "Gallery"));
        gridArray.add(new Item(crowdIcon, "Crowd Pics"));
        gridArray.add(new Item(videoIcon, "Videos"));
        gridArray.add(new Item(docIcon, "Doc's Sharing"));
        gridArray.add(new Item(qaIcon, "Q & A"));
        gridArray.add(new Item(messageIcon, "Message Board"));
        gridArray.add(new Item(surveyIcon, "Surveys"));
        gridArray.add(new Item(qrIcon, "QR Code"));
        gridArray.add(new Item(socialIcon, "Social Media"));
        gridArray.add(new Item(networkIcon, "Networking"));
        gridArray.add(new Item(venueIcon, "Venue Layout"));
        gridArray.add(new Item(sponsorsIcon, "Sponsors"));
        gridArray.add(new Item(speakerIcon, "Speaker Profile"));


        gridView = (GridView) findViewById(R.id.grid);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = gridArray.get(position).getTitle().toString();
                //  Toast.makeText(getApplicationContext(), gridArray.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        Intent aboutEventAct = new Intent(EventDashboardActivity.this, AboutEventActivity.class);
                        aboutEventAct.putExtra("name", name);
                        startActivity(aboutEventAct);
                        break;
                    case 1:
                        if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                            Intent detailsAct = new Intent(EventDashboardActivity.this, DetailsActivity.class);
                            detailsAct.putExtra("name", name);
                            startActivity(detailsAct);
                        }
                        break;

                    case 2:
                        Intent agendaAct = new Intent(EventDashboardActivity.this, AgendaActivity.class);
                        agendaAct.putExtra("name", name);
                        startActivity(agendaAct);
                        break;

                    case 3:
                        Intent newsaAct = new Intent(EventDashboardActivity.this, NewsFeedActivity.class);
                        newsaAct.putExtra("name", name);
                        startActivity(newsaAct);
                        break;
                    case 4:
                        if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                            Intent galleryAct = new Intent(EventDashboardActivity.this, GalleryActivity.class);
                            galleryAct.putExtra("name", name);
                            startActivity(galleryAct);
                        }
                        /*if (isStoragePermissionGranted()) {
                            Intent galleryAct = new Intent(EventDashboardActivity.this, GalleryActivity.class);
                            galleryAct.putExtra("name", name);
                            startActivity(galleryAct);
                        }*/
                        break;
                    case 5:
                        if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                            Intent crowdAct = new Intent(EventDashboardActivity.this, CrowdPicsActivity.class);
                            crowdAct.putExtra("name", name);
                            startActivity(crowdAct);
                        }
                        break;
                    case 6:
                        if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                            Intent videosAct = new Intent(EventDashboardActivity.this, VideosActivity.class);
                            videosAct.putExtra("name", name);
                            startActivity(videosAct);
                        }
                        break;

                    case 7:
                        Intent docShareAct = new Intent(EventDashboardActivity.this, DocShareActivity.class);
                        docShareAct.putExtra("name", name);
                        startActivity(docShareAct);
                        break;
                    case 8:
                        Intent qaAct = new Intent(EventDashboardActivity.this, QAActivity.class);
                        qaAct.putExtra("name", name);
                        startActivity(qaAct);
                        break;
                    case 9:
                        Intent messageAct = new Intent(EventDashboardActivity.this, MessageActivity.class);
                        messageAct.putExtra("name", name);
                        startActivity(messageAct);
                        break;
                    case 10:
                        Intent surveyAct = new Intent(EventDashboardActivity.this, SurveyActivity.class);
                        surveyAct.putExtra("name", name);
                        startActivity(surveyAct);
                        break;

                    case 11:
                        Intent qrCodeAct = new Intent(EventDashboardActivity.this, QRCodeActivity.class);
                        qrCodeAct.putExtra("name", name);
                        startActivity(qrCodeAct);
                        break;
                    case 12:
                        Intent socialAct = new Intent(EventDashboardActivity.this, SocialMediaActivity.class);
                        socialAct.putExtra("name", name);
                        startActivity(socialAct);
                        break;
                    case 13:
                        Intent networkAct = new Intent(EventDashboardActivity.this, NetworkingActivity.class);
                        networkAct.putExtra("name", name);
                        startActivity(networkAct);
                        break;
                    case 14:
                        Intent venueAct = new Intent(EventDashboardActivity.this, VenueActivity.class);
                        venueAct.putExtra("name", name);
                        startActivity(venueAct);
                        break;

                    case 15:
                        Intent sponcersAct = new Intent(EventDashboardActivity.this, SponcersActivity.class);
                        sponcersAct.putExtra("name", name);
                        startActivity(sponcersAct);
                        break;
                    case 16:
                        Intent speakerAct = new Intent(EventDashboardActivity.this, SpeakerProfileActivity.class);
                        speakerAct.putExtra("name", name);
                        startActivity(speakerAct);
                        break;

                }

            }
        });

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    /*****
     * Never ask again  permissions call back code start
     ****/
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // Log.d(TAG, "Permission callback called-------");
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {

                Map<String, Integer> perms = new HashMap<>();
                // Initialize the map with both permissions
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                // Fill with actual results from user
                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);
                    // Check for both permissions
                    if (perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        // Log.d(TAG, "sms & location services permission granted");
                        // process the normal flow
                        //else any one or both the permissions are not granted
                    } else {
                        // Log.d(TAG, "Some permissions are not granted ask again ");
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                            showDialogOK("Storage and Location Services Permission required for this app",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    Constants.checkAndRequestPermissions(EventDashboardActivity.this);
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
                                                    // proceed with logic by disabling the related features or quit the app.
                                                    break;
                                            }
                                        }
                                    });
                        }
                        //permission is denied (and never ask again is  checked)
                        //shouldShowRequestPermissionRationale will return false
                        else {
                            Toast.makeText(this, "Go to settings and enable app permissions", Toast.LENGTH_LONG)
                                    .show();
                            //proceed with logic by disabling the related features or quit the app.
                        }
                    }
                }
            }
        }

    }
//   Show dialog permissions Again

    private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

    /***
     * Never ask again  permissions call back code end
     ***/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
