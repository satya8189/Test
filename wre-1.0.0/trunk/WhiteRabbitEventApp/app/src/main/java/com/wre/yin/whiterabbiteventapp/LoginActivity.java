package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.wre.yin.whiterabbiteventapp.beans.ParticipantBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    static final String TAG = "L2C";
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    SharedPreferences.Editor editor;
    String SENDER_ID = "1065186781236";
    GoogleCloudMessaging gcm;
    ParticipantBean pBean = null;
    Context context;
    String regid;
    String jsonResult = null;
    HttpResponse httpResponse = null;
    HttpClient httpclient = null;
    HttpEntity httpEntity = null;
    private Button nextBtn, submitBtn;
    private EditText employeeId, otpTxt;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // LoginActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_login);
        context = getApplicationContext();

        getSupportActionBar().hide();
        prefs = getSharedPreferences("Chat", 0);
        editor = prefs.edit();
        if (Constants.checkAndRequestPermissions(this)) {

        }
        employeeId = (EditText) findViewById(R.id.employee_id);
        nextBtn = (Button) findViewById(R.id.next_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mobileNum = employeeId.getText().toString();
                if (Constants.isNetworkAvailable(LoginActivity.this)) {
                    if (Utils.checkMobile(mobileNum)) {
                        ParticipantBean participantBean = new ParticipantBean();
                        participantBean.setPhoneNumber(mobileNum);

                        new MyAsyncTask(Constants.PARTICIPENT_LOGIN, Utils.getJson(participantBean), LoginActivity.this, new Callback() {
                            @Override
                            public void onResult(String result) {

                                pBean = Utils.getObject(result, ParticipantBean.class);
                                if (pBean != null) {
                                    if (mobileNum.equals(pBean.getPhoneNumber())) {
                                        editor.putString("name", pBean.getFirstName());
                                        editor.putString("partId", pBean.getParticipantId().toString());

                                        String strPref = prefs.getString("mobile", null);
                                        if (strPref == null) {
                                            new Register().execute(pBean.getPhoneNumber());
                                        }

                                        editor.putString("mobile", pBean.getPhoneNumber());
                                        editor.putString("mail", pBean.getEmailId());
                                        editor.commit();
                                        Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                                        startActivity(otpAct);
                                        finish();
                                    } else {
                                        employeeId.setError("Please enter a Registered mobile number");
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Sorry for the inconvienence...", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).execute();

             /*       if(pBean.getParticipantId()!=null){
                        System.out.println("insdie myasynctask--");
                        String strPref = prefs.getString("mobile", null);
                       *//* if(strPref==null){
                            new Register().execute();
                        }*//*
                        editor.putString("name",pBean.getFirstName());
                        editor.putString("mobile",pBean.getPhoneNumber());
                        Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                        startActivity(otpAct);
                        finish();
                    }*/
                    } else {
                        employeeId.setError("Please enter a valid mobile number");
                    }

                } else {
                    Constants.createDialogSend(LoginActivity.this, "error", "Please connect to internet");
                }
            }
        });

    }

    private StringBuilder inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader rd = new BufferedReader(isr);
        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private class Register extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... args) {
            String phone = args[0];
            try {
                if (gcm == null) {
                    gcm = GoogleCloudMessaging.getInstance(context);
                    regid = gcm.register(SENDER_ID);
                    //Log.e("RegId",regid);
                    ParticipantBean p = new ParticipantBean();
                    p.setPhoneNumber(phone);
                    p.setRegisterId(regid);
                    HttpPost post = new HttpPost(Constants.PARTICIPENT_REG_UPDATE);
                    String r = Utils.getJson(p);
                    post.setEntity(new StringEntity(r));
                    httpclient = new DefaultHttpClient();
                    post.setHeader("Accept", "application/json");
                    post.setHeader("Content-type", "application/json");
                    httpResponse = httpclient.execute(post);
                    httpEntity = httpResponse.getEntity();
                    jsonResult = inputStreamToString(httpResponse.getEntity().getContent()).toString();
                    System.out.println("Result " + jsonResult);
                    prefs = getSharedPreferences("Chat", 0);
                    editor = prefs.edit();


                    editor.putString("mobile", phone);
                    editor.commit();
                    Intent otpAct = new Intent(LoginActivity.this, OTPActivity.class);
                    startActivity(otpAct);
                    finish();

                }

                return regid;

            } catch (IOException ex) {
                Log.e("Error", ex.getMessage());
                return "Fails";

            }

        }

        @Override
        protected void onPostExecute(String json) {


        }
    }
}