package com.wre.yin.whiterabbiteventapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.Manifest;
import com.wre.yin.whiterabbiteventapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Constants {

    //url constants
    public static String URL1 = "http://192.168.1.85:8080/Chatting/rest/chat/";

    public static String URL = "http://183.82.103.156:8080/whiterabbitevent/admin/";
    public static String PARTICIPENT_URL = "http://183.82.103.156:8080/whiterabbitevent/";




    public static final String IMAGE_DIRECTORY_NAME = "Image File Upload";
    public static final String VIDEO_DIRECTORY_NAME = "Video File Upload";
    public static final String UPLOAD_IMAGE_VIDEO = URL1 + "imageUpload";

    public static final String AGENDA=URL+"agendoDetails";
    public static final String NEWS_LIST=URL+"newsList";
    public static final String PARTICIPENT_LOGIN=PARTICIPENT_URL+"participantlogin";
    public static final String PARTICIPENT_REG_UPDATE=PARTICIPENT_URL+"participantRegUpdate";


    //Image Gallery file path constansts

    // Number of columns of Grid View
    public static final int NUM_OF_COLUMNS = 2;

    // Gridview image padding
    public static final int GRID_PADDING = 10; // in dp

    // SD card image directory
    public static final String PHOTO_ALBUM = "/DCIM/" + "/Camera/";

    // supported file formats
    public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg",
            "png");

    // Permissions for Marshmallow
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;


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
        wmlp.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;


        LinearLayout llover = (LinearLayout) promptView.findViewById(R.id.llover);
        ImageView matter = (ImageView) promptView.findViewById(R.id.error_img);
        TextView alertmsg = (TextView) promptView.findViewById(R.id.error_txt);
        if (type.matches("success")) {
            matter.setImageResource(R.drawable.tick_button);
            llover.setBackgroundColor(context.getResources().getColor(R.color.successmsg));
        } else {
            matter.setImageResource(R.drawable.cross_red);
            llover.setBackgroundResource(R.drawable.rectangle_shape_alert_box);
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

    // Check Permissions for Marshmallow start

    public static boolean checkAndRequestPermissions(AppCompatActivity activity) {
        int storagePermission = ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int locationPermission = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (locationPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;

    }
    // *** Check Permissions for Marshmallow end ***//


}


