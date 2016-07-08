package com.wre.yin.whiterabbiteventapp.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.wre.yin.whiterabbiteventapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 20/6/16.
 */
public class CustomVideosGridAdaptor extends ArrayAdapter<HashMap<String, String>> {
    Context context;
    int layoutResourceId;
    ArrayList<HashMap<String, String>> data1 = new ArrayList<HashMap<String, String>>();

    public CustomVideosGridAdaptor(Context context, int layoutResourceId,
                                   ArrayList<HashMap<String, String>> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data1 = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();

            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        HashMap<String, String> resultMap = data1.get(position);
        String videoUrl = resultMap.get("videoUrl");
        Bitmap thumb = null;
        try {
            thumb = retriveVideoFrameFromVideo(videoUrl);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        holder.imageItem.setImageBitmap(thumb);

        //holder.txtTitle.setText(item.getTitle());

        /*int idIndex=item.getId();
        TypedArray img;
        img=context.getResources().obtainTypedArray(R.array.services);
        holder.imageItem.setImageResource(img.getResourceId(idIndex-1,1));*/
        return row;

    }

    static class RecordHolder {

        ImageView imageItem;

    }

    public Bitmap retriveVideoFrameFromVideo(String videoPath)
            throws Throwable {
        ProgressDialog dialog = ProgressDialog.show(context, "", "", true);
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
        dialog.dismiss();
        return bitmap;
    }
}
