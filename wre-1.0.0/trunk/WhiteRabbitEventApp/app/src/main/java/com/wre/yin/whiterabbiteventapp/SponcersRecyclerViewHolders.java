package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by YINSOL on 6/2/2016.
 */
public class SponcersRecyclerViewHolders extends RecyclerView.ViewHolder {


    public TextView sponsorName;
    public ImageView sponsorPhoto;

    public SponcersRecyclerViewHolders(View itemView) {
        super(itemView);
        sponsorName = (TextView) itemView.findViewById(R.id.sponsor_name);
        sponsorPhoto = (ImageView) itemView.findViewById(R.id.sponsor_photo);
    }
}
