package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.wre.yin.whiterabbiteventapp.adapters.NewGalleryAdapter;
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
    private String eventId, name;
    private ArrayList<GridItem> mGridData;
    private NewGalleryAdapter mGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalleryNewActivity.this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_gallery_new);
        eventId = getIntent().getExtras().getString("eventId");
        name = getIntent().getExtras().getString("name");

        mGridView = (GridView) findViewById(R.id.new_gridView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(name);

        if (Constants.isNetworkAvailable(GalleryNewActivity.this)) {
            new MyAsyncTask(Constants.FILES_LIST + eventId + "&type=image", null, GalleryNewActivity.this, new Callback() {
                @Override
                public void onResult(String result) {
                    mGridData = new ArrayList<>();
                    List<GalaryBean> docBeanList = Utils.getList(result, GalaryBean.class);
                    for (GalaryBean bean : docBeanList) {
                        GridItem gridItem = new GridItem();
                        gridItem.setImage(Constants.IMAGE_URL + eventId + "/image/" + bean.getFileName());
                        gridItem.setTitle(bean.getName());
                        mGridData.add(gridItem);
                    }
                    mGridAdapter = new NewGalleryAdapter(GalleryNewActivity.this, R.layout.grid_item_layout, mGridData);
                    mGridView.setAdapter(mGridAdapter);

                    //Grid view click event
                    mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                    });


                }
            }).execute();
        } else {
            Constants.createDialogSend(GalleryNewActivity.this, "error", "Please connect to internet");
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        GalleryNewActivity.this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);

    }
}
