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
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.ParticipantEventBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NetworkingActivity extends AppCompatActivity {
    private TextView text;
    private RecyclerView recyclerView;
    private String eventId;
    private SharedPreferences prefs;

    private List<HashMap<String, String>> partList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);

        String nameTxt = getIntent().getExtras().getString("name");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        eventId = getIntent().getExtras().getString("eventId");

        partList = new ArrayList<>();
        new MyAsyncTask(Constants.PARTICIPANT_LIST + "?eventId=" + eventId + "&status=ACTIVE", null, NetworkingActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                List<ParticipantEventBean> participantEventBeanList = Utils.getList(result, ParticipantEventBean.class);
                for (ParticipantEventBean bean : participantEventBeanList) {
                    HashMap<String, String> partMap = new HashMap<String, String>();
                    partMap.put("partId", bean.getParticipantId().toString());
                    partMap.put("partName", bean.getFirstName() + " " + bean.getLastName());
                    partMap.put("partPhone", bean.getMobile());
                    partList.add(partMap);

                }
                RecylerAdapter adapter = new RecylerAdapter(NetworkingActivity.this, (ArrayList<HashMap<String, String>>) partList);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(NetworkingActivity.this));
            }
        }).execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //   NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class RecylerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        LayoutInflater inflater;
        Context context;
        ArrayList<HashMap<String, String>> partAdList;


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
                int position = vholder.getPosition();

            }
        };

        public RecylerAdapter(Context context, ArrayList<HashMap<String, String>> partArList) {
            this.context = context;
            this.partAdList = partArList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.network_list_item, parent, false);
            RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            HashMap<String, String> partAdMap = partAdList.get(position);
            holder.partName.setText(partAdMap.get("partName"));
            holder.partPhone.setText(partAdMap.get("partPhone"));
            holder.cardView.setOnClickListener(clickListener);
            Picasso.with(context).load("http://183.82.103.156:8080/Resources/wre/profile_pics/"+partAdMap.get("partId")+"/profile.jpg").placeholder(R.drawable.user_icon).into(holder.partProfileImg);
            holder.cardView.setTag(holder);
        }

        @Override
        public int getItemCount() {
            return partAdList.size();
        }
    }
}
