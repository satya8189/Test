package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SocialMediaActivity extends AppCompatActivity {
    private CircleImageView gPlus, faceBook, twitterBtn, linkedinBtn;
    private String eventId, fb, gPlusStr, twitter, linkedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        gPlus = (CircleImageView) findViewById(R.id.btnGplus);
        faceBook = (CircleImageView) findViewById(R.id.btnFb);
        twitterBtn = (CircleImageView) findViewById(R.id.btnTwitter);
        linkedinBtn = (CircleImageView) findViewById(R.id.btnLinkedin);
        eventId = getIntent().getExtras().getString("eventId");

        new MyAsyncTask(Constants.SOCIAL_MEDIA_IDS + eventId, null, SocialMediaActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                List<SocialMediaActivity> socialList = Utils.getList(result, SocialMediaActivity.class);

            }
        }).execute();


        faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://www.facebook.com/gunturanilkumar007"));
                    startActivity(viewIntent);
                } else {
                    Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
                }
            }
        });
        gPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://plus.google.com/+anilkumarguntur"));
                    startActivity(viewIntent);
                } else {
                    Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
                }
            }

        });

        twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://twitter.com/honyanil"));
                    startActivity(viewIntent);
                } else {
                    Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
                }
            }

        });


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
