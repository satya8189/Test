package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.wre.yin.whiterabbiteventapp.beans.ParticipantEventBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.ImageCallBack;
import com.wre.yin.whiterabbiteventapp.utils.LoadImage;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private Target target;
    private ImageView profDetails, singleImageView;
    private RelativeLayout rl1;
    private SharedPreferences prefs;
    private FrameLayout singleEventView;
    private String partiName, partId;
    private TextView partName, singleEvent, singleEventDate;
    private List<HashMap<String, String>> list;
    SharedPreferences.Editor editor;
    private CircleImageView proFic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // HomeActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();


        prefs = getSharedPreferences("Chat", 0);
        editor = prefs.edit();
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        profDetails = (ImageView) findViewById(R.id.profile_details);
        proFic = (CircleImageView) findViewById(R.id.profile_home_pic);
        rl1 = (RelativeLayout) findViewById(R.id.rl1);

        singleEventView = (FrameLayout) findViewById(R.id.ghost_view_workaround);
        singleImageView = (ImageView) findViewById(R.id.single_image);
        singleEvent = (TextView) findViewById(R.id.single_eventname);
        singleEventDate = (TextView) findViewById(R.id.single_date);

        partName = (TextView) findViewById(R.id.profile_name);

        partiName = prefs.getString("name", null);
        partId = prefs.getString("partId", null);

        if(Constants.isNetworkAvailable(HomeActivity.this)) {

            new LoadImage("http://183.82.103.156:8080/Resources/wre/profile_pics/" + partId + "/profile.jpg", HomeActivity.this, new ImageCallBack() {
                @Override
                public void onResult(Bitmap bitmap) {
                    proFic.setImageBitmap(bitmap);
                }
            }).execute();
        }
       // Picasso.with(getApplicationContext()).load("http://183.82.103.156:8080/Resources/wre/profile_pics/" + partId + "/profile.jpg").placeholder(R.drawable.user_icon).into(proFic);
        partName.setText(partiName);

        if (Constants.checkAndRequestPermissions(HomeActivity.this)) ;
        profDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Constants.isNetworkAvailable(HomeActivity.this)) {

                    Intent profDetailsAct = new Intent(HomeActivity.this, EmpProfileActivity.class);

                    startActivity(profDetailsAct);
                    finish();
                } else {
                    Constants.createDialogSend(HomeActivity.this, "error", "Please connect to internet");

                }
            }
        });




        if (Constants.isNetworkAvailable(HomeActivity.this)) {
            new MyAsyncTask(Constants.EVENT_LIST + "?participantId=" + partId, null, HomeActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    List<ParticipantEventBean> eventList = Utils.getList(result, ParticipantEventBean.class);
                    if (eventList != null) {
                        list = new ArrayList<HashMap<String, String>>();
                        for (ParticipantEventBean bean : eventList) {
                            HashMap<String, String> file_maps = new HashMap<String, String>();
                            file_maps.put("eventName", bean.getEventname());
                            file_maps.put("eventId", bean.getEventId().toString());
                            file_maps.put("date", Utils.getDateFromJson(bean.getEventDate(), "d"));

                            file_maps.put("eventImage", Constants.IMAGE_URL + bean.getEventId() + "/event_home/home.png");
                            list.add(file_maps);
                        }
                        for (final HashMap<String, String> map : list) {
                            if (list.size() < 2) {
                                singleEventView.setVisibility(View.VISIBLE);
                                Picasso.with(getApplicationContext()).load(map.get("eventImage")).placeholder(R.drawable.user_icon).into(singleImageView);
                                // ghostView_workaround.setBackgroundResource(map.get("eventImage"));
                                singleEvent.setText(map.get("eventName"));
                                singleEventDate.setText(map.get("date"));
                                singleEventView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(HomeActivity.this, EventDashboardActivity.class);
                                        editor.putString("eventId", map.get("eventId"));
                                        editor.putString("eventName", map.get("eventName"));
                                        editor.putString("eventDate", map.get("date"));
                                        editor.commit();
                                        startActivity(i);

                                    }
                                });

                            } else {
                                singleEventView.setVisibility(View.GONE);

                                TextSliderView textSliderView = new TextSliderView(HomeActivity.this);
                                // initialize a SliderLayout
                                textSliderView.description(map.get("eventName"))
                                        .image(map.get("eventImage"))
                                        .setScaleType(BaseSliderView.ScaleType.Fit).dateTime(map.get("date"))
                                        .setOnSliderClickListener(HomeActivity.this);


                                //add your extra information
                                textSliderView.bundle(new Bundle());
                                textSliderView.getBundle()
                                        .putString("extra", map.get("eventId"));
                                textSliderView.getBundle()
                                        .putString("eventName", map.get("eventName"));
                                textSliderView.getBundle()
                                        .putString("date", map.get("date"));

                                mDemoSlider.addSlider(textSliderView);
                                mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
                            }
                        }
                    }
                }
            }).execute();
        } else {
            Constants.createDialogSend(HomeActivity.this, "error", "Please connect to internet");

        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        if (Constants.isNetworkAvailable(HomeActivity.this)) {
            // Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
            String eventName = slider.getBundle().get("extra").toString();
            String date = slider.getBundle().get("date").toString();
            Intent i = new Intent(HomeActivity.this, EventDashboardActivity.class);
            editor.putString("eventId", eventName);
            editor.putString("eventName", slider.getBundle().get("eventName").toString());
            editor.putString("eventDate", date);
            editor.commit();
            i.putExtra("eventId", eventName);
            i.putExtra("date", date);
            i.putExtra("eventName", slider.getBundle().get("eventName").toString());
            startActivity(i);

        } else {
            Constants.createDialogSend(HomeActivity.this, "error", "Please connect to internet");

        }
    }
boolean doubleBackToExitPressedOnce=false;
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }
}
