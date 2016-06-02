package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.wre.yin.whiterabbiteventapp.beans.ParticipantBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

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
                if(Utils.checkMobile(mobileNum)) {

                    editor.putString("mobile",mobileNum);
                    ParticipantBean participantBean = new ParticipantBean();
                    participantBean.setPhoneNumber(mobileNum);

                    new MyAsyncTask(Constants.PARTICIPENT_LOGIN, Utils.getJson(participantBean), LoginActivity.this, new Callback() {
                        @Override
                        public void onResult(String result) {
                            ParticipantBean pBean=Utils.getObject(result,ParticipantBean.class);
                            if(pBean.getParticipantId()!=null){
                                editor.putString("partName",pBean.getFirstName());
                                Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                                startActivity(otpAct);
                                finish();
                            }
                        }
                    }).execute();
                }else{
                    employeeId.setError("Please enter a valid mobile number");
                }



            }
        });

    }

}
