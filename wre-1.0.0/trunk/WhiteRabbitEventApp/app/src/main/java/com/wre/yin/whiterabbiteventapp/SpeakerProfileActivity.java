package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.SpeakerBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SpeakerProfileActivity extends AppCompatActivity {

    private static final String TAG = SpeakerProfileActivity.class.getName();
    private TextView text;
    private GridLayoutManager gridLayout;
    private RecyclerViewAdapter rcAdapter;
    private List<HashMap<String, String>> speakersList;
    private RecyclerView rView;
    private String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // SpeakerProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_speaker_profile);

        String nameTxt = getIntent().getExtras().getString("name");
        eventId = getIntent().getExtras().getString("eventId");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        gridLayout = new GridLayoutManager(SpeakerProfileActivity.this, 2);


        rView = (RecyclerView) findViewById(R.id.speakers_grid_recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayout);

        ItemTouchHelper ith = new ItemTouchHelper(_ithCallback);
        ith.attachToRecyclerView(rView);
        if (Constants.isNetworkAvailable(SpeakerProfileActivity.this)) {
            new MyAsyncTask(Constants.SPEAKERS_LIST + "?eventId=" + eventId, null, SpeakerProfileActivity.this, new Callback() {
                @Override
                public void onResult(String result) {

                    speakersList = new ArrayList<HashMap<String, String>>();
                    List<SpeakerBean> speakerBeenList = Utils.getList(result, SpeakerBean.class);
                    if (speakerBeenList != null) {
                        for (SpeakerBean bean : speakerBeenList) {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("speakersName", bean.getSpeakerName());
                            map.put("speakerId", bean.getSpeakerId().toString());
                            map.put("speakerUrl", Constants.IMAGE_URL + eventId + "/speaker/" + bean.getFileName());

                            speakersList.add(map);

                        }
                        rcAdapter = new RecyclerViewAdapter(SpeakerProfileActivity.this, (ArrayList<HashMap<String, String>>) speakersList);

                        rView.setAdapter(rcAdapter);
                    }
                }
            }).execute();
        } else {
            Constants.createDialogSend(SpeakerProfileActivity.this, "error", "Please connect to internet");
        }
    }

    ItemTouchHelper.Callback _ithCallback = new ItemTouchHelper.Callback() {
        //and in your imlpementaion of
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            // get the viewHolder's and target's positions in your adapter data, swap them
            Collections.swap(speakersList, viewHolder.getAdapterPosition(), target.getAdapterPosition());
            // and notify the adapter that its dataset has changed
            rcAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            //TODO
        }

        //defines the enabled move directions in each state (idle, swiping, dragging).
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
        }
    };

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
        //   SpeakerProfileActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<SpeakersRecyclerViewHolders> {

        List<HashMap<String, String>> mapsList;
        HashMap<String, String> maps;
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Constants.isNetworkAvailable(SpeakerProfileActivity.this)) {
                    SpeakersRecyclerViewHolders vHoder = (SpeakersRecyclerViewHolders) v.getTag();
                    int position = vHoder.getPosition();
                    HashMap<String, String> map1 = mapsList.get(position);
                    Intent i = new Intent(SpeakerProfileActivity.this, SpeakersProfileDetailsActivity.class);
                    i.putExtra("speakerId", map1.get("speakerId"));
                    i.putExtra("speakerName", map1.get("speakersName"));
                    i.putExtra("speakerUrl", map1.get("speakerUrl"));
                    i.putExtra("eventId", eventId);
                    startActivity(i);
                } else {
                    Constants.createDialogSend(SpeakerProfileActivity.this, "error", "Please connect to internet");
                }
            }
        };
        private Context context;


        public RecyclerViewAdapter(Context context, ArrayList<HashMap<String, String>> list) {
            mapsList = list;
            this.context = context;
        }

        @Override
        public SpeakersRecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sponsor_card_view_list, null);
            SpeakersRecyclerViewHolders rcv = new SpeakersRecyclerViewHolders(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(SpeakersRecyclerViewHolders holder, int position) {
            maps = mapsList.get(position);
            holder.speakerName.setText(maps.get("speakersName"));
            // holder.speakerPhoto.setImageResource(maps.get(position).getPhoto());
            holder.speakerPhoto.setOnClickListener(clickListener);
            Picasso.with(context).load(maps.get("speakerUrl")).into(holder.speakerPhoto);
            holder.speakerPhoto.setTag(holder);
        }

        @Override
        public int getItemCount() {
            return this.mapsList.size();
        }
    }
}
