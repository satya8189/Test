package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

public class VenueActivity extends AppCompatActivity {

    private ImageView venueImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);

        String nameTxt = getIntent().getExtras().getString("name");
        venueImage = (ImageView) findViewById(R.id.venue_image);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);


        venueImage.setBackgroundResource(R.drawable.layout_pic);

    }

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
