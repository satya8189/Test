package com.wre.yin.whiterabbiteventapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wre.yin.whiterabbiteventapp.beans.ContactDetailsBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

public class HelpActivity extends AppCompatActivity {

    private EditText contact_Name, contact_Mobile, contact_Email, help_Text;
    private Button helpSubmit;
    private String contactName, contactMobile, contactEmail, helpText;
    private SharedPreferences prefs;
    private String partiName, partId, partMobile, partEmail, partAltNumber, partDesig, partOrg, eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_help);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Help");
        contact_Name = (EditText) findViewById(R.id.contact_name);
        contact_Mobile = (EditText) findViewById(R.id.contact_mobile);
        contact_Email = (EditText) findViewById(R.id.contact_mail);
        help_Text = (EditText) findViewById(R.id.help_text);

        helpSubmit = (Button) findViewById(R.id.help_submit);

        prefs = getSharedPreferences("Chat", 0);
        partiName = prefs.getString("name", null);
        partId = prefs.getString("partId", null);
         eventId = getIntent().getExtras().getString("eventId");
        helpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contactName = contact_Name.getText().toString();
                contactMobile = contact_Mobile.getText().toString();
                contactEmail = contact_Email.getText().toString();
                helpText = help_Text.getText().toString();

                if (Constants.isNetworkAvailable(HelpActivity.this)) {

                    if (contactName.equals("") && contactMobile.equals("") && contactEmail.equals("") && helpText.equals("")) {
                        contact_Name.setError("Field Cannot be empty");
                        contact_Email.setError("Field Cannot be empty");
                        contact_Mobile.setError("Field Cannot be empty");
                        help_Text.setError("Field Cannot be empty");
                    } else {

                        ContactDetailsBean contactBean = new ContactDetailsBean();
                        contactBean.setContactName(contactName);
                        contactBean.setContactEmail(contactEmail);
                        contactBean.setContactMobile(contactMobile);
                        contactBean.setParticipantId(Long.parseLong(partId));
                        contactBean.setEventId(Long.parseLong(eventId));
                        contactBean.setContactAlternateMobile("");
                        contactBean.setHelpText(helpText);

                        new MyAsyncTask(Constants.SAVE_HELP_DETAILS, Utils.getJson(contactBean), HelpActivity.this, new Callback() {
                            @Override
                            public void onResult(String result) {
                                //  ContactDetailsBean res = Utils.getObject(result, ContactDetailsBean.class);

                                System.out.println("update result" + result);

                            }
                        }).execute();
                    }
                } else {
                    Constants.createDialogSend(HelpActivity.this, "error", "No internet...");
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
}
