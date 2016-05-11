package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.gridlibrary.DynamicGridView;

public class GalleryActivity extends AppCompatActivity {

    private TextView text;
    private DynamicGridView imageGridView;
    private static final String TAG = GalleryActivity.class.getName();


    //  Cursor used to access the results from querying for images on the SD card.

    private Cursor cursor;

    // Column index for the Thumbnails Image IDs.

    private int columnIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String nameTxt = getIntent().getExtras().getString("name");
        // text = (TextView) findViewById(R.id.activity_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);


        //Searching Images ID's from Gallery. _ID is the Default id code for all. You can retrive image,contacts,music id in the same way.
        String[] list = {MediaStore.Images.Media._ID};

        //Retriving Images from Database(SD CARD) by Cursor.
        cursor = getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, list, null, null, MediaStore.Images.Thumbnails._ID);
        columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);

        imageGridView = (DynamicGridView) findViewById(R.id.image_grid);
        ImageAdapter adapter = new ImageAdapter(this);
        imageGridView.setAdapter(adapter);

        imageGridView.setOnDragListener(new DynamicGridView.OnDragListener() {
            @Override
            public void onDragStarted(int position) {
                Log.d(TAG, "drag started at position " + position);
            }

            @Override
            public void onDragPositionsChanged(int oldPosition, int newPosition) {
                Log.d(TAG, String.format("drag item position changed from %d to %d", oldPosition, newPosition));
            }
        });
        imageGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                imageGridView.startEditMode(position);
                return true;
            }
        });
      /*  imageGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GalleryActivity.this, parent.getAdapter().getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();
                Intent i=new Intent(GalleryActivity.this,ProfileDetailsActivity.class);
                i.putExtra("speakerName",parent.getAdapter().getItem(position).toString());
                startActivity(i);

            }
        });*/

    }

    public class ImageAdapter extends BaseAdapter {

        private Context context;

        public ImageAdapter(Context localContext) {

            context = localContext;

        }

        public int getCount() {

            return cursor.getCount();

        }

        public Object getItem(int position) {

            return position;

        }

        public long getItemId(int position) {

            return position;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = new ViewHolder();


            if (convertView == null) {
                holder.picturesView = new ImageView(context);
                //Converting the Row Layout to be used in Grid View
                convertView = getLayoutInflater().inflate(R.layout.row, parent, false);

                //You can convert Layout in this Way with the Help of View Stub. View Stub is newer. Read about ViewStub.Inflate
                // and its parameter.
                //convertView= ViewStub.inflate(context,R.layout.row,null);

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            cursor.moveToPosition(position);
            int imageID = cursor.getInt(columnIndex);

            //In Uri "" + imageID is to convert int into String as it only take String Parameter and imageID is in Integer format.
            //You can use String.valueOf(imageID) instead.
            Uri uri = Uri.withAppendedPath(
                    MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "" + imageID);

            //Setting Image to View Holder Image View.
            holder.picturesView = (ImageView) convertView.findViewById(R.id.imageview);
            holder.picturesView.setImageURI(uri);
            holder.picturesView.setScaleType(ImageView.ScaleType.CENTER_CROP);


            return convertView;

        }

        // View Holder pattern used for Smooth Scrolling. As View Holder pattern recycle the findViewById() object.
        class ViewHolder {
            private ImageView picturesView;
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
