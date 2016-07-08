package com.wre.yin.whiterabbiteventapp.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wre.yin.whiterabbiteventapp.beans.ChatBean;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 6;

    // Database Name
    private static final String DATABASE_NAME = "WREX_CHAT";

    private static final String TABLE_NOTY_HISTORY = "noty_chat_history";
    private static final String TABLE_CHAT_HISTORY = "chat_history";
    private static final String CHAT_ID = "chat_id";
    private static final String FROM_NAME = "from_name";
    private static final String TO_NAME = "to_name";
    private static final String MSG_TIME = "msg_time";
    private static final String CHAT_TOPIC = "chat_topic";
    private static final String MESSAGE = "message";
    private static final String EVENT_ID = "eventId";


    private static final String CREATE_TABLE_NOTY_CHAT = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NOTY_HISTORY + "(" + CHAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + FROM_NAME
            + " TEXT," + MESSAGE + " TEXT," + MSG_TIME
            + " TEXT," + EVENT_ID
            + " TEXT," + CHAT_TOPIC
            + " TEXT" + ")";

    private static final String CREATE_TABLE_CHAT_HISTORY = "CREATE TABLE IF NOT EXISTS "
            + TABLE_CHAT_HISTORY + "(" + CHAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + FROM_NAME
            + " TEXT," + TO_NAME + " TEXT," + MESSAGE
            + " TEXT," + MSG_TIME
            + " TEXT," + EVENT_ID
            + " TEXT," + CHAT_TOPIC + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CHAT_HISTORY);
        db.execSQL(CREATE_TABLE_NOTY_CHAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAT_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTY_HISTORY);
        onCreate(db);
    }

    public long insertNotyValues(ChatBean chatBean) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FROM_NAME, chatBean.getFromName());
        values.put(MESSAGE, chatBean.getMsg());
        values.put(MSG_TIME, chatBean.getMsgTime());
        values.put(CHAT_TOPIC, chatBean.getChatTopic());
        values.put(EVENT_ID, chatBean.getEventId());

        long re = db.insert(TABLE_NOTY_HISTORY, null, values);
        return re;
    }

    public long insertChatValues(ChatBean chatBean) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FROM_NAME, chatBean.getFromName());
        values.put(TO_NAME, chatBean.getToName());
        values.put(MESSAGE, chatBean.getMsg());
        values.put(MSG_TIME, chatBean.getMsgTime());
        values.put(CHAT_TOPIC, chatBean.getChatTopic());
        values.put(EVENT_ID, chatBean.getEventId());

        long re = db.insert(TABLE_CHAT_HISTORY, null, values);
        return re;
    }

    public List<ChatBean> getAllNoty() {
        List<ChatBean> f = new ArrayList<ChatBean>();
        String selectQuery = "SELECT  * FROM " + TABLE_NOTY_HISTORY;


        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    ChatBean td = new ChatBean();
                    td.setFromName(c.getString(c.getColumnIndex(FROM_NAME)));
                    td.setMsg((c.getString(c.getColumnIndex(MESSAGE))));
                    td.setMsgTime((c.getString(c.getColumnIndex(MSG_TIME))));
                    td.setEventId((c.getString(c.getColumnIndex(EVENT_ID))));
                    td.setChatTopic((c.getString(c.getColumnIndex(CHAT_TOPIC))));
                    f.add(td);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<ChatBean> getAllNoty(String topic) {
        List<ChatBean> f = new ArrayList<ChatBean>();
        String selectQuery = "SELECT  * FROM " + TABLE_NOTY_HISTORY + " where " + CHAT_TOPIC + "='" + topic + "'";


        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    ChatBean td = new ChatBean();
                    td.setFromName(c.getString(c.getColumnIndex(FROM_NAME)));
                    td.setMsg((c.getString(c.getColumnIndex(MESSAGE))));
                    td.setMsgTime((c.getString(c.getColumnIndex(MSG_TIME))));
                    td.setEventId((c.getString(c.getColumnIndex(EVENT_ID))));
                    td.setChatTopic((c.getString(c.getColumnIndex(CHAT_TOPIC))));
                    f.add(td);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<ChatBean> getAllChat(String topic) {
        List<ChatBean> f = new ArrayList<ChatBean>();
        String selectQuery = "SELECT  * FROM " + TABLE_CHAT_HISTORY + " where " + CHAT_TOPIC + "='" + topic + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    ChatBean td = new ChatBean();
                    td.setFromName(c.getString(c.getColumnIndex(FROM_NAME)));
                    td.setToName(c.getString(c.getColumnIndex(TO_NAME)));
                    td.setMsg((c.getString(c.getColumnIndex(MESSAGE))));
                    td.setMsgTime((c.getString(c.getColumnIndex(MSG_TIME))));
                    td.setEventId((c.getString(c.getColumnIndex(EVENT_ID))));
                    f.add(td);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public void deleteNotypAll(String topic) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_NOTY_HISTORY, CHAT_TOPIC + " = ?", new String[]{topic});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

}
