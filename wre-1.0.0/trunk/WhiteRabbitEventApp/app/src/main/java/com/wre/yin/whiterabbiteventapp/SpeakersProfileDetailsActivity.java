package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
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
    private String spId, spName, spUrl;
    private CircleImageView spImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        spId = getIntent().getExtras().getString("speakerId");
        spName = getIntent().getExtras().getString("speakerName");
        spUrl = getIntent().getExtras().getString("speakerUrl");

        spDesig = (TextView) findViewById(R.id.speaker_desig);
        spLocation = (TextView) findViewById(R.id.sp_location);
        spDesc = (TextView) findViewById(R.id.speaker_desc);
        askQuestion = (TextView) findViewById(R.id.ask_question);
        spImage = (CircleImageView) findViewById(R.id.speaker_indi_img);
        spRating=(RatingBar)findViewById(R.id.speaker_ratingBar);
        Picasso.with(getApplicationContext()).load(spUrl).into(spImage);


        spRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                Toast.makeText(getApplicationContext(),(String.valueOf(rating)),Toast.LENGTH_LONG).show();

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(spName);
        speakerName = (TextView) findViewById(R.id.speaker_name);
        speakerName.setText(spName);
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
                    if (result != null) {
                        SpeakerBean spBean = Utils.getObject(result, SpeakerBean.class);
                        spDesig.setText(spBean.getTitle());
                        spLocation.setText(spBean.getLocation());
                        spDesc.setText(spBean.getDescription());
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
}
