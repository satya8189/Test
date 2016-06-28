package com.wre.yin.whiterabbiteventapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.adapters.GridViewImageAdapter;
import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.GalleryUtils;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class CrowdPicsActivity extends AppCompatActivity {

    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static int RESULT_LOAD_IMG = 1;
    String layoutStatus = "gone";
    ProgressDialog prgDialog;
    Bitmap bitmap;
    private TextView text;
    private Button uploadImage;
    private LinearLayout camGalLayout;
    private CircleImageView camPick, gallPick;
    private Uri fileUri;
    private String eventId,imgPath, fileName, fileTpe, encodedString,eventName,partName,fName;
    private GalleryUtils utils;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;

    private SharedPreferences prefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crowd_pics);

        String nameTxt = getIntent().getExtras().getString("name");
        prefs = getSharedPreferences("Chat", 0);
        partName=prefs.getString("name", null);
        eventName=prefs.getString("eventName", null);

        prgDialog = new ProgressDialog(this);
        prgDialog.setCancelable(false);
        eventId = getIntent().getExtras().getString("eventId");
        uploadImage = (Button) findViewById(R.id.upload_image);
        camGalLayout = (LinearLayout) findViewById(R.id.upload_image_view);
        camPick = (CircleImageView) findViewById(R.id.camara_link);
        gallPick = (CircleImageView) findViewById(R.id.gallery_link);
        uploadImage.setOnClickListener(new View.OnClickListener() {
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
                captureImage();
                camGalLayout.setVisibility(View.GONE);
                layoutStatus = "gone";
            }
        });
        gallPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImagefromGallery();
                camGalLayout.setVisibility(View.GONE);
                layoutStatus = "gone";
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);


        gridView = (GridView) findViewById(R.id.upload_image_grid);
        utils = new GalleryUtils(this);

        // Initilizing Grid View
        InitilizeGridLayout();

        // loading all image paths from SD card
        imagePaths = utils.getFilePaths();

        // Gridview adapter
        adapter = new GridViewImageAdapter(CrowdPicsActivity.this, imagePaths,
                columnWidth);

        // setting grid view adapter
        gridView.setAdapter(adapter);
    }

    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Constants.IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Acc", "Oops! Failed create "
                        + Constants.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG-" + timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }


    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                Constants.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - ((Constants.NUM_OF_COLUMNS + 1) * padding)) / Constants.NUM_OF_COLUMNS);

        gridView.setNumColumns(Constants.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }

    public void loadImagefromGallery() {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {

                    // successfully captured the image
                    // launching upload activity
                    //launchUploadActivity(true);
                    imgPath = fileUri.getPath();
                    String fileNameSegments[] = imgPath.split("/");
                    fileName = fileNameSegments[fileNameSegments.length - 1];
                    String fileNameSeg[]=fileName.split("-");

                    fName=eventName+"-"+partName+"-"+fileNameSeg[1]+"-"+new SimpleDateFormat("HHmmss",
                            Locale.getDefault()).format(new Date());
                    // Put file name in Async Http Post Param which will used in Java web app
                    //params.put("filename", fileName);
                    uploadImageFromCam();
                    System.out.println("Camara image path" + fileUri.getPath());


                } else if (resultCode == RESULT_CANCELED) {

                    // user cancelled Image capture
                    Toast.makeText(getApplicationContext(),
                            "User cancelled image capture", Toast.LENGTH_SHORT)
                            .show();

                } else {
                    // failed to capture image
                    Toast.makeText(getApplicationContext(),
                            "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                            .show();
                }

            } else {
                // When an Image is picked
                if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                        && null != data) {
                    // Get the Image from data

                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imgPath = cursor.getString(columnIndex);
                    cursor.close();
                    /*ImageView imgView = (ImageView) findViewById(R.id.imgView);
                    // Set the Image in ImageView
                    imgView.setImageBitmap(BitmapFactory
                            .decodeFile(imgPath));*/
                    // Get the Image's file name
                    String fileNameSegments[] = imgPath.split("/");
                    fileName = fileNameSegments[fileNameSegments.length - 1];

                    String fileNameSeg[]=fileName.split("-");
                    fName=eventName+"-"+partName+"-"+fileNameSeg[1]+"-"+new SimpleDateFormat("HHmmss",
                            Locale.getDefault()).format(new Date());
                    uploadImageFromCam();
                    // Put file name in Async Http Post Param which will used in Java web app
                    // params.put("filename", fileName);

                } else {
                    Toast.makeText(this, "You haven't picked Image",
                            Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void uploadImageFromCam() {
        // When Image is selected from Gallery
        if (imgPath != null && !imgPath.isEmpty()) {
            prgDialog.setMessage("Converting Image to Binary Data");
            prgDialog.show();
            // Convert image to String using Base64
            fileTpe = "image";
            encodeImagetoString();
            // When Image is not selected from Gallery
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "You must select image from gallery before you try to upload",
                    Toast.LENGTH_LONG).show();
        }
    }

    // AsyncTask - To convert Image to String
    public void encodeImagetoString() {
        if (Constants.isNetworkAvailable(CrowdPicsActivity.this)) {
            new AsyncTask<Void, Void, String>() {

                protected void onPreExecute() {

                }

                ;

                @Override
                protected String doInBackground(Void... params) {

                    if (fileTpe.equals("image")) {
                        BitmapFactory.Options options = null;
                        options = new BitmapFactory.Options();
                        options.inSampleSize = 3;
                        bitmap = BitmapFactory.decodeFile(imgPath,
                                options);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        // Must compress the Image to reduce image size to make upload easy
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                        byte[] byte_arr = stream.toByteArray();
                        // Encode Image to String
                        encodedString = Base64.encodeToString(byte_arr, 0);
                    }
                    return "";
                }

                @Override
                protected void onPostExecute(String msg) {
                    //prgDialog.setMessage("Calling Upload");
                    // Put converted Image string into Async Http Post param
                    //params.put("image", encodedString);
                    // Trigger Image upload
                    //triggerImageUpload();
                    prgDialog.dismiss();
                    GalaryBean uploadImgVid = new GalaryBean();
                    uploadImgVid.setEncodeString(encodedString);
                    uploadImgVid.setName(fName);
                    uploadImgVid.setType(fileTpe);
                    uploadImgVid.setFileName(fileName);
                    uploadImgVid.setEventId(Long.parseLong(eventId));
                    if (Constants.isNetworkAvailable(CrowdPicsActivity.this)) {
                        new MyAsyncTask(Constants.UPLOAD_IMAGE_VIDEO, Utils.getJson(uploadImgVid), CrowdPicsActivity.this, new Callback() {
                            public void onResult(String result) {
                            String res=Utils.getString("result",result);
                                if(res.equals("success")){
                                    Constants.createDialogSend(CrowdPicsActivity.this,"success","Your image has been upload successfully..");
                                }else{
                                    Constants.createDialogSend(CrowdPicsActivity.this,"fail","Something went wrong please try again..");
                                }
                            }
                        }).execute();

                    } else {
                        Constants.createDialogSend(CrowdPicsActivity.this, "error", "Please connect to internet");
                    }
                }
            }.execute(null, null, null);
        } else {
            Constants.createDialogSend(CrowdPicsActivity.this, "error", "Please connect to internet");
        }
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
