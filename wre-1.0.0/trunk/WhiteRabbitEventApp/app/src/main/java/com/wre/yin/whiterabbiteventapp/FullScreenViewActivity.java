package com.wre.yin.whiterabbiteventapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.wre.yin.whiterabbiteventapp.adapters.FullScreenImageAdapter;
import com.wre.yin.whiterabbiteventapp.utils.GalleryUtils;


public class FullScreenViewActivity extends Activity {

	private GalleryUtils utils;
	private FullScreenImageAdapter adapter;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen_view);

		viewPager = (ViewPager) findViewById(R.id.pager);

		utils = new GalleryUtils(getApplicationContext());

		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);

		adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
				utils.getFilePaths());

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
	}
}
