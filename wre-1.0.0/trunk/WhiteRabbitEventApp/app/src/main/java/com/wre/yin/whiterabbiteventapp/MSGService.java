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


public class MSGService extends IntentService {

    SharedPreferences prefs;
    SharedPreferences prefs1;
    NotificationCompat.Builder notification;
    NotificationManager manager;


    public MSGService() {
        super("MSGService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

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
                    sendNotification(extras.getString("msg"), extras.getString("fromu"), extras.getString("name"));
                }

                Log.i("TAG", "Received final: " + extras.getString("msg"));
            }
        }
        MSGReceiver.completeWakefulIntent(intent);
    }


    private void sendNotification(String msg, String mobno, String name) {

        Bundle args = new Bundle();
        args.putString("mobno", mobno);
        args.putString("name", name);
        args.putString("msg", msg);
        Intent chat = new Intent(this, MessageActivity.class);
        chat.putExtra("INFO", args);
        notification = new NotificationCompat.Builder(this);
        notification.setContentTitle(name);
        notification.setContentText(msg);
        notification.setTicker("New Message !");
        notification.setSmallIcon(R.drawable.wre_logo);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 1000,
                chat, PendingIntent.FLAG_CANCEL_CURRENT);
        notification.setContentIntent(contentIntent);
        notification.setAutoCancel(true);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification.build());
    }


}