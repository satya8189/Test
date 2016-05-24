package com.wre.yin.whiterabbiteventapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.wre.yin.whiterabbiteventapp.beans.Result;
import com.wre.yin.whiterabbiteventapp.beans.UploadImgVid;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideosActivity extends AppCompatActivity {

    private TextView text;
    private Button uploadVideo;
    private LinearLayout camGalLayout;
    private CircleImageView camPick, gallPick;

    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_VIDEO = 1;
    private Uri fileUri;

    String layoutStatus = "gone";
    private String vidPath, fileName, fileTpe, encodedString;
    private static int RESULT_LOAD_VID = 1;

    ProgressDialog prgDialog;
    Bitmap bitmap;


    private GridView videoGridView;
    private Cursor cursor;
    private int columnIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        prgDialog = new ProgressDialog(this);
        prgDialog.setCancelable(false);

        uploadVideo = (Button) findViewById(R.id.upload_video);
        camGalLayout = (LinearLayout) findViewById(R.id.upload_video_view);
        camPick = (CircleImageView) findViewById(R.id.video_camara_link);
        gallPick = (CircleImageView) findViewById(R.id.video_gallery_link);
        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutStatus.equals("gone")) {
                    camGalLayout.setVisibility(View.VISIBLE);
                    layoutStatus = "visible";
                } else {
                    camGalLayout.setVisibility(View.GONE);
                    layoutStatus = "gone";
                }

            }
        });
        camPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordVideo();
                camGalLayout.setVisibility(View.GONE);
                layoutStatus = "gone";
            }
        });
        gallPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadVideofromGallery();
                camGalLayout.setVisibility(View.GONE);
                layoutStatus = "gone";
            }
        });


            }


    /**
     * Launching camera app to record video
     */
    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);

        // set video quality
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file
        // name

        // start the video capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_VIDEO_REQUEST_CODE);
    }

    public void loadVideofromGallery() {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_VID);
    }

    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Constants.VIDEO_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Acc", "Oops! Failed create "
                        + Constants.VIDEO_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == CAMERA_CAPTURE_VIDEO_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {

                    // video successfully recorded
                    // launching upload activity
                    //launchUploadActivity(false);
                    vidPath = fileUri.getPath();
                    String fileNameSegments[] = vidPath.split("/");
                    fileName = fileNameSegments[fileNameSegments.length - 1];
                    // Put file name in Async Http Post Param which will used in Java web app

                    uploadVideoFromCam();
                    System.out.println("Camara video path" + fileUri.getPath());

                } else if (resultCode == RESULT_CANCELED) {

                    // user cancelled recording
                    Toast.makeText(getApplicationContext(),
                            "User cancelled video recording", Toast.LENGTH_SHORT)
                            .show();

                } else {
                    // failed to record video
                    Toast.makeText(getApplicationContext(),
                            "Sorry! Failed to record video", Toast.LENGTH_SHORT)
                            .show();
                }
            } else {
                // When an Image is picked
                if (requestCode == RESULT_LOAD_VID && resultCode == RESULT_OK
                        && null != data) {
                    // Get the Image from data

                    Uri selectedVideo = data.getData();
                    String[] filePathColumn = {MediaStore.Video.Media.DATA};

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(selectedVideo,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    vidPath = cursor.getString(columnIndex);
                    cursor.close();
                    /*ImageView imgView = (ImageView) findViewById(R.id.imgView);
                    // Set the Image in ImageView
					imgView.setImageBitmap(BitmapFactory
							.decodeFile(imgPath));*/
                    // Get the Image's file name
                    String fileNameSegments[] = vidPath.split("/");
                    fileName = fileNameSegments[fileNameSegments.length - 1];
                    // Put file name in Async Http Post Param which will used in Java web app

                    uploadVideoFromCam();

                } else {
                    Toast.makeText(this, "You haven't picked video",
                            Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void uploadVideoFromCam() {
        // When Image is selected from Gallery
        if (vidPath != null && !vidPath.isEmpty()) {
            prgDialog.setMessage("Converting Video to Binary Data");
            prgDialog.show();
            // Convert image to String using Base64
            fileTpe = "video";
            encodeVideoToString();
            // When Image is not selected from Gallery
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "You must select video from gallery before you try to upload",
                    Toast.LENGTH_LONG).show();
        }
    }

    // AsyncTask - To convert Image to String
    public void encodeVideoToString() {
        new AsyncTask<Void, Void, String>() {

            protected void onPreExecute() {

            } ;

            @Override
            protected String doInBackground(Void... params) {

                if (fileTpe.equals("video")) {
                    FileInputStream is = null;
                    try {
                        is = new FileInputStream(vidPath);

                        byte[] byteArr = IOUtils.toByteArray(is);
                        encodedString = Base64.encodeToString(byteArr, 0);
                    } catch (IOException ioe) {
                    }

                }
                return "";
            }

            @Override
            protected void onPostExecute(String msg) {
                //prgDialog.setMessage("Calling Upload");
                // Put converted Image string into Async Http Post param
                prgDialog.dismiss();
                UploadImgVid uploadImgVid = new UploadImgVid();
                uploadImgVid.setEncodeString(encodedString);
                uploadImgVid.setVideoName(fileName);
                uploadImgVid.setFileType(fileTpe);

                new MyAsyncTask(Constants.UPLOAD_IMAGE_VIDEO, Utils.getJson(uploadImgVid), VideosActivity.this, new Callback() {
                    public void onResult(String result) {

                        Result res = Utils.getObject(result, Result.class);
                        if (res.getResult().equals("success")) {
                            Toast.makeText(VideosActivity.this, "Video upload successfull..", Toast.LENGTH_LONG).show();
                        }
                    }
                }).execute();

            }
        }.execute(null, null, null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
