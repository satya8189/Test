package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.wre.yin.whiterabbiteventapp.beans.SponsorBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SponcersActivity extends AppCompatActivity {

    private static final String TAG = SponcersActivity.class.getName();
    private TextView text;
    private SharedPreferences prefs;
    private GridLayoutManager gridLayout;
    private String eventId;
    private RecyclerViewAdapter rcAdapter;
    private List<HashMap<String, String>> sponsorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SponcersActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_sponcers);

        String nameTxt = getIntent().getExtras().getString("name");
        eventId = getIntent().getExtras().getString("eventId");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        prefs = getSharedPreferences("Chat", 0);

        gridLayout = new GridLayoutManager(SponcersActivity.this, 2);

        rView = (RecyclerView) findViewById(R.id.sponsors_grid_recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayout);

        ItemTouchHelper ith = new ItemTouchHelper(_ithCallback);
        ith.attachToRecyclerView(rView);
        if (Constants.isNetworkAvailable(SponcersActivity.this)) {
            new MyAsyncTask(Constants.SPONSORS_LIST + "?eventId=" + eventId, null, SponcersActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    if (result != null)
                        sponsorList = new ArrayList<HashMap<String, String>>();
                    List<SponsorBean> sponsorBeanList = Utils.getList(result, SponsorBean.class);

                    for (SponsorBean bean : sponsorBeanList) {
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("sponsorName", bean.getSponcorName());
                        map.put("sponsorId", bean.getSponcorId().toString());
                        map.put("sponsorUrl", Constants.IMAGE_URL + eventId + "/sponsor/" + bean.getFileName());

                        sponsorList.add(map);

                    }
                    rcAdapter = new RecyclerViewAdapter(SponcersActivity.this, (ArrayList<HashMap<String, String>>) sponsorList);

                    rView.setAdapter(rcAdapter);
                }
            }).execute();
        } else {
            Constants.createDialogSend(SponcersActivity.this, "error", "Please connect to internet");
        }

    }
    ItemTouchHelper.Callback _ithCallback = new ItemTouchHelper.Callback() {

        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            // get the viewHolder's and target's positions in your adapter data, swap them
            Collections.swap(sponsorList, viewHolder.getAdapterPosition(), target.getAdapterPosition());
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
    private RecyclerView rView;
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
        SponcersActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<SponcersRecyclerViewHolders> {

        List<HashMap<String, String>> mapsList;
        HashMap<String, String> maps;
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SponcersRecyclerViewHolders vHoder = (SponcersRecyclerViewHolders) v.getTag();
                int position = vHoder.getPosition();
                System.out.println("position id" + maps.get("sponsorId"));
                HashMap<String, String> maps1 = mapsList.get(position);
                Intent i = new Intent(SponcersActivity.this, SponcersProfileActivity.class);
                i.putExtra("sponsorId", maps1.get("sponsorId"));
                i.putExtra("sponsorName", maps1.get("sponsorName"));
                i.putExtra("sponsorUrl", maps1.get("sponsorUrl"));
                startActivity(i);
            }
        };
        private Context context;

        public RecyclerViewAdapter(Context context, ArrayList<HashMap<String, String>> list) {
            mapsList = list;
            this.context = context;
        }

        @Override
        public SponcersRecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sponsor_card_view_list, null);
            SponcersRecyclerViewHolders rcv = new SponcersRecyclerViewHolders(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(SponcersRecyclerViewHolders holder, int position) {
            maps = mapsList.get(position);

            holder.sponsorName.setText(maps.get("sponsorName"));
            // holder.sponsorPhoto.setImageResource(maps.get(position).getPhoto());
            holder.sponsorPhoto.setOnClickListener(clickListener);
            Picasso.with(context).load(maps.get("sponsorUrl")).into(holder.sponsorPhoto);
            holder.sponsorPhoto.setTag(holder);
        }

        @Override
        public int getItemCount() {
            return this.mapsList.size();
        }
    }
}
