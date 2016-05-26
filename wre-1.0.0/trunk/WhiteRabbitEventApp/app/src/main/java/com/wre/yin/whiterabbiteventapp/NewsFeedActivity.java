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
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.adapters.ExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity {
    private TextView text;


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private RecyclerView recyclerView;
    private CardView cardView;
    String layoutStatus = "gone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        String nameTxt = getIntent().getExtras().getString("name");
        //   text = (TextView) findViewById(R.id.activity_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);


        recyclerView = (RecyclerView) findViewById(R.id.newsfeed_recycler_view);


        RecyclerAdapter adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

/*//        text.setText(nameTxt);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExpandable);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    *//*
     * Preparing the list data
     *//*
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Expandable list view is used to group list data by categories. It has the capability of expanding and collapsing the groups when user touches header.");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Expandable list view is used to group list data by categories. It has the capability of expanding and collapsing the groups when user touches header.");
        //  nowShowing.add("Expandable list view is used to group list data by categories. It has the capability of expanding and collapsing the groups when user touches header.");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Expandable list view is used to group list data by categories. It has the capability of expanding and collapsing the groups when user touches header.");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);*/
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<AgendaRecyclerViewHolder> {
        LayoutInflater inflater;
        Context context;
        String[] name = {"Androidwarriors", "Stackoverflow", "Developer Android", "AndroidHive"};

        public RecyclerAdapter(Context context) {
            this.context = context;
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
            if (position == 1)
                holder.agendaLayout.setBackgroundColor(Color.parseColor("#C9C935"));
            else if (position == 2)
                holder.agendaLayout.setBackgroundColor(Color.parseColor("#F9B083"));
            else if (position == 3)
                holder.agendaLayout.setBackgroundColor(Color.parseColor("#67C2E1"));
            holder.tv1.setText(name[position]);
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
                Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG).show();

            }
        };

        @Override
        public int getItemCount() {
            return name.length;
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
