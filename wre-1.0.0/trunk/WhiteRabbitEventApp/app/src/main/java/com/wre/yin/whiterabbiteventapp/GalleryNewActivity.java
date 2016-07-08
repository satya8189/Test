package com.wre.yin.whiterabbiteventapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.beans.GridItem;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GalleryNewActivity extends AppCompatActivity {
    private GridView mGridView;
    private String eventId, partId;
    private ArrayList<GridItem> mGridData;
    private GallaryAdapter mGridAdapter;
    private SharedPreferences prefs;
    private RecyclerView rView;
    private GridLayoutManager gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_new);

        //mGridView = (GridView) findViewById(R.id.new_gridView);
        prefs = getSharedPreferences("Chat", 0);
        partId = prefs.getString("partId", null);
        eventId = prefs.getString("eventId", null);

        rView = (RecyclerView) findViewById(R.id.gallary_grid_recycler_view);
        gridLayout = new GridLayoutManager(GalleryNewActivity.this, 2);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayout);


        new MyAsyncTask(Constants.IMAGE_LIST + eventId + "&paticipantId=" + partId + "&type=image", null, GalleryNewActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                mGridData = new ArrayList<>();
                List<GalaryBean> docBeanList = Utils.getList(result, GalaryBean.class);
                if (docBeanList != null) {
                    for (GalaryBean bean : docBeanList) {
                        GridItem gridItem = new GridItem();
                        gridItem.setImage(Constants.IMAGE_URL + eventId + "/image/" + bean.getFileName());
                        gridItem.setTitle(bean.getName());
                        gridItem.setEventId(Long.parseLong(eventId));
                        gridItem.setPartId(Long.parseLong(partId));
                        gridItem.setImageId(bean.getGlaryItemId());
                        gridItem.setLikeCount(bean.getLikeCount());
                        gridItem.setLikeStatus(bean.getLikeStatus());
                        mGridData.add(gridItem);
                    }
                    mGridAdapter = new GallaryAdapter(GalleryNewActivity.this, mGridData);
                    rView.setAdapter(mGridAdapter);
                    rView.invalidate();
                }
                //mGridAdapter.notifyDataSetChanged();

                //Grid view click event
                /*mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        //Get item at position
                        GridItem item = (GridItem) parent.getItemAtPosition(position);

                        Intent intent = new Intent(GalleryNewActivity.this, NewGalImageDetails.class);
                        ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);

                        int[] screenLocation = new int[2];
                        imageView.getLocationOnScreen(screenLocation);

                        //Pass the image title and url to DetailsActivity
                        intent.putExtra("left", screenLocation[0]).
                                putExtra("top", screenLocation[1]).
                                putExtra("width", imageView.getWidth()).
                                putExtra("height", imageView.getHeight()).
                                putExtra("title", item.getTitle()).
                                putExtra("image", item.getImage());

                        //Start details activity
                        startActivity(intent);
                    }
                });*/


            }
        }).execute();
    }

    private class GallaryAdapter extends RecyclerView.Adapter<GallaryRecyleHolder> {
        List<GridItem> mapsList;
        GridItem item;
        private Context mcontext;

        public GallaryAdapter(Context context, ArrayList<GridItem> list) {
            mapsList = list;
            this.mcontext = context;
        }

        @Override
        public GallaryRecyleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, null);
            GallaryRecyleHolder rcv = new GallaryRecyleHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(final GallaryRecyleHolder holder, final int position) {
            item = mapsList.get(position);
            holder.likeCount.setText(item.getLikeCount());
            Picasso.with(mcontext).load(item.getImage()).into(holder.imageView);
            holder.likeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GridItem i = mapsList.get(position);
                    final int count = Integer.parseInt(i.getLikeCount()) + 1;
                    if (i.getLikeStatus() == null) {
                        GalaryBean galaryBean = new GalaryBean();
                        galaryBean.setEventId(i.getEventId());
                        galaryBean.setParticipantId(i.getPartId());
                        galaryBean.setGlaryItemId(i.getImageId());
                        galaryBean.setLikeStatus("Active");

                        new MyAsyncTask(Constants.IMAGE_LIKE_SAVE, Utils.getJson(galaryBean), GalleryNewActivity.this, new Callback() {
                            @Override
                            public void onResult(String result) {
                                holder.likeImage.setImageResource(R.drawable.full);
                                holder.likeCount.setTextColor(Color.parseColor("#FFC400"));
                                holder.likeCount.setText("" + count);
                                Intent i = new Intent(GalleryNewActivity.this, GalleryNewActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }).execute();

                    }
                }
            });


            if (item.getLikeStatus() != null) {
                holder.likeImage.setImageResource(R.drawable.full);
                holder.likeCount.setTextColor(Color.parseColor("#FFC400"));
            }
        }

        @Override
        public int getItemCount() {
            return mapsList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }
    }
}
