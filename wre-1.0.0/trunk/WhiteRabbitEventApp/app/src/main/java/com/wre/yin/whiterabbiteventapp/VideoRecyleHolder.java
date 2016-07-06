package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by root on 6/7/16.
 */
public class VideoRecyleHolder extends RecyclerView.ViewHolder {


    public ImageView videoPhoto;

    public VideoRecyleHolder(View itemView) {
        super(itemView);
        videoPhoto = (ImageView) itemView.findViewById(R.id.video_list_item_imageview);
    }
}