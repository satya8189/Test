package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    private Button nextBtn, submitBtn;
    private EditText employeeId, otpTxt;
    private SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs = getSharedPreferences("Chat", 0);
        editor=prefs.edit();
        getSupportActionBar().hide();

        employeeId = (EditText) findViewById(R.id.employee_id);
        nextBtn = (Button) findViewById(R.id.next_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNum=employeeId.getText().toString();

                Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                startActivity(otpAct);
                finish();
                editor.putString("mobile",mobileNum);
            }
        });

    }

}
