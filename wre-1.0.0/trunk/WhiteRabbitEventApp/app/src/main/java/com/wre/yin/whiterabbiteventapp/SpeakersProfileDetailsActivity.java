package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.RatingBean;
import com.wre.yin.whiterabbiteventapp.beans.SpeakerBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpeakersProfileDetailsActivity extends AppCompatActivity {

    private TextView speakerName, spDesc, spDesig, spLocation, askQuestion;
    private ImageView spProfilePic;
    private RatingBar spRating;
    private String spId, spName, spUrl, eventId, partId;
    private CircleImageView spImage;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // SpeakersProfileDetailsActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_profile_details);

        spId = getIntent().getExtras().getString("speakerId");
        spName = getIntent().getExtras().getString("speakerName");
        spUrl = getIntent().getExtras().getString("speakerUrl");
        eventId = getIntent().getExtras().getString("eventId");

        prefs = getSharedPreferences("Chat", 0);
        partId = prefs.getString("partId", null);

        spDesig = (TextView) findViewById(R.id.speaker_desig);
        spLocation = (TextView) findViewById(R.id.sp_location);
        spDesc = (TextView) findViewById(R.id.speaker_desc);
        askQuestion = (TextView) findViewById(R.id.ask_question);
        spImage = (CircleImageView) findViewById(R.id.speaker_indi_img);
        spRating = (RatingBar) findViewById(R.id.speaker_ratingBar);
        Picasso.with(getApplicationContext()).load(spUrl).into(spImage);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(spName);
        speakerName = (TextView) findViewById(R.id.speaker_name);
        speakerName.setText(spName);

        spRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                String rate = String.valueOf(rating);
                if (!rate.equals("")) {
                    RatingBean ratingBean = new RatingBean();
                    ratingBean.setEventId(Long.parseLong(eventId));
                    ratingBean.setRating(Float.parseFloat(rate));
                    ratingBean.setSourceId(Long.parseLong(spId));
                    ratingBean.setUserId(Long.parseLong(partId));
                    if (Constants.isNetworkAvailable(SpeakersProfileDetailsActivity.this)) {
                        new MyAsyncTask(Constants.SPEAKER_RATING, Utils.getJson(ratingBean), SpeakersProfileDetailsActivity.this, new Callback() {
                            @Override
                            public void onResult(String result) {
                                System.out.println(result);
                                Constants.createDialogSend(SpeakersProfileDetailsActivity.this, "success", "Your rating submitted successfully");
                            }
                        }).execute();
                    } else {
                        Constants.createDialogSend(SpeakersProfileDetailsActivity.this, "error", "Please connect to internet");
                    }
                }

            }
        });

        askQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpeakersProfileDetailsActivity.this, QAActivity.class);
                i.putExtra("speakerId", spId);
                startActivity(i);
            }
        });

        if (Constants.isNetworkAvailable(SpeakersProfileDetailsActivity.this)) {
            new MyAsyncTask(Constants.INDIVIDUAL_SPEAKER + spId, null, SpeakersProfileDetailsActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    SpeakerBean spBean = Utils.getObject(result, SpeakerBean.class);
                    if (spBean != null) {
                        spDesig.setText(spBean.getTitle());
                        spLocation.setText(spBean.getLocation());
                        spDesc.setText("    " + spBean.getDescription());
                    }
                }
            }).execute();
        } else {
            Constants.createDialogSend(SpeakersProfileDetailsActivity.this, "error", "Please connect to internet");
        }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //   SpeakersProfileDetailsActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }
}
