package com.wre.yin.whiterabbiteventapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.R;


public class Constants {

    //url constants
    public static String URL = "http://192.168.1.85:8080/Chatting/rest/chat/";


    public static final String IMAGE_DIRECTORY_NAME = "Image File Upload";
    public static final String VIDEO_DIRECTORY_NAME = "Video File Upload";
    public static final String UPLOAD_IMAGE_VIDEO=URL+"imageUpload";

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void createDialogSend(Context context, String type, String text) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.succesorerror, null);

        final AlertDialog alertD = new AlertDialog.Builder(context).create();
        alertD.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = alertD.getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;


        LinearLayout llover = (LinearLayout) promptView.findViewById(R.id.llover);
        ImageView matter = (ImageView) promptView.findViewById(R.id.error_img);
        TextView alertmsg = (TextView) promptView.findViewById(R.id.error_txt);
        if (type.matches("success")) {
            matter.setImageResource(R.drawable.tick_button);
            llover.setBackgroundColor(context.getResources().getColor(R.color.successmsg));
        } else {
            matter.setImageResource(R.drawable.cross_red);
            llover.setBackgroundColor(context.getResources().getColor(R.color.errormsg));
        }
        alertmsg.setText(text);
        alertD.setView(promptView);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alertD.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // d.show();
        alertD.getWindow().setAttributes(lp);
        alertD.show();
    }

}


