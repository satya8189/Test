package com.wre.yin.whiterabbiteventapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.Manifest;
import com.wre.yin.whiterabbiteventapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Constants {

    public static final String IMAGE_DIRECTORY_NAME = "Image File Upload";
    public static final String VIDEO_DIRECTORY_NAME = "Video File Upload";
    // Number of columns of Grid View
    public static final int NUM_OF_COLUMNS = 2;
    // Gridview image padding
    public static final int GRID_PADDING = 10; // in dp
    // SD card image directory
    public static final String PHOTO_ALBUM = "/DCIM/" + "/Camera/";
    // supported file formats
    public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg", "png");
    // Permissions for Marshmallow
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    //url constants
    public static String URL1 = "http://192.168.1.8:8080/whiterabbitevent/admin/";

    public static String URL2 = "http://192.168.1.85:8080/Chatting/rest/chat/";

    public static String IMAGE_URL = "http://183.82.103.156:8080/Resources/wre/";

    public static String URL = "http://183.82.103.156:8080/whiterabbitevent/admin/";
    public static final String BASE_URL = "http://183.82.103.156:8080";


    public static final String SEND_MESSAGE_URL = "http://183.82.103.156:8080/whiterabbitevent/send";


    public static final String EVENT_SERVICES_LIST = URL + "eventServicesList?eventId=";
    public static final String AGENDA = URL + "agendoDetails";
    public static final String NEWS_LIST = URL + "newsList";
    public static final String SPONSORS_LIST = URL + "sponsorsList";
    public static final String SPEAKERS_LIST = URL + "speakersList";
    public static final String INDIVIDUAL_SPEAKER = URL + "getSpeakerBySpeakerId?speakerId=";
    public static final String INDIVIDUAL_SPONSOR = URL + "getSponsorDataonSponsorId?sponcorId=";
    public static final String QUESTIONS_LIST = URL + "questionList?eventId=";
    public static final String QUESTIONS_ANSWER_SAVE = URL + "saveQuestionAnswer";
    public static final String PARTICIPANT_LIST = URL + "ParticipantEventBeanList";
    public static final String ABOUT_EVENT = URL + "Viewdetails?eventId=";
    public static final String PARTICIPANT_EVENT_STATUS = URL + "eventParticipantStatusSave";
    public static final String EVENT_IMAGES = URL + "getEventImages";
    public static final String SAVE_HELP_DETAILS = URL + "updateHelpDetails";
    public static final String PARTICIPANT_UPDATE = URL + "updateParticipantDetails";
    public static final String FILES_LIST = URL + "galaryList?eventId=";
    public static final String ATTENDENCE_STATUS = URL + "getEventParticipantStatus?eventId=";
    public static final String SPEAKER_QUERY = URL + "participantQueriesSave";
    public static final String SOCIAL_MEDIA_IDS = URL + "getSocialMediaList?eventId=";
    public static final String PROFILE_PIC_UPLOAD = URL + "profilePicUpload";
    public static final String SPEAKER_RATING = URL + "saveUserRating";
    public static final String CHAT_TOPICS_LIST = URL + "chatTopicList?eventId=";
    public static final String IMAGE_LIST = URL + "galaryImageList?eventId=";
    public static final String IMAGE_LIKE_SAVE = URL + "galleryImageStatusSave";


    //Image Gallery file path constansts
    public static String PARTICIPENT_URL = "http://183.82.103.156:8080/whiterabbitevent/";
    public static final String PARTICIPENT_LOGIN = PARTICIPENT_URL + "participantlogin";
    public static final String PARTICIPENT_REG_UPDATE = PARTICIPENT_URL + "participantRegUpdate";
    public static String SYSTEM_URL = "http://183.82.103.156:8080/whiterabbitevent/systemadmin/";
    public static final String EVENT_LIST = SYSTEM_URL + "getParticipantEventList";

    public static final String UPLOAD_IMAGE_VIDEO = URL + "imageUpload";

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

        alertD.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        WindowManager.LayoutParams wmlp = alertD.getWindow().getAttributes();
        wmlp.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;


        CardView llover = (CardView) promptView.findViewById(R.id.llover);
        ImageView matter = (ImageView) promptView.findViewById(R.id.error_img);
        TextView alertmsg = (TextView) promptView.findViewById(R.id.error_txt);

        Button okBtn = (Button) promptView.findViewById(R.id.ok_btn);
        if (type.matches("success")) {
            matter.setImageResource(R.drawable.correct_icon);
            okBtn.setTextColor(ContextCompat.getColor(context, R.color.successmsg));
            // llover.setBackgroundColor(context.getResources().getColor(R.color.successmsg));
        } else {
            matter.setImageResource(R.drawable.wrong_icon);
            okBtn.setTextColor(ContextCompat.getColor(context, R.color.errormsg));
            //  llover.setBackgroundResource(R.drawable.rectangle_shape_alert_box);
        }
        alertmsg.setText(text);
        alertD.setView(promptView);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertD.dismiss();
            }
        });
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
        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_CONTACTS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;

    }
    // *** Check Permissions for Marshmallow end ***//


}


