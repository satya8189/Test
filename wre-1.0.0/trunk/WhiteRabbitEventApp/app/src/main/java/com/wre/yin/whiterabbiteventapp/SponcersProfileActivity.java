package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.beans.SponsorBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SponcersProfileActivity extends AppCompatActivity {
    TextView sponcersName, sponsorDesignation, aboutSponsor;
    ImageView sponsorImage;
    private List<HashMap<String, String>> sponsorIndividualList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponcers_profile);

        String sponsorId = getIntent().getExtras().getString("sponsorId");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setTitle(nameTxt);
        sponcersName = (TextView) findViewById(R.id.sponcers_name_text);
        sponsorDesignation = (TextView) findViewById(R.id.sponcers_des_text);
        aboutSponsor = (TextView) findViewById(R.id.about_sponcer_txt);
        sponsorImage = (ImageView) findViewById(R.id.sponsor_pic);


        // sponcersName.setText(nameTxt);


        new MyAsyncTask(Constants.INDIVIDUAL_SPONSOR +sponsorId, null, SponcersProfileActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                sponsorIndividualList = new ArrayList<HashMap<String, String>>();

                List<SponsorBean> individualSponsorBeanList = Utils.getList(result, SponsorBean.class);
                for (SponsorBean bean : individualSponsorBeanList) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("sponsorName", bean.getSponcorName());
                    //    map.put("sponsorDesc", bean.getSponcorDesc());

                    sponsorIndividualList.add(map);

                }

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
