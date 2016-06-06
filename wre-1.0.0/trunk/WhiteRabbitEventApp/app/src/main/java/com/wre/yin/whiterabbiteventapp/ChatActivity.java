package com.wre.yin.whiterabbiteventapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import java.util.List;


public class ChatActivity extends Activity {
    SharedPreferences prefs;

    List<NameValuePair> params;
    EditText chat_msg;
    Button send_btn;
    Bundle bundle;
    TableLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        tab = (TableLayout)findViewById(R.id.tab);

        prefs = getSharedPreferences("Chat", 0);
        bundle = getIntent().getBundleExtra("INFO");

        SharedPreferences.Editor edit = prefs.edit();
      //  edit.putString("CURRENT_ACTIVE", bundle.getString("mobno"));


        edit.putString("current_status","onchat");
        edit.commit();


        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, new IntentFilter("Msg"));


       if(bundle!=null && bundle.getString("name") != null){
            Log.d("inside notification","");
           TableRow tr1 = new TableRow(getApplicationContext());
            tr1.setLayoutParams(new TableRow.LayoutParams( TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            TextView textview = new TextView(getApplicationContext());
            textview.setTextSize(20);
            textview.setTextColor(Color.parseColor("#0B0719"));
            textview.setText(Html.fromHtml("<b>"+bundle.getString("name")+" : </b>"+bundle.getString("msg")));
            tr1.addView(textview);
            tab.addView(tr1);

        }

        chat_msg = (EditText)findViewById(R.id.chat_msg);
        send_btn = (Button)findViewById(R.id.sendbtn);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow tr2 = new TableRow(getApplicationContext());
                tr2.setLayoutParams(new TableRow.LayoutParams( TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView textview = new TextView(getApplicationContext());
                textview.setTextSize(20);
                textview.setTextColor(Color.parseColor("#A901DB"));
                textview.setText(Html.fromHtml("<b>You : </b>" + chat_msg.getText().toString()));
                tr2.addView(textview);
                tab.addView(tr2);
                new Send().execute();
            }
        });


    }

    @Override
    public void onBackPressed() {
        System.out.println("in side back pressed");
        prefs = getSharedPreferences("Chat", 0);
        SharedPreferences.Editor edit = prefs.edit();
        edit.remove("current_status");
edit.commit();



        super.onBackPressed();
    }


    private BroadcastReceiver onNotice= new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String str = intent.getStringExtra("msg");
            String str1 = intent.getStringExtra("fromname");
            String str2 = intent.getStringExtra("fromu");
            prefs = getSharedPreferences("Chat", 0);
            if("onchat".equals(prefs.getString("current_status",""))){

                TableRow tr1 = new TableRow(getApplicationContext());
                tr1.setLayoutParams(new TableRow.LayoutParams( TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView textview = new TextView(getApplicationContext());
                textview.setTextSize(20);
                textview.setTextColor(Color.parseColor("#0B0719"));
                textview.setText(Html.fromHtml("<b>"+str1+" : </b>"+str));
                tr1.addView(textview);
                tab.addView(tr1);
            }



        }
    };

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
            JSONObject jObjResult=null;
            try {
                JSONObject jObj =new JSONObject();
                jObj.put("from", prefs.getString("mobile",""));
                jObj.put("fromn",prefs.getString("name",""));
                jObj.put("msg",chat_msg.getText().toString());

                HttpPost post = new HttpPost("http://183.82.103.156:8080/whiterabbitevent/send");
                post.setEntity(new StringEntity(jObj.toString()));
                httpclient = new DefaultHttpClient();
                post.setHeader("Accept", "application/json");
                post.setHeader("Content-type", "application/json");
                httpResponse = httpclient.execute(post);

                jsonResult = inputStreamToString(httpResponse.getEntity().getContent()).toString();
                System.out.println("Result " + jsonResult);
                jObjResult =new JSONObject(jsonResult) ;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return jObjResult;
        }
        @Override
        protected void onPostExecute(JSONObject json) {
            chat_msg.setText("");

            String res = null;
            try {
                res = json.getString("response");
                if(res.equals("Failure")){
                    Toast.makeText(getApplicationContext(),"The user has logged out. You cant send message anymore !",Toast.LENGTH_SHORT).show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}