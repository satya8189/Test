package com.wre.yin.whiterabbiteventapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends Activity {

    Button nextBtn, submitBtn;
    LinearLayout employeeLayout, otpLayout;
    private EditText employeeId, otpTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_login);

       // getSupportActionBar().hide();

        employeeId = (EditText) findViewById(R.id.employee_id);
        nextBtn = (Button) findViewById(R.id.next_btn);

        otpTxt = (EditText) findViewById(R.id.otp_text);
        submitBtn = (Button) findViewById(R.id.submit_btn);

        employeeLayout = (LinearLayout) findViewById(R.id.employee_layout);
        otpLayout = (LinearLayout) findViewById(R.id.otp_layout);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                // startActivity(otpAct);
                employeeLayout.setVisibility(View.GONE);
                otpLayout.setVisibility(View.VISIBLE);

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeAct = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(homeAct);
                finish();
            }
        });
    }

}
