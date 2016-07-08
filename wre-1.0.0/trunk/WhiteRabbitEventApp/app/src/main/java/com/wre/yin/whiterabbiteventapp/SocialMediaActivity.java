package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.wre.yin.whiterabbiteventapp.beans.SocialMediaBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SocialMediaActivity extends AppCompatActivity {
    private CircleImageView gPlus, faceBook, twitterBtn, linkedinBtn, flickerBtn, instagramBtn;
    private String eventId, fb, gPlusStr, twitter, linkedIn, socialId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // SocialMediaActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_social_media);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        gPlus = (CircleImageView) findViewById(R.id.btnGplus);
        faceBook = (CircleImageView) findViewById(R.id.btnFb);
        twitterBtn = (CircleImageView) findViewById(R.id.btnTwitter);
        linkedinBtn = (CircleImageView) findViewById(R.id.btnLinkedin);
        flickerBtn = (CircleImageView) findViewById(R.id.btnFlicker);
        instagramBtn = (CircleImageView) findViewById(R.id.btnInstagram);
        eventId = getIntent().getExtras().getString("eventId");

        if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
            new MyAsyncTask(Constants.SOCIAL_MEDIA_IDS + eventId, null, SocialMediaActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    List<SocialMediaBean> socialList = Utils.getList(result, SocialMediaBean.class);
                    if (socialList != null) {
                        for (SocialMediaBean bean : socialList) {
                            if (bean.getType().equals("Facebook")) {
                                socialId = bean.getName();
                                faceBook.setVisibility(View.VISIBLE);
                            } else if (bean.getType().equals("Google+")) {
                                socialId = bean.getName();
                                gPlus.setVisibility(View.VISIBLE);
                            } else if (bean.getType().equals("Twitter")) {
                                socialId = bean.getName();
                                twitterBtn.setVisibility(View.VISIBLE);
                            } else if (bean.getType().equals("LinkedIn")) {
                                socialId = bean.getName();
                                linkedinBtn.setVisibility(View.VISIBLE);
                            } else if (bean.getType().equals("Flickr")) {
                                socialId = bean.getName();
                                flickerBtn.setVisibility(View.VISIBLE);
                            } else if (bean.getType().equals("Instagram")) {
                                socialId = bean.getName();
                                instagramBtn.setVisibility(View.VISIBLE);
                            }

                        }
                    }

                }
            }).execute();
        } else {
            Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
        }

        faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://www.facebook.com/" + socialId));
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
                                    Uri.parse("https://plus.google.com/" + socialId));
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
                                    Uri.parse("https://twitter.com/" + socialId));
                    startActivity(viewIntent);
                } else {
                    Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
                }
            }

        });
        linkedinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://www.linkedin.com/in/" + socialId));
                    startActivity(viewIntent);
                } else {
                    Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
                }
            }

        });
        flickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://twitter.com/" + socialId));
                    startActivity(viewIntent);
                } else {
                    Constants.createDialogSend(SocialMediaActivity.this, "error", "Please connect to internet");
                }
            }

        });
        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.isNetworkAvailable(SocialMediaActivity.this)) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("www.instagram.com/" + socialId));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // SocialMediaActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }
}
