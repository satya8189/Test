package com.wre.yin.whiterabbiteventapp;


import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.wre.yin.whiterabbiteventapp.beans.ChatBean;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.DBHelper;

import java.util.List;


public class MSGService extends IntentService {

    SharedPreferences prefs;
    SharedPreferences prefs1;
    NotificationCompat.Builder notification;
    NotificationManager manager;
    private String message="";
    DBHelper db;


    public MSGService() {
        super("MSGService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        if(!Constants.isNetworkAvailable(MSGService.this)) {
            this.startService(intent);
            return;
        }
        String messageType = gcm.getMessageType(intent);
        Log.e("message type--", messageType);
        prefs = getSharedPreferences("Chat", 0);
        //  prefs1= getSharedPreferences("test",0);

        if (!extras.isEmpty()) {

            if (GoogleCloudMessaging.
                    MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                Log.e("L2C", "Error");

            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_DELETED.equals(messageType)) {
                Log.e("L2C", "Error");

            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Log.d("current--", prefs.getString("mobile", ""));
                Log.d("current value--", extras.getString("fromu"));

           /*  if(!prefs.getString("CURRENT_ACTIVE","").equals(extras.getString("fromu"))) {
                    sendNotification(extras.getString("msg"), extras.getString("fromu"), extras.getString("name"));
                }*/
                Log.d("CurrentStatus--", prefs.getString("current_status", ""));
                if (!prefs.getString("current_status", "").equals("onchat")) {
                    db=new DBHelper(getApplicationContext());
                    ChatBean chatBean=new ChatBean();
                    chatBean.setFromName(extras.getString("name"));
                    chatBean.setMsg(extras.getString("msg"));
                    chatBean.setMsgTime(extras.getString("date"));
                    chatBean.setChatTopic(extras.getString("topic"));
                    chatBean.setEventId(extras.getString("eventId"));

                    db.insertNotyValues(chatBean);

                    List<ChatBean> chatBeanList=db.getAllNoty();
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    inboxStyle.setBigContentTitle(extras.getString("name"));
                    for(ChatBean bean:chatBeanList){
                        //message=message+bean.getMsg()+" "+bean.getMsgTime()+"\n";
                        inboxStyle.addLine(bean.getMsg());
                    }

                    sendNotification(message, extras.getString("fromu"), extras.getString("name"),extras.getString("eventId"),inboxStyle);
                }else if (!prefs.getString("current_topic", "").equals(extras.getString("topic"))) {
                    db=new DBHelper(getApplicationContext());
                    ChatBean chatBean=new ChatBean();
                    chatBean.setFromName(extras.getString("name"));
                    chatBean.setMsg(extras.getString("msg"));
                    chatBean.setMsgTime(extras.getString("date"));
                    chatBean.setChatTopic(extras.getString("topic"));
                    chatBean.setEventId(extras.getString("eventId"));

                    db.insertNotyValues(chatBean);

                    List<ChatBean> chatBeanList=db.getAllNoty();
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    inboxStyle.setBigContentTitle(extras.getString("name"));
                    for(ChatBean bean:chatBeanList){
                        //message=message+bean.getMsg()+" "+bean.getMsgTime()+"\n";
                        inboxStyle.addLine(bean.getMsg());
                    }

                    sendNotification(message, extras.getString("fromu"), extras.getString("name"),extras.getString("eventId"),inboxStyle);
                }

                Log.i("TAG", "Received final: " + extras.getString("msg"));
            }
        }
        MSGReceiver.completeWakefulIntent(intent);
    }


    private void sendNotification(String msg, String mobno, String name,String eventId,NotificationCompat.InboxStyle inboxStyle) {

        Bundle args = new Bundle();
        args.putString("mobno", mobno);
        args.putString("name", name);
        args.putString("msg", msg);
        Intent chat = new Intent(this, DiscoTopics.class);
        chat.putExtra("eventId",eventId);
        chat.putExtra("INFO", args);
        notification = new NotificationCompat.Builder(this);
        notification.setContentTitle(name);
        notification.setTicker("New Message !");
        notification.setSmallIcon(R.drawable.notification_icon);
        notification.setStyle(inboxStyle);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 1000,
                chat, PendingIntent.FLAG_CANCEL_CURRENT);
        notification.setContentIntent(contentIntent);
        notification.setAutoCancel(true);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(11, notification.build());
    }


}