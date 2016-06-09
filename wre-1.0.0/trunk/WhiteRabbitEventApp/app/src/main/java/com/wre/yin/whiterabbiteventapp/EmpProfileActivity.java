package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class EmpProfileActivity extends AppCompatActivity {

    private ImageView empProfilePic;
    private TextView empName, empMail, empMobile, empOrg, empDesignation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_profile);
        //getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Profile Details");

        empProfilePic = (ImageView) findViewById(R.id.emp_profile_image);

        empName = (TextView) findViewById(R.id.emp_name);
        empMail = (TextView) findViewById(R.id.emp_mail);
        empMobile = (TextView) findViewById(R.id.emp_mobile);
        empOrg = (TextView) findViewById(R.id.emp_org);
        empDesignation = (TextView) findViewById(R.id.emp_designation);


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
