package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OTPActivity extends AppCompatActivity {

    private EditText otpTxt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        getSupportActionBar().hide();
        otpTxt = (EditText) findViewById(R.id.otp_text);
        submitBtn = (Button) findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeAct = new Intent(OTPActivity.this, HomeActivity.class);
                startActivity(homeAct);
                finish();
            }
        });
    }

}
