package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolderChatTopics extends RecyclerView.ViewHolder {

    TextView partName;
    ImageView partProfileImg;
    CardView cardView;

    public RecyclerViewHolderChatTopics(View itemView) {
        super(itemView);

        partName = (TextView) itemView.findViewById(R.id.chat_topic_list_name);

        partProfileImg = (ImageView) itemView.findViewById(R.id.chat_topic_list_profile_img);
        cardView = (CardView) itemView.findViewById(R.id.chat_topic_card_view);

    }
}
