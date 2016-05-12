package com.wre.yin.whiterabbiteventapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.HashMap;

public class HomeActivity extends Activity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;

    private Target target;

    private ImageView proFic, profDetails;

    private RelativeLayout rl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));

        profDetails = (ImageView) findViewById(R.id.profile_details);

        proFic = (ImageView) findViewById(R.id.profilepic);

        rl1 = (RelativeLayout) findViewById(R.id.rl1);

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
                .load(R.drawable.nature3)
                .into(target);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Nature1", R.drawable.nature1);
        file_maps.put("Nature 2", R.drawable.nature2);
        file_maps.put("Nature 3", R.drawable.nature3);
        file_maps.put("Image 1", R.drawable.image1);
        file_maps.put("Hannibal", R.drawable.game_of_thrones);
        file_maps.put("BigBang", R.drawable.bigbang);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
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
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
        String eventName = slider.getBundle().get("extra").toString();
        Intent i = new Intent(HomeActivity.this, EventDashboardActivity.class);
        i.putExtra("eventName", eventName);
        startActivity(i);

    }

}
