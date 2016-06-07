package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView newsTitle, dateTime, newsDesc;
    LinearLayout expandLayout, newsLayout;
    CardView cardView;
    ImageView plus, minus;

    public NewsRecyclerViewHolder(View itemView) {
        super(itemView);

        newsTitle = (TextView) itemView.findViewById(R.id.news_title);
        dateTime = (TextView) itemView.findViewById(R.id.date_time);
        newsDesc = (TextView) itemView.findViewById(R.id.news_desc);
        plus = (ImageView) itemView.findViewById(R.id.plus_img);
        minus = (ImageView) itemView.findViewById(R.id.minus_img);

        expandLayout = (LinearLayout) itemView.findViewById(R.id.expanded_layout);

        newsLayout = (LinearLayout) itemView.findViewById(R.id.news_re_layout);

        cardView = (CardView) itemView.findViewById(R.id.card_view);

    }
}
