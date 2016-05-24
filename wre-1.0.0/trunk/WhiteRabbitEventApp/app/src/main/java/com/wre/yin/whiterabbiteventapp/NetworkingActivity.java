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

public class NetworkingActivity extends AppCompatActivity {
    private TextView text;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);

        String nameTxt = getIntent().getExtras().getString("name");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        recyclerView= (RecyclerView) findViewById(R.id.my_recycler_view);


        RecylerAdapter adapter=new RecylerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private class RecylerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        LayoutInflater inflater;
        Context context;
        String [] name={"Androidwarriors","Stackoverflow","Developer Android","AndroidHive",
                "Slidenerd","TheNewBoston","Truiton","HmkCode","JavaTpoint","Javapeper"};
        public RecylerAdapter(Context context) {
            this.context=context;
            inflater=LayoutInflater.from(context);
        }
        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=inflater.inflate(R.layout.network_list_item,parent,false);
            RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.tv1.setText(name[position]);
            holder.cardView.setOnClickListener(clickListener);
            holder.cardView.setTag(holder);
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
            return name.length;
        }
    }
}
