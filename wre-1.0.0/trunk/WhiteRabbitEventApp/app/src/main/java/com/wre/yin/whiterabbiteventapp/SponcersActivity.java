package com.wre.yin.whiterabbiteventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.adapters.CheeseDynamicAdapter;
import com.wre.yin.whiterabbiteventapp.beans.Cheeses;
import com.wre.yin.whiterabbiteventapp.gridlibrary.DynamicGridView;

import java.util.ArrayList;
import java.util.Arrays;

public class SponcersActivity extends AppCompatActivity {

    private TextView text;
    private DynamicGridView gridView;
    private static final String TAG = SponcersActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponcers);

        String nameTxt = getIntent().getExtras().getString("name");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        gridView = (DynamicGridView) findViewById(R.id.dynamic_grid_sponcers);

        gridView.setAdapter(new CheeseDynamicAdapter(this,
                new ArrayList<String>(Arrays.asList(Cheeses.sCheeseStrings)),
                getResources().getInteger(R.integer.column_count)));

        gridView.setOnDragListener(new DynamicGridView.OnDragListener() {
            @Override
            public void onDragStarted(int position) {
                Log.d(TAG, "drag started at position " + position);
            }

            @Override
            public void onDragPositionsChanged(int oldPosition, int newPosition) {
                Log.d(TAG, String.format("drag item position changed from %d to %d", oldPosition, newPosition));
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                gridView.startEditMode(position);
                return true;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(SponcersActivity.this, parent.getAdapter().getItem(position).toString(),                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SponcersActivity.this, SponcersProfileActivity.class);
                i.putExtra("sponcersName", parent.getAdapter().getItem(position).toString());
                startActivity(i);

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (gridView.isEditMode()) {
            gridView.stopEditMode();
        } else {
            super.onBackPressed();
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
