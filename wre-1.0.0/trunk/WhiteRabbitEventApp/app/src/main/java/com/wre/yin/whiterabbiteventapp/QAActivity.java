package com.wre.yin.whiterabbiteventapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wre.yin.whiterabbiteventapp.beans.ParticipantQuriesBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

public class QAActivity extends AppCompatActivity {
    private EditText questionTxt;
    private Button btnSubmit;
    private String spId, eventId, partId;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // QAActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_qa);

        String nameTxt = getIntent().getExtras().getString("name");
        spId = getIntent().getExtras().getString("speakerId");
        prefs = getSharedPreferences("Chat", 0);
        partId = prefs.getString("partId", null);
        eventId = prefs.getString("eventId", null);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Question");

        questionTxt = (EditText) findViewById(R.id.question_edittext);
        btnSubmit = (Button) findViewById(R.id.question_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String questionString = questionTxt.getText().toString();
                if (!questionString.isEmpty()) {
                    ParticipantQuriesBean bean = new ParticipantQuriesBean();
                    bean.setEventId(Long.parseLong(eventId));
                    bean.setParticipantId(Long.parseLong(partId));
                    bean.setSpeakerId(Long.parseLong(spId));
                    bean.setQuery(questionString);
                    if (Constants.isNetworkAvailable(QAActivity.this)) {
                        new MyAsyncTask(Constants.SPEAKER_QUERY, Utils.getJson(bean), QAActivity.this, new Callback() {
                            @Override
                            public void onResult(String result) {
                                if (result.equals("success")) {
                                    questionTxt.setText("");
                                    Constants.createDialogSend(QAActivity.this, "success", "Your query submitted successfully");
                                }

                            }
                        }).execute();
                    } else {
                        Constants.createDialogSend(QAActivity.this, "error", "Please connect to internet");
                    }
                }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // QAActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }
}
