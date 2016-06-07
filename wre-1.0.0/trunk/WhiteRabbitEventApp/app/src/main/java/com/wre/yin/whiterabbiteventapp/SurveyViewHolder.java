package com.wre.yin.whiterabbiteventapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by YINSOL on 5/25/2016.
 */
public class SurveyViewHolder extends RecyclerView.ViewHolder {

    TextView question;
    EditText ans;
    RadioGroup rdGrp;
    RadioButton opt1, opt2, opt3, opt4;
    Button submitBtn;
    CardView cardView;

    public SurveyViewHolder(View itemView) {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.survey_qtn);
        ans = (EditText) itemView.findViewById(R.id.survey_edit_text);
        rdGrp = (RadioGroup) itemView.findViewById(R.id.sur_radio_grp);
        opt1 = (RadioButton) itemView.findViewById(R.id.sur_radio1);
        opt2 = (RadioButton) itemView.findViewById(R.id.sur_radio2);
        opt3 = (RadioButton) itemView.findViewById(R.id.sur_radio3);
        opt4 = (RadioButton) itemView.findViewById(R.id.sur_radio4);
        submitBtn = (Button) itemView.findViewById(R.id.survey_submit_btn);
        cardView = (CardView) itemView.findViewById(R.id.survey_card_view);

    }
}
