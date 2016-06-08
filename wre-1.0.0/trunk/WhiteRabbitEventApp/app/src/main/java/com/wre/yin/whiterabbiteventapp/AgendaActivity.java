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

import com.wre.yin.whiterabbiteventapp.beans.AgendaBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class AgendaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    String layoutStatus = "gone";

    private List<HashMap<String, String>> agendaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        String nameTxt = getIntent().getExtras().getString("name");
        String eventId = getIntent().getExtras().getString("eventId");
        // text = (TextView) findViewById(R.id.activity_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        recyclerView = (RecyclerView) findViewById(R.id.agenda_recycler_view);

        new MyAsyncTask(Constants.AGENDA + "?eventId=" + eventId, null, AgendaActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                agendaList = new ArrayList<HashMap<String, String>>();
                List<AgendaBean> agendaBeanList = Utils.getList(result, AgendaBean.class);

                for (AgendaBean bean : agendaBeanList) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("agenTitle", bean.getAgenTitle());
                    map.put("agenDesc", bean.getAgenDesc());
                    map.put("agenStartTime", bean.getAgenStartTime());
                    map.put("agenEndTime", bean.getAgenEndTime());

                    agendaList.add(map);

                }
                RecylerAdapter adapter = new RecylerAdapter(AgendaActivity.this, (ArrayList<HashMap<String, String>>) agendaList);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(AgendaActivity.this));


            }
        }).execute();

    }

    private class RecylerAdapter extends RecyclerView.Adapter<AgendaRecyclerViewHolder> {
        LayoutInflater inflater;
        Context context;
        List<HashMap<String, String>> mapsList;
        HashMap<String, String> maps;

        //String[] name = {"Androidwarriors", "Stackoverflow", "Developer Android", "AndroidHive"};

        public RecylerAdapter(Context context, ArrayList<HashMap<String, String>> list) {
            this.context = context;
            mapsList = list;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public AgendaRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.agenda_list_item, parent, false);
            AgendaRecyclerViewHolder viewHolder = new AgendaRecyclerViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(AgendaRecyclerViewHolder holder, int position) {


            int[] androidColors = getResources().getIntArray(R.array.rainbow);
            int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];

            holder.agendaLayout.setBackgroundColor(randomAndroidColor);

            maps = mapsList.get(position);

            holder.agendaTitle.setText(maps.get("agenTitle"));
            holder.agendaDesc.setText(maps.get("agenDesc"));
            holder.agendaTime.setText(maps.get("agenStartTime") + "-" + maps.get("agenEndTime"));
            holder.cardView.setOnClickListener(clickListener);
            holder.cardView.setTag(holder);
        }

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AgendaRecyclerViewHolder vholder = (AgendaRecyclerViewHolder) v.getTag();
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
                //  Toast.makeText(context,"This is position "+position,Toast.LENGTH_LONG ).show();

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
