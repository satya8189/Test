package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AgendaRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView agendaTitle, agendaDesc, agendaTime;
    LinearLayout expandLayout, agendaLayout;
    CardView cardView;
    ImageView plus, minus;

    public AgendaRecyclerViewHolder(View itemView) {
        super(itemView);

        agendaTitle = (TextView) itemView.findViewById(R.id.list_title);
        agendaDesc = (TextView) itemView.findViewById(R.id.expanded_text);
        agendaTime = (TextView) itemView.findViewById(R.id.time_duration);
        plus = (ImageView) itemView.findViewById(R.id.plus_img);
        minus = (ImageView) itemView.findViewById(R.id.minus_img);

        expandLayout = (LinearLayout) itemView.findViewById(R.id.expanded_layout);

         agendaLayout = (LinearLayout) itemView.findViewById(R.id.agenda_re_layout);

        cardView = (CardView) itemView.findViewById(R.id.card_view);

    }
}
