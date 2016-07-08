package com.wre.yin.whiterabbiteventapp.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by root on 8/7/16.
 */
public class LoadImage extends AsyncTask<Void, Void, Bitmap> {
    Context context;
    ProgressDialog pDialog;
    Bitmap bitmap=null;
    String urlR;
    ImageCallBack imageCallBack;
    public LoadImage(String url,Context context,ImageCallBack callBack){
        this.context=context;
        this.urlR=url;
        this.imageCallBack=callBack;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading Image ....");
        pDialog.show();

    }
    protected Bitmap doInBackground(Void... args) {
        try {
            bitmap = BitmapFactory.decodeStream((InputStream)new URL(urlR).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap image) {

        if(image != null){
            imageCallBack.onResult(image);
            pDialog.dismiss();

        }else{

            pDialog.dismiss();
            Toast.makeText(context, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

        }
    }
}
