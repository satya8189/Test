package com.wre.yin.whiterabbiteventapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutEventActivity extends AppCompatActivity {
    private TextView text;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_event);

        String nameTxt = getIntent().getExtras().getString("name");
        //text = (TextView) findViewById(R.id.event_details_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        webView=(WebView)findViewById(R.id.detail_webview);

        String htmlText = " %s ";
        String myData = "HBook or buy tickets online for the popular upcoming events in Hyderabad, live concerts and events happening in and around Hyderabad at Eventsnow.com.";

        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
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
}
