package com.wre.yin.whiterabbiteventapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.adapters.ChatMessageAdapter;
import com.wre.yin.whiterabbiteventapp.beans.ChatMessage;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MessageActivity extends AppCompatActivity {
    private ListView mListView;
    private Button mButtonSend;
    private EditText mEditTextMessage;
    private ImageView mImageView;

    SharedPreferences prefs;
    Bundle bundle;

    String message;

    private ChatMessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String nameTxt = getIntent().getExtras().getString("name");
        //  text = (TextView) findViewById(R.id.activity_text);

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);*/


        // text.setText(nameTxt);

        prefs = getSharedPreferences("Chat", 0);
        bundle = getIntent().getBundleExtra("INFO");
        SharedPreferences.Editor edit = prefs.edit();

        edit.putString("current_status", "onchat");
        edit.commit();

        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, new IntentFilter("Msg"));

        mListView = (ListView) findViewById(R.id.listView);
        mButtonSend = (Button) findViewById(R.id.btn_send);
        mEditTextMessage = (EditText) findViewById(R.id.et_message);
        mImageView = (ImageView) findViewById(R.id.iv_image);

        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);

        if (bundle != null && bundle.getString("name") != null) {
            /*Log.d("inside notification", "");
            TableRow tr1 = new TableRow(getApplicationContext());
            tr1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            TextView textview = new TextView(getApplicationContext());
            textview.setTextSize(20);
            textview.setTextColor(Color.parseColor("#0B0719"));
            textview.setText(Html.fromHtml("<b>" + bundle.getString("name") + " : </b>" + bundle.getString("msg")));
            tr1.addView(textview);
            tab.addView(tr1);*/

            mimicOtherMessage(bundle.getString("msg"),bundle.getString("name"),null);

        }
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = mEditTextMessage.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                sendMessage(message,"You",null);
                new Send().execute();
               // mEditTextMessage.setText("");
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("You",null);
            }
        });

    }

    private BroadcastReceiver onNotice = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String str = intent.getStringExtra("msg");
            String str1 = intent.getStringExtra("fromname");
            String str2 = intent.getStringExtra("fromu");
            prefs = getSharedPreferences("Chat", 0);
            if ("onchat".equals(prefs.getString("current_status", ""))) {

                /*TableRow tr1 = new TableRow(getApplicationContext());
                tr1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView textview = new TextView(getApplicationContext());
                textview.setTextSize(20);
                textview.setTextColor(Color.parseColor("#0B0719"));
                textview.setText(Html.fromHtml("<b>" + str1 + " : </b>" + str));
                tr1.addView(textview);
                tab.addView(tr1);*/

                mimicOtherMessage(str,str1,null);
            }


        }
    };

    private void sendMessage(String message,String name,String time) {
        ChatMessage chatMessage = new ChatMessage(message, true, false,name,time);
        mAdapter.add(chatMessage);


    }

    private void mimicOtherMessage(String message,String name,String time) {
        ChatMessage chatMessage = new ChatMessage(message, false, false,name,time);
        mAdapter.add(chatMessage);
    }

    private void sendMessage(String name,String time) {
        ChatMessage chatMessage = new ChatMessage(null, true, true,name,time);
        mAdapter.add(chatMessage);


    }

    private void mimicOtherMessage(String name,String time) {
        ChatMessage chatMessage = new ChatMessage(null, false, true,name,time);
        mAdapter.add(chatMessage);
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

    private class Send extends AsyncTask<String, String, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... args) {
            String jsonResult = null;
            HttpResponse httpResponse = null;
            HttpClient httpclient = null;
            HttpEntity httpEntity = null;
            JSONObject jObjResult = null;
            try {
                JSONObject jObj = new JSONObject();
                jObj.put("from", prefs.getString("mobile", ""));
                jObj.put("fromn", prefs.getString("name", ""));
                jObj.put("msg", message);

                HttpPost post = new HttpPost("http://183.82.103.156:8080/whiterabbitevent/send");
                post.setEntity(new StringEntity(jObj.toString()));
                httpclient = new DefaultHttpClient();
                post.setHeader("Accept", "application/json");
                post.setHeader("Content-type", "application/json");
                httpResponse = httpclient.execute(post);

                jsonResult = inputStreamToString(httpResponse.getEntity().getContent()).toString();
                System.out.println("Result " + jsonResult);
                jObjResult = new JSONObject(jsonResult);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return jObjResult;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            mEditTextMessage.setText("");

            String res = null;
            try {
                res = json.getString("response");
                if (res.equals("Failure")) {
                    Toast.makeText(getApplicationContext(), "The user has logged out. You cant send message anymore !", Toast.LENGTH_SHORT).show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
