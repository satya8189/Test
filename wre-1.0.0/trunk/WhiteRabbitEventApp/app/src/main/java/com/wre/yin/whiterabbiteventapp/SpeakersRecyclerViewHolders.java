package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by YINSOL on 6/2/2016.
 */
public class SpeakersRecyclerViewHolders extends RecyclerView.ViewHolder {


    public TextView speakerName;
    public ImageView speakerPhoto;

    public SpeakersRecyclerViewHolders(View itemView) {
        super(itemView);
        speakerName = (TextView) itemView.findViewById(R.id.sponsor_name);
        speakerPhoto = (ImageView) itemView.findViewById(R.id.sponsor_photo);
    }
}
