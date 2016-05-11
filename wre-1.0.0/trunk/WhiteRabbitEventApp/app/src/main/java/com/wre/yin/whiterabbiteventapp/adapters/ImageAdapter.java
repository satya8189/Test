package com.wre.yin.whiterabbiteventapp.adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by YINSOL on 5/11/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private int columnIndex;
    private Cursor cursor;


    public ImageAdapter(Context localContext) {
        context = localContext;
    }

    public int getCount() {
        if(cursor==null)
            return 0;
        return cursor.getCount();    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView picturesView;
        if (convertView == null) {
            picturesView = new ImageView(context);
            // Move cursor to current position
            cursor.moveToPosition(position);
            // Get the current value for the requested column
            int imageID = cursor.getInt(columnIndex);
            // Set the content of the image based on the provided URI
            picturesView.setImageURI(Uri.withAppendedPath(
                    MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "" + imageID));
            picturesView.setScaleType(ImageView.ScaleType.FIT_XY);
            picturesView.setPadding(10, 10, 10, 10);
            picturesView.setLayoutParams(new GridView.LayoutParams(100, 100));
        } else {
            picturesView = (ImageView) convertView;
        }
        return picturesView;
    }
}

