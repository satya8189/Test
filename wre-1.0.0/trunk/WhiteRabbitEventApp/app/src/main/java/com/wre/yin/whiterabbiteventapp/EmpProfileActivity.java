package com.wre.yin.whiterabbiteventapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.wre.yin.whiterabbiteventapp.beans.ParticipantBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

public class EmpProfileActivity extends AppCompatActivity {

    private ImageView empProfilePic;
    private EditText empName, empMail, empMobile, empAlterMobile, empOrg, empDesignation;
    private Button saveUpdateBtn;

    private SharedPreferences prefs;
    private String partiName, partId, partMobile, partEmail, partAltNumber, partDesig, partOrg, eventId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_profile);
        //getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Profile Details");

        prefs = getSharedPreferences("Chat", 0);
        partiName = prefs.getString("name", null);
        partId = prefs.getString("partId", null);

       // eventId = getIntent().getExtras().getString("eventId");
        empProfilePic = (ImageView) findViewById(R.id.emp_profile_image);

        empName = (EditText) findViewById(R.id.emp_name);
        empMail = (EditText) findViewById(R.id.emp_mail);
        empMobile = (EditText) findViewById(R.id.emp_mobile);
        empAlterMobile = (EditText) findViewById(R.id.emp_alternate_mobile);
        // empOrg = (EditText) findViewById(R.id.emp_org);
        // empDesignation = (EditText) findViewById(R.id.emp_designation);

        saveUpdateBtn = (Button) findViewById(R.id.save_update_btn);

        empName.setText(partiName);

        saveUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatePartiName = empName.getText().toString();
                String upadatePartMobile = empMobile.getText().toString();
                String updatePartEmail = empMail.getText().toString();
                String partAltNumber = empAlterMobile.getText().toString();

                ParticipantBean partBean = new ParticipantBean();
                partBean.setFirstName(updatePartiName);
                partBean.setEmailId(updatePartEmail);
                partBean.setPhoneNumber(upadatePartMobile);
                partBean.setStatus("ACTIVE");
                partBean.setLastName("Kumar");


                partBean.setParticipantId(Long.parseLong(partId));


                new MyAsyncTask(Constants.PARTICIPANT_UPDATE, Utils.getJson(partBean), EmpProfileActivity.this, new Callback() {
                    @Override
                    public void onResult(String result) {

                        System.out.println("update result" + result);

                    }
                }).execute();


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
