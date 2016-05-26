package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {

    private TextView text;
    private RecyclerView recyclerView;
    private List<HashMap<String,String>> listQtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        String nameTxt = getIntent().getExtras().getString("name");
      //  text = (TextView) findViewById(R.id.activity_text);

        listQtns=new ArrayList<HashMap<String, String>>();

        HashMap<String,String> map1=new HashMap<String,String>();
        map1.put("qtn","How was seminar ?");
        map1.put("typ","text");
        map1.put("opt1",null);
        map1.put("opt2",null);
        map1.put("opt3",null);
        map1.put("opt4",null);
        listQtns.add(map1);

        HashMap<String,String> map2=new HashMap<String,String>();
        map2.put("qtn","How you rate event ?");
        map2.put("typ","radio");
        map2.put("opt1","True");
        map2.put("opt2","False");
        map2.put("opt3","Not intrested");
        map2.put("opt4","other");
        listQtns.add(map2);
        HashMap<String,String> map3=new HashMap<String,String>();
        map3.put("qtn","How you rate event ?");
        map3.put("typ","radio");
        map3.put("opt1","10%");
        map3.put("opt2","20%");
        map3.put("opt3","30%");
        map3.put("opt4","40%");
        listQtns.add(map3);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
        recyclerView= (RecyclerView) findViewById(R.id.survey_recycler_view);

        RecylerAdapter adapter=new RecylerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // text.setText(nameTxt);

    }
    private class RecylerAdapter extends RecyclerView.Adapter<SurveyViewHolder> {
        LayoutInflater inflater;
        Context context;
        /*String [] name={"Androidwarriors","Stackoverflow","Developer Android","AndroidHive",
                "Slidenerd","TheNewBoston","Truiton","HmkCode","JavaTpoint","Javapeper"};*/
        public RecylerAdapter(Context context) {
            this.context=context;
            inflater=LayoutInflater.from(context);
        }
        @Override
        public SurveyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=inflater.inflate(R.layout.survey_item,parent,false);
            SurveyViewHolder viewHolder=new SurveyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(SurveyViewHolder holder, int position) {
            HashMap<String,String> map=listQtns.get(position);
            holder.question.setText(map.get("qtn"));
            if(map.get("typ").equals("text")){
                holder.ans.setVisibility(View.VISIBLE);
                holder.rdGrp.setVisibility(View.GONE);
            }else {
                holder.rdGrp.setVisibility(View.VISIBLE);
                holder.ans.setVisibility(View.GONE);
                holder.opt1.setText(map.get("opt1"));
                holder.opt2.setText(map.get("opt2"));
                holder.opt3.setText(map.get("opt3"));
                holder.opt4.setText(map.get("opt4"));
            }
            holder.submitBtn.setOnClickListener(clickListener);
            holder.submitBtn.setTag(holder);
        }
        View.OnClickListener clickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
                int position = vholder.getPosition();
                Toast.makeText(context,"This is position "+position,Toast.LENGTH_LONG ).show();

            }
        };

        @Override
        public int getItemCount() {
            return listQtns.size();
        }
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
}
