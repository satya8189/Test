package com.wre.yin.whiterabbiteventapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.beans.ParticipantBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmpProfileActivity extends AppCompatActivity {

    private ImageView empProfilePic;
    private EditText empName, empMail, empMobile, empAlterMobile, empOrg, empDesignation;
    private Button saveUpdateBtn, profilePic;

    private SharedPreferences prefs;
    private String partiName, partId, encodedString, partiMobile, partiMail, partAltNumber, partDesig, partOrg, eventId, imgPath, fileName, fileTpe;
    String layoutStatus = "gone";
    private LinearLayout camGalLayout;
    private CircleImageView camPick, gallPick;

    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static int RESULT_LOAD_IMG = 1;
    ProgressDialog prgDialog;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EmpProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_emp_profile);
        //getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Profile Details");

        prefs = getSharedPreferences("Chat", 0);
        partiName = prefs.getString("name", null);
        partiMail = prefs.getString("mail", null);
        partiMobile = prefs.getString("mobile", null);

        partId = prefs.getString("partId", null);
        eventId = prefs.getString("eventId", null);
        prgDialog = new ProgressDialog(this);
        prgDialog.setCancelable(false);
        // eventId = getIntent().getExtras().getString("eventId");
        empProfilePic = (ImageView) findViewById(R.id.emp_profile_image);

        Picasso.with(EmpProfileActivity.this).load("http://183.82.103.156:8080/Resources/wre/profile_pics/" + partId + "/profile.jpg").placeholder(R.drawable.user_icon).into(empProfilePic);

        empName = (EditText) findViewById(R.id.emp_name);
        empMail = (EditText) findViewById(R.id.emp_mail);
        empMobile = (EditText) findViewById(R.id.emp_mobile);
        empAlterMobile = (EditText) findViewById(R.id.emp_alternate_mobile);
        // empOrg = (EditText) findViewById(R.id.emp_org);
        // empDesignation = (EditText) findViewById(R.id.emp_designation);

        saveUpdateBtn = (Button) findViewById(R.id.save_update_btn);
        profilePic = (Button) findViewById(R.id.edit_profile_pic);
        camGalLayout = (LinearLayout) findViewById(R.id.upload_profile_image_view);

        camPick = (CircleImageView) findViewById(R.id.profile_camara_link);
        gallPick = (CircleImageView) findViewById(R.id.profile_gallery_link);

        empName.setText(partiName);
        empMail.setText(partiMail);
        empMobile.setText(partiMobile);


        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    if (layoutStatus.equals("gone")) {
                    camGalLayout.setVisibility(View.VISIBLE);
                    layoutStatus = "visible";
                } else {
                    camGalLayout.setVisibility(View.GONE);
                    layoutStatus = "gone";
                }*/

                LayoutInflater layoutInflater = LayoutInflater.from(EmpProfileActivity.this);
                View promptView = layoutInflater.inflate(R.layout.pick_one, null);

                final AlertDialog alertD = new AlertDialog.Builder(EmpProfileActivity.this).create();
                alertD.requestWindowFeature(Window.FEATURE_NO_TITLE);

                alertD.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                WindowManager.LayoutParams wmlp = alertD.getWindow().getAttributes();
                wmlp.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;

                LinearLayout camLayout = (LinearLayout) promptView.findViewById(R.id.cam_layout);
                LinearLayout galLayout = (LinearLayout) promptView.findViewById(R.id.gal_layout);

                camLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        captureImage();

                    }
                });
                galLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadImagefromGallery();
                    }
                });
                alertD.setView(promptView);


                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alertD.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                // d.show();
                alertD.getWindow().setAttributes(lp);
                alertD.show();
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


        saveUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Constants.isNetworkAvailable(EmpProfileActivity.this)) {

                    String updatePartiName = empName.getText().toString();
                    String upadatePartMobile = empMobile.getText().toString();
                    String updatePartEmail = empMail.getText().toString();
                    String partAltNumber = empAlterMobile.getText().toString();

                    ParticipantBean partBean = new ParticipantBean();
                    partBean.setFirstName(updatePartiName);
                    partBean.setEmailId(updatePartEmail);
                    partBean.setPhoneNumber(upadatePartMobile);
                    partBean.setStatus("ACTIVE");
                    // partBean.setLastName("Kumar");

                    partBean.setParticipantId(Long.parseLong(partId));

                    new MyAsyncTask(Constants.PARTICIPANT_UPDATE, Utils.getJson(partBean), EmpProfileActivity.this, new Callback() {
                        @Override
                        public void onResult(String result) {
                            Constants.createDialogSend(EmpProfileActivity.this, "success", "Your details saved successfully");
                        }
                    }).execute();
                } else {
                    Constants.createDialogSend(EmpProfileActivity.this, "error", "Please connect to internet");
                }

            }
        });

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
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }

    public void loadImagefromGallery() {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
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
            fileTpe = "profile_pics";
            encodeImagetoString();
            // When Image is not selected from Gallery
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "You must select image from gallery before you try to upload",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void encodeImagetoString() {
        if (Constants.isNetworkAvailable(EmpProfileActivity.this)) {
            new AsyncTask<Void, Void, String>() {

                protected void onPreExecute() {

                }


                @Override
                protected String doInBackground(Void... params) {

                    if (fileTpe.equals("profile_pics")) {
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
                    uploadImgVid.setName(fileName);
                    uploadImgVid.setType(fileTpe);
                    uploadImgVid.setEventId(Long.parseLong(eventId));
                    uploadImgVid.setParticipantId(Long.parseLong(partId));
                    if (Constants.isNetworkAvailable(EmpProfileActivity.this)) {
                        new MyAsyncTask(Constants.PROFILE_PIC_UPLOAD, Utils.getJson(uploadImgVid), EmpProfileActivity.this, new Callback() {
                            public void onResult(String result) {

                                System.out.println("Result:" + result);
                                if (result != null) {
                                    String res = Utils.getString("result", result);
                                    if (res.equals("success")) {
                                        Picasso.with(EmpProfileActivity.this).load("http://183.82.103.156:8080/Resources/wre/profile_pics/" + partId + "/profile.jpg").placeholder(R.drawable.user_icon).into(empProfilePic);
                                    }
                                }
                            }
                        }).execute();

                    } else {
                        Constants.createDialogSend(EmpProfileActivity.this, "error", "Please connect to internet");
                    }
                }
            }.execute(null, null, null);
        } else {
            Constants.createDialogSend(EmpProfileActivity.this, "error", "Please connect to internet");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                finish();
                break;

            case R.id.action_settings:
                Intent i = new Intent(EmpProfileActivity.this, NotificatonsettingsAct.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //   EmpProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        finish();
    }
}
