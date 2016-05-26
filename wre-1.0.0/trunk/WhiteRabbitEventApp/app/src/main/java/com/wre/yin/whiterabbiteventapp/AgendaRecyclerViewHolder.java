package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AgendaRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1, tv2, tv3;
    LinearLayout expandLayout,agendaLayout;
    CardView cardView;
    ImageView plus,minus;

    public AgendaRecyclerViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.list_title);
        tv2 = (TextView) itemView.findViewById(R.id.list_desc);
        tv3 = (TextView) itemView.findViewById(R.id.expanded_text);
        plus = (ImageView) itemView.findViewById(R.id.plus_img);
        minus = (ImageView) itemView.findViewById(R.id.minus_img);

        expandLayout = (LinearLayout) itemView.findViewById(R.id.expanded_layout);

        agendaLayout = (LinearLayout) itemView.findViewById(R.id.agenda_re_layout);

        cardView = (CardView) itemView.findViewById(R.id.card_view);

    }
}
