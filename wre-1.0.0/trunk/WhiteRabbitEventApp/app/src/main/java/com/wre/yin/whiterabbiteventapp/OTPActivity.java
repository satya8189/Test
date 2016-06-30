package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wre.yin.whiterabbiteventapp.utils.Constants;

public class OTPActivity extends AppCompatActivity {

    private static EditText otpTxt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        getSupportActionBar().hide();
        otpTxt = (EditText) findViewById(R.id.otp_text);
        submitBtn = (Button) findViewById(R.id.submit_btn);
        if (Constants.checkAndRequestPermissions(this)) {

        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Constants.isNetworkAvailable(OTPActivity.this)) {
                    Intent homeAct = new Intent(OTPActivity.this, HomeActivity.class);
                    startActivity(homeAct);
                    finish();
                } else {
                    Constants.createDialogSend(OTPActivity.this, "error", "Please connect to internet");
                }
            }
        });
    }

    public String recievedSms(String message) {
        try {
            System.out.println("message--->>>" + message);
            otpTxt.setText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

}
