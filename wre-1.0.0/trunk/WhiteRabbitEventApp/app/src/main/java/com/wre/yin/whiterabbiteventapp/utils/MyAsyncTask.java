package com.wre.yin.whiterabbiteventapp.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyAsyncTask extends AsyncTask<Void, Void, String> {

    ProgressDialog dialog;
    Callback callback;
    String url;
    String json;
    Context context;

    public MyAsyncTask(String url, String json, Context context, Callback callback) {
        this.callback = callback;
        this.url = url;
        this.json = json;
        this.context = context;

    }

    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "Loading", "Please wait...", true);
    }

    protected String doInBackground(Void... arg0) {
        String jsonResult = null;
        HttpResponse httpResponse = null;
        HttpClient httpclient = null;
        HttpEntity httpEntity = null;
        try {
            if (json != null && json != "") {
                HttpPost post = new HttpPost(url);
                post.setEntity(new StringEntity(json));
                httpclient = new DefaultHttpClient();
                post.setHeader("Accept", "application/json");
                post.setHeader("Content-type", "application/json");
                httpResponse = httpclient.execute(post);
                httpEntity = httpResponse.getEntity();
                jsonResult = inputStreamToString(httpResponse.getEntity().getContent()).toString();
                System.out.println("Result " + jsonResult);
            } else {

                HttpGet httpGet = new HttpGet(url);
                httpclient = new DefaultHttpClient();
                httpResponse = httpclient.execute(httpGet);
                httpEntity = httpResponse.getEntity();
                jsonResult = inputStreamToString(httpResponse.getEntity().getContent()).toString();
                System.out.println("Result " + jsonResult);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return jsonResult;
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        callback.onResult(result);
        dialog.dismiss();
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
}