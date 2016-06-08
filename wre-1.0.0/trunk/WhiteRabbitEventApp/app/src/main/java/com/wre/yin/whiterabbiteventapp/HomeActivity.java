package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private Target target;
    private ImageView proFic, profDetails;
    private RelativeLayout rl1;
    private SharedPreferences prefs;

    private String partiName, partId;
    private TextView partName;
    private List<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        prefs = getSharedPreferences("Chat", 0);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        profDetails = (ImageView) findViewById(R.id.profile_details);
        proFic = (ImageView) findViewById(R.id.profilepic);
        rl1 = (RelativeLayout) findViewById(R.id.rl1);

        partName = (TextView) findViewById(R.id.profile_name);

        partiName = prefs.getString("name", null);
        partId = prefs.getString("partId", null);

        partName.setText(partiName);

        if (Constants.checkAndRequestPermissions(HomeActivity.this)) ;
        profDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profDetailsAct = new Intent(HomeActivity.this, EmpProfileActivity.class);
                startActivity(profDetailsAct);
            }
        });

        target = new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        // iView.setImageBitmap(bitmap);
                        proFic.setImageBitmap(bitmap);
                        int defaultColor = getResources().getColor(android.R.color.black);
                        rl1.setBackgroundColor(palette.getVibrantColor(defaultColor));
                    }
                });
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        Picasso.with(getApplicationContext())
                .load(R.drawable.user_icon)
                .into(target);

        new MyAsyncTask(Constants.EVENT_LIST + "?participantId=" + partId, null, HomeActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                List<ParticipantEventBean> eventList = Utils.getList(result, ParticipantEventBean.class);


                list = new ArrayList<HashMap<String, String>>();
                for (ParticipantEventBean bean : eventList) {
                    HashMap<String, String> file_maps = new HashMap<String, String>();
                    file_maps.put("eventName", bean.getEventname());
                    file_maps.put("eventId", bean.getEventId().toString());
                    file_maps.put("date", Utils.getDateFromJson(bean.getEventDate(), "d"));
                    file_maps.put("eventImage", Constants.IMAGE_URL + bean.getEventId() + "/event_images/Screenshot%20from%202015-04-27%2014:20:13.png");
                    list.add(file_maps);
                }
                for (HashMap<String, String> map : list) {
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
                            .putString("date", map.get("date"));

                    mDemoSlider.addSlider(textSliderView);
                    mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Fade);
                    mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomIn);
                    mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
                }

            }
        }).execute();
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
        // Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
        String eventName = slider.getBundle().get("extra").toString();
        String date = slider.getBundle().get("date").toString();
        Intent i = new Intent(HomeActivity.this, EventDashboardActivity.class);
        i.putExtra("eventId", eventName);
        i.putExtra("date", date);
        startActivity(i);

    }

}
