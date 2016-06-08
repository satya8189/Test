package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.beans.SpeakerBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

public class SpeakersProfileDetailsActivity extends AppCompatActivity {

    private TextView speakerName, spDesc, spDesig, spLocation;
    private ImageView spProfilePic;
    private RatingBar spRating;
    private String spId, spName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        spId = getIntent().getExtras().getString("speakerId");
        spName = getIntent().getExtras().getString("speakerName");

        spDesig = (TextView) findViewById(R.id.speaker_desig);
        spLocation = (TextView) findViewById(R.id.sp_location);
        spDesc = (TextView) findViewById(R.id.speaker_desc);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(spName);
        speakerName = (TextView) findViewById(R.id.speaker_name);
        speakerName.setText(spName);

        new MyAsyncTask(Constants.INDIVIDUAL_SPEAKER + spId, null, SpeakersProfileDetailsActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                SpeakerBean spBean = Utils.getObject(result, SpeakerBean.class);
                spDesig.setText(spBean.getTitle());
                spLocation.setText(spBean.getLocation());
                spDesc.setText(spBean.getDescription());
            }
        }).execute();

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
