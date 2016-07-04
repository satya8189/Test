package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.SponsorBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SponcersProfileActivity extends AppCompatActivity {
    private TextView sponcersName, sponsorDesignation, aboutSponsor;
    private CircleImageView sponsorImage;
    private List<HashMap<String, String>> sponsorIndividualList;
    private String sponsorId, spoUrl, sponsorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // SponcersProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_sponcers_profile);

        sponsorName = getIntent().getExtras().getString("sponsorName");
        sponsorId = getIntent().getExtras().getString("sponsorId");
        spoUrl = getIntent().getExtras().getString("sponsorUrl");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(sponsorName);

        sponcersName = (TextView) findViewById(R.id.sponcers_name_text);
        sponsorDesignation = (TextView) findViewById(R.id.sponcers_des_text);
        aboutSponsor = (TextView) findViewById(R.id.about_sponcer_txt);
        sponsorImage = (CircleImageView) findViewById(R.id.sponsor_indi_pic);

        Picasso.with(getApplicationContext()).load(spoUrl).into(sponsorImage);
        // sponcersName.setText(nameTxt);

        if (Constants.isNetworkAvailable(SponcersProfileActivity.this)) {
            new MyAsyncTask(Constants.INDIVIDUAL_SPONSOR + sponsorId, null, SponcersProfileActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    if (result != null)
                        sponsorIndividualList = new ArrayList<HashMap<String, String>>();

                    SponsorBean indBean = Utils.getObject(result, SponsorBean.class);

                    sponcersName.setText(indBean.getSponcorName());
                    aboutSponsor.setText(indBean.getSponcorDesc());


                }
            }).execute();
        } else {
            Constants.createDialogSend(SponcersProfileActivity.this, "error", "Please connect to internet");
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
      //  SponcersProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }
}
