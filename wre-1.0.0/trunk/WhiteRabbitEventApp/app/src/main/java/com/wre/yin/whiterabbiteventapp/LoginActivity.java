package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    Button nextBtn, submitBtn;
    LinearLayout loginLayout, otpLayout;
    private EditText employeeId, otpTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        employeeId = (EditText) findViewById(R.id.employee_id);
        nextBtn = (Button) findViewById(R.id.next_btn);
/*
        otpTxt = (EditText) findViewById(R.id.otp_text);
        submitBtn = (Button) findViewById(R.id.submit_btn);

       loginLayout = (LinearLayout) findViewById(R.id.loginLayout);
       otpLayout = (LinearLayout) findViewById(R.id.otpLayout);*/

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                startActivity(otpAct);
                finish();

                // loginLayout.setVisibility(View.GONE);
                //otpLayout.setVisibility(View.VISIBLE);

            }
        });
      /*  submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeAct = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(homeAct);
                finish();
            }
        });*/
    }

}
