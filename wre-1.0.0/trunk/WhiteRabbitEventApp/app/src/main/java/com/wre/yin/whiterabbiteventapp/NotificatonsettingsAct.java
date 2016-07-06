package com.wre.yin.whiterabbiteventapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class NotificatonsettingsAct extends AppCompatActivity {

    private Switch switchStatus;

    private SharedPreferences notifyPrefs;

    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaton_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notification Settings");

        switchStatus = (Switch) findViewById(R.id.switch_status);

        notifyPrefs = getSharedPreferences("notify_status", MODE_PRIVATE);
        boolean switchState = notifyPrefs.getBoolean("service_status", false);
        // Toast.makeText(NotificatonsettingsAct.this, "" + switchState, Toast.LENGTH_SHORT).show();

        if (switchState) {
            switchStatus.setChecked(true);
        } else {
            switchStatus.setChecked(false);
        }

        switchStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                editor = getSharedPreferences("notify_status", MODE_PRIVATE).edit();
                editor.putBoolean("service_status", switchStatus.isChecked());
               // Toast.makeText(NotificatonsettingsAct.this, "" + switchStatus.isChecked(), Toast.LENGTH_SHORT).show();
                editor.commit();

                if (switchStatus.isChecked()) {
                    Toast.makeText(NotificatonsettingsAct.this, "You turned On Notifications", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(NotificatonsettingsAct.this, "You turned Off Notifications", Toast.LENGTH_SHORT).show();

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
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //   EmpProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        finish();
    }
}
