package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wre.yin.whiterabbiteventapp.beans.ChatTopicBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DiscoTopics extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String eventId;
    private SharedPreferences prefs;

    private List<String> topicsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco_topics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Topics");

        recyclerView = (RecyclerView) findViewById(R.id.chat_topics_recycler_view);
        eventId = getIntent().getExtras().getString("eventId");

        topicsList=new ArrayList<>();

        new MyAsyncTask(Constants.CHAT_TOPICS_LIST + eventId, null, DiscoTopics.this, new Callback() {
            @Override
            public void onResult(String result) {
                List<ChatTopicBean> list= Utils.getList(result,ChatTopicBean.class);
                for(ChatTopicBean bean:list){
                  topicsList.add(bean.getChatTopicName());
                }
                RecylerAdapter adapter = new RecylerAdapter(DiscoTopics.this, (ArrayList<String>) topicsList);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(DiscoTopics.this));



            }
        }).execute();
    }

    private class RecylerAdapter extends RecyclerView.Adapter<RecyclerViewHolderChatTopics> {
        LayoutInflater inflater;
        Context context;
        ArrayList<String> topicList;


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecyclerViewHolderChatTopics vholder = (RecyclerViewHolderChatTopics) v.getTag();
                int position = vholder.getPosition();
                String topic=topicList.get(position);
                Intent messageAct = new Intent(DiscoTopics.this, MessageActivity.class);
                messageAct.putExtra("name", topic);
                messageAct.putExtra("eventId", eventId);
                startActivity(messageAct);

            }
        };

        public RecylerAdapter(Context context, ArrayList<String> partArList) {
            this.context = context;
            this.topicList = partArList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerViewHolderChatTopics onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.chat_topics_list_item, parent, false);
            RecyclerViewHolderChatTopics viewHolder = new RecyclerViewHolderChatTopics(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderChatTopics holder, int position) {
            String topic= topicList.get(position);
            holder.partName.setText(topic);
            holder.cardView.setOnClickListener(clickListener);
           // Picasso.with(context).load("http://183.82.103.156:8080/Resources/wre/profile_pics/"+partAdMap.get("partId")+"/profile.jpg").placeholder(R.drawable.user_icon).into(holder.partProfileImg);
            holder.cardView.setTag(holder);
        }

        @Override
        public int getItemCount() {
            return topicList.size();
        }
    }
}
