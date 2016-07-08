package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.utils.ResizableImageView;

/**
 * Created by root on 6/7/16.
 */
public class GallaryRecyleHolder extends RecyclerView.ViewHolder {


    TextView likeCount;
    ResizableImageView imageView;
    ImageView likeImage;

    public GallaryRecyleHolder(View itemView) {
        super(itemView);
        imageView = (ResizableImageView) itemView.findViewById(R.id.grid_item_image);
        likeCount = (TextView) itemView.findViewById(R.id.gall_like_count);
        likeImage = (ImageView) itemView.findViewById(R.id.gall_like_heart);
    }
}