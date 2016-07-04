package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.EventBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

public class AboutEventActivity extends AppCompatActivity {
    private TextView descAboutEvent;
    // private WebView webView;
    private String eventId;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // AboutEventActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_about_event);

        String nameTxt = getIntent().getExtras().getString("name");
        descAboutEvent = (TextView) findViewById(R.id.event_details_text);
        imageView=(ImageView)findViewById(R.id.about_event_image) ;
        eventId = getIntent().getExtras().getString("eventId");
        Picasso.with(getApplicationContext()).load(Constants.IMAGE_URL +eventId + "/event_home/home.png").placeholder(R.drawable.user_icon).into(imageView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        new MyAsyncTask(Constants.ABOUT_EVENT + eventId+"&type=app", null, AboutEventActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                EventBean eventBean = Utils.getObject(result, EventBean.class);
                descAboutEvent.setText(eventBean.getEventDesc());
            }
        }).execute();


        //webView = (WebView) findViewById(R.id.detail_webview);

        String htmlText = " %s ";
        String myData = "HBook or buy tickets online for the popular upcoming events in Hyderabad, live concerts and events happening in and around Hyderabad at Eventsnow.com.";

        // webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
        /*text.setText("\t\t"+"Give me one good reason why I should give up my limited spare time to come to your Science Week event! While you’re at it, give me a few good reasons.\n" +
                "\n" +"\t\t"+
                "A strong and clear event description excites punters: tell them what will happen at the event, who will be speaking, and what they might get out of attending. Your event may be brilliant, but no one else will know without you telling and convincing them.");*/
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
      //  AboutEventActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }
}
