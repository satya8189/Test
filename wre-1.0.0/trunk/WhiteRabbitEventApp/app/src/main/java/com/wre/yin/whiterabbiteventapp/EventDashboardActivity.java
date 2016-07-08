package com.wre.yin.whiterabbiteventapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderViewDashboard;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.wre.yin.whiterabbiteventapp.adapters.CustomGridViewAdapter;
import com.wre.yin.whiterabbiteventapp.beans.EventBean;
import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.beans.Item;
import com.wre.yin.whiterabbiteventapp.beans.ParticipantEventBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDashboardActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private GridView gridView;
    private ArrayList<Item> gridArray = new ArrayList<Item>();
    private CustomGridViewAdapter customGridAdapter;
    private SliderLayout mDemoSlider;
    private ImageView backImg;
    public static TextView eventIdTxt, eventDateTime, noOfParticipanta, attendStatus;
    private String eventId, eventDate, eventName, partId;
    private boolean mPermissionDenied = false;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    private GoogleApiClient client;

    private List<String> galleryList;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EventDashboardActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_event_dashboard);


        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        backImg = (ImageView) findViewById(R.id.back_imag);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));*/
        getSupportActionBar().hide();
        prefs = getSharedPreferences("Chat", 0);
        partId = prefs.getString("partId", null);
        eventId = prefs.getString("eventId", null);
        eventDate = prefs.getString("eventDate", null);
        eventName = prefs.getString("eventName", null);
        if (Constants.checkAndRequestPermissions(this)) {
        }
        /*eventId = getIntent().getExtras().getString("eventId");
        eventDate = getIntent().getExtras().getString("date");
        eventName = getIntent().getExtras().getString("eventName");*/

        galleryList = new ArrayList<>();

        noOfParticipanta = (TextView) findViewById(R.id.noof_users);
        attendStatus = (TextView) findViewById(R.id.attendence_status);
        eventIdTxt = (TextView) findViewById(R.id.event_name);
        eventIdTxt.setText(eventName);
        eventDateTime = (TextView) findViewById(R.id.event_time_date);
        eventDateTime.setText(eventDate);
        if (Constants.isNetworkAvailable(EventDashboardActivity.this)) {
            new MyAsyncTask(Constants.ATTENDENCE_STATUS + eventId + "&participantId=" + partId, null, EventDashboardActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    if (result != null)
                        if (result.equals("Yes")) {
                            attendStatus.setText("I will attend");
                            attendStatus.setTextColor(Color.BLUE);
                        } else if (result.equals("No")) {
                            attendStatus.setText("I will not attend");
                            attendStatus.setTextColor(Color.RED);
                        } else if (result.equals("MayBe")) {
                            attendStatus.setText("Maybe I will attend");
                            attendStatus.setTextColor(Color.BLACK);
                        } else {
                            attendStatus.setText("Not yet deside");
                            attendStatus.setTextColor(Color.BLUE);
                        }

                }
            }).execute();
        } else {
            Constants.createDialogSend(EventDashboardActivity.this, "error", "Please connect to internet");
        }
        if (Constants.isNetworkAvailable(EventDashboardActivity.this)) {

            new MyAsyncTask(Constants.PARTICIPANT_LIST + "?eventId=" + eventId + "&status=ACTIVE", null, EventDashboardActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    List<ParticipantEventBean> participantEventBeanList = Utils.getList(result, ParticipantEventBean.class);
                    noOfParticipanta.setText("Users " + participantEventBeanList.size());

                }
            }).execute();
        } else {
            Constants.createDialogSend(EventDashboardActivity.this, "error", "Please connect to internet");
        }
        if (Constants.isNetworkAvailable(EventDashboardActivity.this)) {

            new MyAsyncTask(Constants.EVENT_IMAGES + "?eventId=" + eventId + "&type=event_images", null, EventDashboardActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    List<GalaryBean> galaryBeenList = Utils.getList(result, GalaryBean.class);
                    if (galaryBeenList != null) {
                        for (GalaryBean bean : galaryBeenList) {
                            galleryList.add(Constants.BASE_URL + bean.getUrl());
                        }
                        for (String name : galleryList) {
                            TextSliderViewDashboard textSliderView = new TextSliderViewDashboard(EventDashboardActivity.this);
                            // initialize a SliderLayout
                            textSliderView
                                    .description("")
                                    .image(name)
                                    .setScaleType(BaseSliderView.ScaleType.Fit)
                                    .setOnSliderClickListener(EventDashboardActivity.this);

                            //add your extra information
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle()
                                    .putString("extra", name);

                            mDemoSlider.addSlider(textSliderView);
                            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);

                        }
                    }

                }
            }).execute();
        } else {
            Constants.createDialogSend(EventDashboardActivity.this, "error", "Please connect to internet");
        }

        if (Constants.isNetworkAvailable(EventDashboardActivity.this)) {

            new MyAsyncTask(Constants.EVENT_SERVICES_LIST + eventId, null, EventDashboardActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    List<EventBean> eventBeenList = Utils.getList(result, EventBean.class);
                    if (eventBeenList != null) {
                        gridArray.add(new Item(2, "Invite"));
                        EventBean evBean = eventBeenList.get(eventBeenList.size() - 1);

                        for (EventBean bean : eventBeenList) {

                            if (bean.getOrder() < 17) {
                                if (bean.getOrder() == 5 && evBean.getServiceId() == 21)
                                    gridArray.add(new Item(18, evBean.getServiceName()));
                                if (bean.getServiceId() != 17)
                                    gridArray.add(new Item((int) (long) bean.getOrder(), bean.getServiceName()));
                            }
                        }
                        gridArray.add(new Item(17, "Profile"));
                        gridView = (GridView) findViewById(R.id.grid);
                        customGridAdapter = new CustomGridViewAdapter(EventDashboardActivity.this, R.layout.row_grid, gridArray);
                        gridView.setAdapter(customGridAdapter);

                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if (Constants.isNetworkAvailable(EventDashboardActivity.this)) {
                                    String name = gridArray.get(position).getTitle().toString();
                                    int indexId = gridArray.get(position).getId();
                                    //  Toast.makeText(getApplicationContext(), gridArray.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                                    switch (indexId) {
                                        case 1:
                                            Intent aboutEventAct = new Intent(EventDashboardActivity.this, AboutEventActivity.class);
                                            aboutEventAct.putExtra("name", name);
                                            aboutEventAct.putExtra("eventId", eventId);
                                            startActivity(aboutEventAct);
                                            break;
                                        case 2:
                                            if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                                                Intent detailsAct = new Intent(EventDashboardActivity.this, DetailsActivity.class);
                                                detailsAct.putExtra("name", name);
                                                detailsAct.putExtra("eventId", eventId);
                                                startActivity(detailsAct);
                                                finish();
                                            }
                                            break;

                                        case 3:
                                            Intent agendaAct = new Intent(EventDashboardActivity.this, AgendaActivity.class);
                                            agendaAct.putExtra("name", name);
                                            agendaAct.putExtra("eventId", eventId);
                                            startActivity(agendaAct);
                                            break;

                                        case 4:
                                            Intent newsaAct = new Intent(EventDashboardActivity.this, NewsFeedActivity.class);
                                            newsaAct.putExtra("name", name);
                                            newsaAct.putExtra("eventId", eventId);
                                            startActivity(newsaAct);
                                            break;
                                        case 16:
                                            if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                                                Intent galleryAct = new Intent(EventDashboardActivity.this, HelpActivity.class);
                                                galleryAct.putExtra("name", name);
                                                galleryAct.putExtra("eventId", eventId);
                                                startActivity(galleryAct);
                                            }
                                            break;
                                        case 5:
                                            if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                                                Intent crowdAct = new Intent(EventDashboardActivity.this, GalleryNewActivity.class);
                                                crowdAct.putExtra("name", name);
                                                crowdAct.putExtra("eventId", eventId);
                                                startActivity(crowdAct);
                                            }
                                            break;
                                        case 18:
                                            if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                                                Intent crowdAct = new Intent(EventDashboardActivity.this, CrowdPicsActivity.class);
                                                crowdAct.putExtra("name", name);
                                                crowdAct.putExtra("eventId", eventId);
                                                startActivity(crowdAct);
                                            }
                                            break;
                                        case 6:
                                            if (Constants.checkAndRequestPermissions(EventDashboardActivity.this)) {
                                                Intent videosAct = new Intent(EventDashboardActivity.this, VideosActivity.class);
                                                videosAct.putExtra("name", name);
                                                videosAct.putExtra("eventId", eventId);
                                                startActivity(videosAct);
                                            }
                                            break;

                                        case 7:
                                            Intent docShareAct = new Intent(EventDashboardActivity.this, DocShareActivity.class);
                                            docShareAct.putExtra("name", name);
                                            docShareAct.putExtra("eventId", eventId);
                                            startActivity(docShareAct);
                                            break;
                                        case 17:
                                            Intent qaAct = new Intent(EventDashboardActivity.this, EmpProfileActivity.class);
                                            qaAct.putExtra("name", name);
                                            qaAct.putExtra("eventId", eventId);
                                            startActivity(qaAct);
                                            break;
                                        case 8:
                                            Intent messageAct = new Intent(EventDashboardActivity.this, DiscoTopics.class);
                                            messageAct.putExtra("name", name);
                                            messageAct.putExtra("eventId", eventId);
                                            startActivity(messageAct);
                                            break;
                                        case 9:
                                            Intent surveyAct = new Intent(EventDashboardActivity.this, SurveyActivity.class);
                                            surveyAct.putExtra("name", name);
                                            surveyAct.putExtra("eventId", eventId);
                                            startActivity(surveyAct);
                                            break;

                                        case 10:
                                            Intent qrCodeAct = new Intent(EventDashboardActivity.this, QRCodeActivity.class);
                                            qrCodeAct.putExtra("name", name);
                                            qrCodeAct.putExtra("eventId", eventId);
                                            startActivity(qrCodeAct);
                                            break;
                                        case 11:
                                            Intent socialAct = new Intent(EventDashboardActivity.this, SocialMediaActivity.class);
                                            socialAct.putExtra("name", name);
                                            socialAct.putExtra("eventId", eventId);
                                            startActivity(socialAct);
                                            break;
                                        case 12:
                                            Intent networkAct = new Intent(EventDashboardActivity.this, NetworkingActivity.class);
                                            networkAct.putExtra("name", name);
                                            networkAct.putExtra("eventId", eventId);

                                            startActivity(networkAct);
                                            break;
                                        case 13:
                                            Intent venueAct = new Intent(EventDashboardActivity.this, VenueActivity.class);
                                            venueAct.putExtra("name", name);
                                            venueAct.putExtra("eventId", eventId);
                                            startActivity(venueAct);
                                            break;

                                        case 14:
                                            Intent sponcersAct = new Intent(EventDashboardActivity.this, SponcersActivity.class);
                                            sponcersAct.putExtra("name", name);
                                            sponcersAct.putExtra("eventId", eventId);
                                            startActivity(sponcersAct);
                                            break;
                                        case 15:
                                            Intent speakerAct = new Intent(EventDashboardActivity.this, SpeakerProfileActivity.class);
                                            speakerAct.putExtra("name", name);
                                            speakerAct.putExtra("eventId", eventId);
                                            startActivity(speakerAct);
                                            break;

                                    }

                                } else {
                                    Constants.createDialogSend(EventDashboardActivity.this, "error", "Please connect to internet");
                                }

                            }

                        });

                    }
                }

            }).execute();

        } else {
            Constants.createDialogSend(EventDashboardActivity.this, "error", "Please connect to internet");
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //  EventDashboardActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EventDashboard Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.wre.yin.whiterabbiteventapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EventDashboard Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.wre.yin.whiterabbiteventapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //  EventDashboardActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        /*Intent refresh = new Intent(EventDashboardActivity.this, EventDashboardActivity.class);

        startActivity(refresh);
        this.finish();*/
    }
}
