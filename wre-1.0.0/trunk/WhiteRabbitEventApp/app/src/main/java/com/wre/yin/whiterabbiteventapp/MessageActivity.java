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

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.adapters.ChatMessageAdapter;
import com.wre.yin.whiterabbiteventapp.beans.ChatBean;
import com.wre.yin.whiterabbiteventapp.beans.ChatMessage;
import com.wre.yin.whiterabbiteventapp.utils.DBHelper;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

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
import java.util.List;


public class MessageActivity extends AppCompatActivity {
    private ListView mListView;
    private ImageView mButtonSend;
    private EditText mEditTextMessage;
    private ImageView mImageView;

    SharedPreferences prefs;
    Bundle bundle;

    private String message, eventId;
    private String topicName, partId;
    private DBHelper dbHelper;

    private ChatMessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MessageActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_message);

        topicName = getIntent().getExtras().getString("name");
        mListView = (ListView) findViewById(R.id.listView);
        mButtonSend = (ImageView) findViewById(R.id.btn_send);
        mEditTextMessage = (EditText) findViewById(R.id.et_message);
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);
        //  text = (TextView) findViewById(R.id.activity_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(topicName);
        eventId = getIntent().getExtras().getString("eventId");

        prefs = getSharedPreferences("Chat", 0);
        partId = prefs.getString("partId", null);
        Picasso.with(getApplicationContext()).load("http://183.82.103.156:8080/Resources/wre/profile_pics/" + partId + "/profile.jpg").placeholder(R.drawable.user_icon).into(mImageView);

        dbHelper = new DBHelper(getApplicationContext());
        List<ChatBean> chatBeanList = dbHelper.getAllNoty(topicName);
        for (ChatBean bean : chatBeanList) {
            ChatBean chatBean = new ChatBean();
            chatBean.setMsgTime(bean.getMsgTime());
            chatBean.setMsg(bean.getMsg());
            chatBean.setFromName(bean.getFromName());
            chatBean.setChatTopic(bean.getChatTopic());
            chatBean.setEventId(bean.getEventId());
            dbHelper.insertChatValues(chatBean);
        }
        dbHelper.deleteNotypAll(topicName);
        List<ChatBean> chatBeanListH = dbHelper.getAllChat(topicName);
        for (ChatBean bean : chatBeanListH) {
            if (bean.getFromName() != null) {
                mimicOtherMessage(bean.getMsg(), bean.getFromName(), bean.getMsgTime());
            } else if (bean.getToName() != null) {
                sendMessage(bean.getMsg(), bean.getToName(), bean.getMsgTime());
            }


        }

        // text.setText(nameTxt);

        bundle = getIntent().getBundleExtra("INFO");
        SharedPreferences.Editor edit = prefs.edit();

        edit.putString("current_status", "onchat");
        edit.putString("current_topic", topicName);
        edit.commit();

        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, new IntentFilter("Msg"));


        if (bundle != null && bundle.getString("name") != null) {


            //mimicOtherMessage(bundle.getString("msg"), bundle.getString("name"), Utils.getDateTime());

        }
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = mEditTextMessage.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                ChatBean cBean = new ChatBean();
                cBean.setToName("You");
                cBean.setMsg(message);
                cBean.setMsgTime(Utils.getDateTime());
                cBean.setChatTopic(topicName);
                cBean.setEventId(eventId);

                dbHelper.insertChatValues(cBean);
                sendMessage(message, "You", Utils.getDateTime());
                new Send().execute();
                // mEditTextMessage.setText("");
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("You", null);
            }
        });

    }

    private BroadcastReceiver onNotice = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            ChatBean cBean = new ChatBean();
            prefs = getSharedPreferences("Chat", 0);
            if ("onchat".equals(prefs.getString("current_status", "")) && topicName.equals(intent.getStringExtra("topic"))) {
                String str = intent.getStringExtra("msg");
                String str1 = intent.getStringExtra("fromname");
                String str2 = intent.getStringExtra("topic");

                cBean.setFromName(str1);
                cBean.setMsg(str);
                cBean.setMsgTime(Utils.getDateTime());
                cBean.setChatTopic(topicName);
                cBean.setEventId(eventId);
                dbHelper = new DBHelper(getApplicationContext());
                dbHelper.insertChatValues(cBean);
                mimicOtherMessage(str, str1, Utils.getDateTime());

            }
        }

    };

    private void sendMessage(String message, String name, String time) {
        ChatMessage chatMessage = new ChatMessage(message, true, false, name, time);
        mAdapter.add(chatMessage);


    }

    private void mimicOtherMessage(String message, String name, String time) {
        ChatMessage chatMessage = new ChatMessage(message, false, false, name, time);
        mAdapter.add(chatMessage);
    }

    private void sendMessage(String name, String time) {
        ChatMessage chatMessage = new ChatMessage(null, true, true, name, time);
        mAdapter.add(chatMessage);


    }

    private void mimicOtherMessage(String name, String time) {
        ChatMessage chatMessage = new ChatMessage(null, false, true, name, time);
        mAdapter.add(chatMessage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                LocalBroadcastManager.getInstance(MessageActivity.this).unregisterReceiver(onNotice);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("current_status", "");
                edit.putString("current_topic", "");
                edit.commit();
                Intent i = new Intent(MessageActivity.this, DiscoTopics.class);
                i.putExtra("eventId", eventId);
                startActivity(i);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(MessageActivity.this).unregisterReceiver(onNotice);
        SharedPreferences.Editor edit = prefs.edit();

        edit.putString("current_status", "");
        edit.putString("current_topic", "");
        edit.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // MessageActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

        LocalBroadcastManager.getInstance(MessageActivity.this).unregisterReceiver(onNotice);
        SharedPreferences.Editor edit = prefs.edit();

        edit.putString("current_status", "");
        edit.putString("current_topic", "");
        edit.commit();
        Intent i = new Intent(MessageActivity.this, DiscoTopics.class);
        i.putExtra("eventId", eventId);
        startActivity(i);
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
                jObj.put("date", Utils.getDateTime());
                jObj.put("topic", topicName);
                jObj.put("eventId", eventId);

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
