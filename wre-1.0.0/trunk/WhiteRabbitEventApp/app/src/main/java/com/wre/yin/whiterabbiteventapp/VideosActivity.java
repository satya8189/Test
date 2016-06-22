package com.wre.yin.whiterabbiteventapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.adapters.CustomVideosGridAdaptor;
import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.beans.Result;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

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
    private CircleImageView camPick, gallPick;
    private Uri fileUri;
    private String vidPath, fileName, fileTpe, encodedString;
    //flag for which one is used for images selection
    private GridView _gallery;
    private Cursor _cursor;
    private int _columnIndex;
    private int[] _videosId;
    private Uri _contentUri;
    private String eventId;
    private List<HashMap<String, String>> mGridData;


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _context = getApplicationContext();
        setContentView(R.layout.activity_videos);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        eventId = getIntent().getExtras().getString("eventId");


        prgDialog = new ProgressDialog(this);
        prgDialog.setCancelable(false);

        _gallery = (GridView) findViewById(R.id.upload_video_grid);
        _contentUri = MEDIA_EXTERNAL_CONTENT_URI;

        initVideosId();
        setGalleryAdapter();

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
                List<GalaryBean> docBeanList= Utils.getList(result,GalaryBean.class);
                for(GalaryBean bean:docBeanList){
                    HashMap<String,String> map=new HashMap<String, String>();
                    map.put("fileName",bean.getName());
                    map.put("videoUrl",Constants.IMAGE_URL+eventId+"/video/"+bean.getFileName());
                    mGridData.add(map);
                }
                CustomVideosGridAdaptor  videosAdapter = new CustomVideosGridAdaptor(VideosActivity.this, R.layout.videos_row_grid, (ArrayList<HashMap<String, String>>) mGridData);
                _gallery.setAdapter(videosAdapter);

        _gallery.setAdapter(new VideoGalleryAdapter(_context, (ArrayList<HashMap<String, String>>) mGridData));
        _gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String,String> resMap=mGridData.get(i);
                Intent videoPlay=new Intent(VideosActivity.this,VideoPlayerActivity.class);
                videoPlay.putExtra("videoUrl",resMap.get("videoUrl"));
                videoPlay.putExtra("fileName",resMap.get("fileName"));
                startActivity(videoPlay);
            }
        });
            }
        }).execute();

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

            }

            ;

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
                GalaryBean uploadImgVid = new GalaryBean();
                uploadImgVid.setEncodeString(encodedString);
                uploadImgVid.setFileName(fileName);
                uploadImgVid.setType(fileTpe);
                uploadImgVid.setEventId(Long.parseLong(eventId));

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

    private class VideoGalleryAdapter extends BaseAdapter {
        LayoutInflater inflater;
        ArrayList<HashMap<String, String>> videoListThis;

        public VideoGalleryAdapter(Context c, ArrayList<HashMap<String, String>> videoList) {
            _context = c;
            videoListThis = videoList;
        }

        public int getCount() {
            return videoListThis.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {


            RelativeLayout relativeLayout = new RelativeLayout(_context);
            try {
                if (convertView != null) {
                    relativeLayout = (RelativeLayout) convertView;
                }

                ImageView imgVw = new ImageView(_context);
                HashMap<String, String> resultMap = videoListThis.get(position);
                String videoUrl = resultMap.get("videoUrl");
                Bitmap thumb = retriveVideoFrameFromVideo(videoUrl);
                imgVw.setImageBitmap(thumb);
                imgVw.setLayoutParams(new GridView.LayoutParams(196, 196));
                imgVw.setPadding(8, 8, 8, 8);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        196, 196);
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);
                imgVw.setLayoutParams(lp);

                RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                        66, 66);
                lp1.addRule(RelativeLayout.CENTER_IN_PARENT);
                ImageView imgVw1 = new ImageView(_context);
                imgVw1.setBackgroundResource(R.drawable.play);

                imgVw1.setLayoutParams(lp1);


                relativeLayout.addView(imgVw);
                relativeLayout.addView(imgVw1);


            } catch (Exception ex) {
                System.out.println("StartActivity:getView()-135: ex " + ex.getClass() + ", " + ex.getMessage());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return relativeLayout;

            /*ImageView imgVw= new ImageView(_context);
            try
            {
                if(convertView!=null)
                {
                    imgVw= (ImageView) convertView;
                }
                imgVw.setImageBitmap(getImage(_videosId[position]));
                imgVw.setLayoutParams(new GridView.LayoutParams(196, 196));
                //imgVw.setBackgroundResource(R.drawable.play_ico);

                imgVw.setForeground();
                imgVw.setPadding(8, 8, 8, 8);
            }
            catch(Exception ex)
            {
                System.out.println("StartActivity:getView()-135: ex " + ex.getClass() +", "+ ex.getMessage());
            }
            return imgVw;*/


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
}
