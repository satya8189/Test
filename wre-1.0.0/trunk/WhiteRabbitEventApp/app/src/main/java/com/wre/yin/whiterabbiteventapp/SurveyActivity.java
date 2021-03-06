package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.beans.QuestionAnswer;
import com.wre.yin.whiterabbiteventapp.beans.QuestionBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {

    private TextView text;
    private RecyclerView recyclerView;
    private List<HashMap<String, String>> listQtns;
    private String partId, eventId;
    SharedPreferences prefs;
    List<QuestionAnswer> qAndA = new ArrayList<>();
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  SurveyActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_survey);
        String nameTxt = getIntent().getExtras().getString("name");

        listQtns = new ArrayList<HashMap<String, String>>();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        recyclerView = (RecyclerView) findViewById(R.id.survey_recycler_view);
        prefs = getSharedPreferences("Chat", 0);
        eventId = getIntent().getExtras().getString("eventId");
        partId = prefs.getString("partId", null);
        submitBtn = (Button) findViewById(R.id.survey_total_submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionBean questionBean = new QuestionBean();
                questionBean.setEventId(Long.parseLong(eventId));
                questionBean.setParticipantId(Long.parseLong(partId));
                questionBean.setqAList(qAndA);
                if (Constants.isNetworkAvailable(SurveyActivity.this)) {
                    new MyAsyncTask(Constants.QUESTIONS_ANSWER_SAVE, Utils.getJson(questionBean), SurveyActivity.this, new Callback() {
                        @Override
                        public void onResult(String result) {

                            if (result != null) {
                                if (result.equals("success"))
                                    Constants.createDialogSend(SurveyActivity.this, "success", "You are answers has been submitted successfully... Thank You");
                            }
                        }
                    }).execute();
                } else {
                    Constants.createDialogSend(SurveyActivity.this, "error", "Please connect to internet");
                }

            }
        });


        if (Constants.isNetworkAvailable(SurveyActivity.this)) {
            new MyAsyncTask(Constants.QUESTIONS_LIST + eventId, null, SurveyActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    if (result != null) {
                        List<QuestionBean> qustBean = Utils.getList(result, QuestionBean.class);
                        if (qustBean != null) {
                            for (QuestionBean bean : qustBean) {
                                HashMap<String, String> map1 = new HashMap<String, String>();
                                map1.put("qtn", bean.getQuestion());
                                map1.put("typ", bean.getAppIdentifierName());
                                map1.put("opt1", bean.getOptionA());
                                map1.put("opt2", bean.getOptionB());
                                map1.put("opt3", bean.getOptionC());
                                map1.put("opt4", bean.getOptionD());
                                map1.put("qtnId", bean.getQuestionId().toString());
                                listQtns.add(map1);
                            }
                        }
                        RecylerAdapter adapter = new RecylerAdapter(SurveyActivity.this, (ArrayList<HashMap<String, String>>) listQtns);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(SurveyActivity.this));

                    }
                }
            }).execute();
        } else {
            Constants.createDialogSend(SurveyActivity.this, "error", "Please connect to internet");
        }

        // text.setText(nameTxt);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //  SurveyActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }

    private class RecylerAdapter extends RecyclerView.Adapter<SurveyViewHolder> {
        LayoutInflater inflater;
        Context context;
        ArrayList<HashMap<String, String>> qtnAList;
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = null;
                SurveyViewHolder vholder = (SurveyViewHolder) v.getTag();
                int position = vholder.getPosition();
                HashMap<String, String> map1 = qtnAList.get(position);
                if (map1.get("typ").equals("Single Choice")) {

                    answer = vholder.ans.getText().toString();
                    if (answer.equals("")) {
                        Toast.makeText(context, "Please give a answer.. ", Toast.LENGTH_LONG).show();
                    } else {
                        /**/
                        QuestionAnswer qa = new QuestionAnswer();
                        qa.setqId(Long.parseLong(map1.get("qtnId")));
                        qa.setAnswer(answer);
                        qAndA.add(qa);
                        Toast.makeText(context,"Save",Toast.LENGTH_LONG).show();
                    }
                } else {
                    int index = vholder.rdGrp.getCheckedRadioButtonId();
                    RadioButton rdBtn = (RadioButton) findViewById(index);
                    int idx = vholder.rdGrp.indexOfChild(rdBtn);

                    if (vholder.opt1.isChecked()) {
                        answer = vholder.opt1.getText().toString();
                    } else if (vholder.opt2.isChecked()) {
                        answer = vholder.opt2.getText().toString();
                    } else if (vholder.opt3.isChecked()) {
                        answer = vholder.opt3.getText().toString();
                    } else if (vholder.opt4.isChecked()) {
                        answer = vholder.opt4.getText().toString();
                    }
                    /*QuestionBean questionBean = new QuestionBean();
                    questionBean.setEventId(Long.parseLong(eventId));
                    questionBean.setParticipantId(Long.parseLong(partId));
                    questionBean.setQuestionId(Long.parseLong(map1.get("qtnId")));
                    questionBean.setAnswer(answer);
                    new MyAsyncTask(Constants.QUESTIONS_ANSWER_SAVE, Utils.getJson(questionBean), SurveyActivity.this, new Callback() {
                        @Override
                        public void onResult(String result) {
                            System.out.println("Result in radio:" + result);
                        }
                    }).execute();*/
                    QuestionAnswer qa = new QuestionAnswer();
                    qa.setqId(Long.parseLong(map1.get("qtnId")));
                    qa.setAnswer(answer);
                    qAndA.add(qa);
                    Toast.makeText(context,"Save",Toast.LENGTH_LONG).show();
                }

            }
        };

        public RecylerAdapter(Context context, ArrayList<HashMap<String, String>> qtnList) {
            this.context = context;
            this.qtnAList = qtnList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public SurveyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.survey_item, parent, false);
            SurveyViewHolder viewHolder = new SurveyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(SurveyViewHolder holder, int position) {
            HashMap<String, String> map = qtnAList.get(position);
            holder.question.setText(map.get("qtn"));
            if (map.get("typ").equals("Single Choice")) {
                holder.ans.setVisibility(View.VISIBLE);
                holder.rdGrp.setVisibility(View.GONE);
            } else {
                holder.rdGrp.setVisibility(View.VISIBLE);
                holder.ans.setVisibility(View.GONE);
                holder.opt1.setText(map.get("opt1"));
                holder.opt2.setText(map.get("opt2"));
                if (map.get("opt3") == null) {
                    holder.opt3.setVisibility(View.GONE);
                } else {
                    holder.opt3.setText(map.get("opt3"));
                }
                if (map.get("opt4") == null) {
                    holder.opt4.setVisibility(View.GONE);
                } else {
                    holder.opt4.setText(map.get("opt4"));
                }

            }
            holder.submitBtn.setOnClickListener(clickListener);
            holder.submitBtn.setTag(holder);
        }

        @Override
        public int getItemCount() {
            return qtnAList.size();
        }
    }
}
