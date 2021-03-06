package com.wre.yin.whiterabbiteventapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.beans.Result;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class VideosActivity extends AppCompatActivity {

    public static final int MEDIA_TYPE_VIDEO = 1;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 100;
    private final static Uri MEDIA_EXTERNAL_CONTENT_URI = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    private final static String _ID = MediaStore.Video.Media._ID;
    private final static String MEDIA_DATA = MediaStore.Video.Media.DATA;
    private static int RESULT_LOAD_VID = 1;
    protected Context _context;
    String layoutStatus = "gone";
    ProgressDialog prgDialog;
    private TextView text;
    private Button uploadVideo;
    private LinearLayout camGalLayout;
    private Uri fileUri;
    private String vidPath, fileName, fileTpe, encodedString, eventName, partName, fName;
    //flag for which one is used for images selection

    private Cursor _cursor;
    private int _columnIndex;
    private int[] _videosId;
    private Uri _contentUri;
    private String eventId;
    private List<HashMap<String, String>> mGridData;
    private SharedPreferences prefs;

    private GridLayoutManager gridLayout;
    private RecyclerView rView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _context = getApplicationContext();
        setContentView(R.layout.activity_videos);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        eventId = getIntent().getExtras().getString("eventId");
        prefs = getSharedPreferences("Chat", 0);
        partName = prefs.getString("name", null);
        eventName = prefs.getString("eventName", null);

        prgDialog = new ProgressDialog(this);
        prgDialog.setCancelable(false);


        _contentUri = MEDIA_EXTERNAL_CONTENT_URI;

        gridLayout = new GridLayoutManager(VideosActivity.this, 2);

        rView = (RecyclerView) findViewById(R.id.videos_grid_recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayout);

        setGalleryAdapter();
        initVideosId();

        uploadVideo = (Button) findViewById(R.id.upload_video);

        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = LayoutInflater.from(VideosActivity.this);
                View promptView = layoutInflater.inflate(R.layout.pick_one, null);

                final AlertDialog alertD = new AlertDialog.Builder(VideosActivity.this).create();
                alertD.requestWindowFeature(Window.FEATURE_NO_TITLE);

                alertD.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                WindowManager.LayoutParams wmlp = alertD.getWindow().getAttributes();
                wmlp.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;

                LinearLayout camLayout = (LinearLayout) promptView.findViewById(R.id.cam_layout);
                LinearLayout galLayout = (LinearLayout) promptView.findViewById(R.id.gal_layout);

                camLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertD.dismiss();
                        recordVideo();

                    }
                });
                galLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertD.dismiss();
                        loadVideofromGallery();

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
    }

    private AdapterView.OnItemClickListener _itemClickLis = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Now we want to actually get the data location of the file
            MediaPlayer mPlayer = new MediaPlayer();
            String[] proj = {MEDIA_DATA};
            // We request our cursor again
            _cursor = managedQuery(_contentUri,
                    proj, // Which columns to return
                    null,       // WHERE clause; which rows to return (all rows)
                    null,       // WHERE clause selection arguments (none)
                    null); // Order-by clause (ascending by name)
            // We want to get the column index for the data uri
            int count = _cursor.getCount();
            //
            _cursor.moveToFirst();
            //
            _columnIndex = _cursor.getColumnIndex(MEDIA_DATA);
            // Lets move to the selected item in the cursor
            _cursor.moveToPosition(position);
            // And here we get the filename
            String filename = _cursor.getString(_columnIndex);
            //*********** You can do anything when you know the file path :-)


            Uri intentUri = Uri.parse(filename);

            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            intent.setDataAndType(intentUri, "video/*");
            startActivity(intent);
            System.out.println("file path:" + filename);


            //showToast(filename);
            //
        }
    };

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
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID-" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    private void initVideosId() {
        try {
            //Here we set up a string array of the thumbnail ID column we want to get back
            String[] proj = {_ID};
            // Now we create the cursor pointing to the external thumbnail store
            _cursor = managedQuery(_contentUri,
                    proj, // Which columns to return
                    null,       // WHERE clause; which rows to return (all rows)
                    null,       // WHERE clause selection arguments (none)
                    null); // Order-by clause (ascending by name)
            int count = _cursor.getCount();
            // We now get the column index of the thumbnail id
            _columnIndex = _cursor.getColumnIndex(_ID);
            //initialize
            _videosId = new int[count];
            //move position to first element
            _cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                int id = _cursor.getInt(_columnIndex);
                //
                _videosId[i] = id;
                //
                _cursor.moveToNext();
                //
            }
        } catch (Exception ex) {
            showToast(ex.getMessage().toString());
        }

    }

    protected void showToast(String msg) {
        Toast.makeText(_context, msg, Toast.LENGTH_LONG).show();
    }

    private void setGalleryAdapter() {
        new MyAsyncTask(Constants.FILES_LIST + eventId + "&type=video", null, VideosActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                mGridData = new ArrayList<HashMap<String, String>>();
                List<GalaryBean> docBeanList = Utils.getList(result, GalaryBean.class);
                if (docBeanList != null) {
                    for (GalaryBean bean : docBeanList) {
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("fileName", bean.getName());
                        map.put("videoUrl", Constants.IMAGE_URL + eventId + "/video/" + bean.getFileName());
                        mGridData.add(map);
                    }
                }
                rView.setAdapter(new VideoGalleryAdapter(VideosActivity.this, (ArrayList<HashMap<String, String>>) mGridData));

            }
        }).execute();

    }

    private class VideoGalleryAdapter extends RecyclerView.Adapter<VideoRecyleHolder> {
        List<HashMap<String, String>> mapsList;
        HashMap<String, String> maps;
        private Context mcontext;

        public VideoGalleryAdapter(Context context, ArrayList<HashMap<String, String>> list) {
            mapsList = list;
            this.mcontext = context;
        }

        @Override
        public VideoRecyleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_list_item, null);
            VideoRecyleHolder rcv = new VideoRecyleHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(VideoRecyleHolder holder, int position) {
            maps = mapsList.get(position);

            // holder.sponsorPhoto.setImageResource(maps.get(position).getPhoto());
            holder.videoPhoto.setOnClickListener(clickListener);
            // Picasso.with(mcontext).load(maps.get("sponsorUrl")).into(holder.videoPhoto);
            String videoUrl = maps.get("videoUrl");
            try {
                Bitmap thumb = retriveVideoFrameFromVideo(videoUrl);
                holder.videoPhoto.setImageBitmap(thumb);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            holder.videoPhoto.setTag(holder);

        }

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoRecyleHolder vHoder = (VideoRecyleHolder) v.getTag();
                int position = vHoder.getPosition();
                System.out.println("position id" + maps.get("sponsorId"));
                HashMap<String, String> resMap = mapsList.get(position);
                Intent videoPlay = new Intent(VideosActivity.this, VideoPlayerActivity.class);
                videoPlay.putExtra("videoUrl", resMap.get("videoUrl"));
                videoPlay.putExtra("fileName", resMap.get("fileName"));
                startActivity(videoPlay);
            }
        };

        @Override
        public int getItemCount() {
            return this.mapsList.size();
        }

        public Bitmap retriveVideoFrameFromVideo(String videoPath)
                throws Throwable {

            Bitmap bitmap = null;
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                if (Build.VERSION.SDK_INT >= 14)
                    mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
                else
                    mediaMetadataRetriever.setDataSource(videoPath);
                //   mediaMetadataRetriever.setDataSource(videoPath);
                bitmap = mediaMetadataRetriever.getFrameAtTime();
            } catch (Exception e) {
                e.printStackTrace();
                throw new Throwable(
                        "Exception in retriveVideoFrameFromVideo(String videoPath)"
                                + e.getMessage());

            } finally {
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
            }
            return bitmap;
        }

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
                    String fileNameSeg[] = fileName.split("-");

                    fName = eventName + "-" + partName + "-" + fileNameSeg[1] + "-" + new SimpleDateFormat("HHmmss",
                            Locale.getDefault()).format(new Date());
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
                    String fileNameSegments[] = vidPath.split("/");
                    fileName = fileNameSegments[fileNameSegments.length - 1];
                    //String fileNameSeg[] = fileName.split("-");

                    fName = eventName + "-" + partName + "-" + fileName + "-" + new SimpleDateFormat("HHmmss",
                            Locale.getDefault()).format(new Date());
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

            }


            @Override
            protected String doInBackground(Void... params) {

                if (fileTpe.equals("video")) {
                    FileInputStream is = null;
                    File originalFile = new File(vidPath);
                    String encodedBase64 = null;
                    try {
                        FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
                        byte[] bytes = new byte[(int) originalFile.length()];
                        fileInputStreamReader.read(bytes);
                        encodedString = new String(Base64.encodeBase64(bytes));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return "";
            }

            @Override
            protected void onPostExecute(String msg) {
                //prgDialog.setMessage("Calling Upload");
                // Put converted Image string into Async Http Post param
                prgDialog.dismiss();
                GalaryBean uploadImgVid = new GalaryBean();
                uploadImgVid.setName(fName);
                uploadImgVid.setEncodeString(encodedString);
                uploadImgVid.setFileName(fileName);
                uploadImgVid.setType(fileTpe);
                uploadImgVid.setEventId(Long.parseLong(eventId));
                if (Constants.isNetworkAvailable(VideosActivity.this)) {
                    new MyAsyncTask(Constants.UPLOAD_IMAGE_VIDEO, Utils.getJson(uploadImgVid), VideosActivity.this, new Callback() {
                        public void onResult(String result) {

                            Result res = Utils.getObject(result, Result.class);

                            if (res.getResult().equals("success")) {
                                Constants.createDialogSend(VideosActivity.this, "success", "Video upload successfully");
                            } else {
                                Constants.createDialogSend(VideosActivity.this, "fail", "Something went wrong please try again.");
                            }
                        }
                    }).execute();
                } else {
                    Constants.createDialogSend(VideosActivity.this, "error", "Please connect to internet");
                }
            }
        }.execute(null, null, null);
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //  VideosActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        finish();
    }


}
