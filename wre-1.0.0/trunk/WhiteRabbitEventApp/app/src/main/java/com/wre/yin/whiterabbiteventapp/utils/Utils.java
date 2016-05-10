package com.wre.yin.whiterabbiteventapp.utils;

import com.google.gson.Gson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class Utils {
    private Utils() {
    }

    public static <T> T getObject(final String jsonString, final Class<T> objectClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, objectClass);
    }

    public static String getJson(final Object object) {
        Gson gson = new Gson();
        String res = gson.toJson(object);
        System.out.println("Json :" + res);
        return res;
    }

    public static <T> List<T> getList(final String jsonString, final Class<T> objectClass) {

        ObjectMapper mapper = new ObjectMapper();
        List<T> list = null;

        try {
            list = mapper.readValue(jsonString, TypeFactory.defaultInstance()
                    .constructCollectionType(List.class, objectClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static String getString(final String jsonString) {
        JSONObject json = null;
        String res = null;
        try {
            json = new JSONObject(jsonString);
            res = json.getString("result");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        return dateFormat.format(cal.getTime());
    }

    public static boolean checkMobile(String mobile) {
        if (mobile.matches("[7-9][0-9]{9}")) {
            return true;
        }
        return false;

    }

    public static float getPercentage(int total, int count) {
        float proportion = ((float) count) / ((float) total);
        return proportion * 100;
    }


}