package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.adapters.ExpandableListAdapter;
import com.wre.yin.whiterabbiteventapp.beans.AgendaBean;
import com.wre.yin.whiterabbiteventapp.beans.NewsFeedBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class NewsFeedActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    String layoutStatus = "gone";
    private List<HashMap<String, String>> newsList;
    Format formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        String nameTxt = getIntent().getExtras().getString("name");
        formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);


        recyclerView = (RecyclerView) findViewById(R.id.newsfeed_recycler_view);

        new MyAsyncTask(Constants.NEWS_LIST + "?eventId=9", null, NewsFeedActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                newsList = new ArrayList<HashMap<String, String>>();
                List<NewsFeedBean> newsBeanList = Utils.getList(result, NewsFeedBean.class);

                for (NewsFeedBean bean : newsBeanList) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("newsTitle", bean.getNewsTitle());
                    map.put("newsDesc", bean.getNewsDesc());



                    String newsDate = formatter.format(bean.getNewsDate());
                    map.put("newsDate", newsDate);


                    newsList.add(map);

                }
                RecyclerAdapter adapter = new RecyclerAdapter(NewsFeedActivity.this, (ArrayList<HashMap<String, String>>) newsList);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(NewsFeedActivity.this));
            }
        }).execute();
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerViewHolder> {
        LayoutInflater inflater;
        Context context;
        List<HashMap<String, String>> mapsList;
        HashMap<String, String> maps;

        public RecyclerAdapter(Context context, ArrayList<HashMap<String, String>> list) {
            this.context = context;
            mapsList = list;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public NewsRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.news_list_item, parent, false);
            NewsRecyclerViewHolder viewHolder = new NewsRecyclerViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(NewsRecyclerViewHolder holder, int position) {

            int[] androidColors = getResources().getIntArray(R.array.rainbow);
            int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];

            maps = mapsList.get(position);

            holder.agendaLayout.setBackgroundColor(randomAndroidColor);

            holder.newsTitle.setText(maps.get("newsTitle"));
            holder.dateTime.setText(maps.get("newsDate"));
            holder.newsDesc.setText(maps.get("newsDesc"));

            holder.cardView.setOnClickListener(clickListener);
            holder.cardView.setTag(holder);
        }

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewsRecyclerViewHolder vholder = (NewsRecyclerViewHolder) v.getTag();
                int position = vholder.getPosition();
                if (layoutStatus.equals("gone")) {
                    vholder.expandLayout.setVisibility(View.VISIBLE);
                    vholder.plus.setVisibility(View.GONE);
                    vholder.minus.setVisibility(View.VISIBLE);
                    layoutStatus = "visible";
                } else {
                    vholder.expandLayout.setVisibility(View.GONE);
                    vholder.plus.setVisibility(View.VISIBLE);
                    vholder.minus.setVisibility(View.GONE);
                    layoutStatus = "gone";
                }

            }
        };

        @Override
        public int getItemCount() {
            return mapsList.size();
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
