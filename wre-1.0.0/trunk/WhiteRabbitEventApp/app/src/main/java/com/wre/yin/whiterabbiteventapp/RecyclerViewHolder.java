package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView partName, partPhone;
    ImageView partProfileImg;
    CardView cardView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        partName = (TextView) itemView.findViewById(R.id.part_list_name);
        partPhone = (TextView) itemView.findViewById(R.id.part_list_phone);
        partProfileImg = (ImageView) itemView.findViewById(R.id.part_list_profile_img);
        cardView = (CardView) itemView.findViewById(R.id.card_view);

    }
}
