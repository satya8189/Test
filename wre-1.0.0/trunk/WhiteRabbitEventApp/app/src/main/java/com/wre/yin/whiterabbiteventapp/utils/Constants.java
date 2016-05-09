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
    public static String URL = "http://183.82.103.156:8080/PredictsAndWinServices/rest/user/";
    public static String LOGIN_URL = URL + "userAuthentication";

    public static String GET_SCHEDULE_NAMES = URL + "getPredicts";
    public static String GET_QUESTIONS = URL + "getQuestions";
    public static String SAVE_USER = URL + "saveUser";
    public static String FORGOT_PASSWORD = URL + "forgotPassword";
    public static String UPDATE_USER = URL + "updateUser";
    public static String SAVE_ANSWER = URL + "saveUserAnswer";
    public static String GET_USER = URL + "getUser";
    public static String CHANGE_PASSWORD = URL + "updatePassword";
    public static String GET_RESULTS = URL + "getResults";

    public static String GET_EARNINGS = URL + "getEarnings";

    public static String SAVE_REDEEME_REQUEST = URL + "saveRedeemRequest";

    public static String SUCCESS = "success";
    public static String INVALID_PHONE = "inavlidphoneno";
    public static String INVALID_PASSWORD = "invalidpassword";
    public static String FAIL = "fail";
    public static int CHECK_POINTS=300;
    public static String SHARE_BODY = "Download Predict and win app you will get up to 1 crore.Here is the Link./n" + "https://play.google.com/store/apps/details?id=com.yinsol.sammakkasarakka&hl=en";
    public static String REPORT_MAIL="k.prawins@gmail.com";

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


