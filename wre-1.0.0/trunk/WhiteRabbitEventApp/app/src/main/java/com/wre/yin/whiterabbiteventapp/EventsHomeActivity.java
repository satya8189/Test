package com.wre.yin.whiterabbiteventapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class EventsHomeActivity extends Activity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private ArrayList<Integer> listOfItems;
    private LinearLayout dotsLayout;
    private int dotsCount;
    private TextView[] dots;
    //	page change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            }
            dots[position].setTextColor(getResources().getColor(R.color.dots_color));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    private Target target;
    private String backgroundImageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_events_home);

        initViews();
        setViewPagerItemsWithAdapter();
        setUiPageViewController();


    }

    private void initViews() {

        //getActionBar().hide();

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        listOfItems = new ArrayList<Integer>();
        listOfItems.add(R.drawable.event_image1);
        listOfItems.add(R.drawable.event_image2);
        listOfItems.add(R.drawable.event_image3);

    }

    private void setViewPagerItemsWithAdapter() {
        myViewPagerAdapter = new MyViewPagerAdapter(listOfItems);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(viewPagerPageChangeListener);
        viewPager.setPageTransformer(true, new FadePageTransformer());

    }

    private void setUiPageViewController() {
        dotsLayout = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        dotsCount = myViewPagerAdapter.getCount();
        dots = new TextView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(50);
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            dotsLayout.addView(dots[i]);
        }

        dots[0].setTextColor(getResources().getColor(R.color.dots_color));
    }

    private static class FadePageTransformer implements ViewPager.PageTransformer {
        public void transformPage(View view, float position) {
            view.setAlpha(1 - Math.abs(position));
            if (position < 0) {
                view.setScrollX((int) ((float) (view.getWidth()) * position));
            } else if (position > 0) {
                view.setScrollX(-(int) ((float) (view.getWidth()) * -position));
            } else {
                view.setScrollX(0);
            }
        }
    }

    private static class FadePageUpTransformer implements ViewPager.PageTransformer {
        public void transformPage(View view, float position) {
            view.setAlpha(1 - Math.abs(position));
            if (position > 0) {
                view.setScrollY((int) ((float) (view.getWidth()) * position));
            } else if (position < 0) {
                view.setScrollY(-(int) ((float) (view.getWidth()) * -position));
            } else {
                view.setScrollY(0);
            }
        }
    }

    //	adapter
    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;
        private ArrayList<Integer> items;

        public MyViewPagerAdapter(ArrayList<Integer> listOfItems) {
            this.items = listOfItems;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.view_pager_item, container, false);

            TextView tView = (TextView) view.findViewById(R.id.PageNumber);

            final ImageView iView = (ImageView) view.findViewById(R.id.imageView);

            final RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);

            final ImageView pFic = (ImageView) findViewById(R.id.profilepic);

            pFic.setImageResource(R.drawable.user_icon);


            target = new Target() {
                @Override
                public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                    Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
                        public void onGenerated(Palette palette) {
                            // iView.setImageBitmap(bitmap);
                            pFic.setImageBitmap(bitmap);
                            int defaultColor = getResources().getColor(android.R.color.black);
                            rl1.setBackgroundColor(palette.getVibrantColor(defaultColor));
                        }
                    });
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            };
            Picasso.with(getApplicationContext())
                    .load(R.drawable.user_icon)
                    .into(target);

            tView.setText(listOfItems.get(position).toString());

            iView.setImageResource(listOfItems.get(position));

            backgroundImageName = getResources().getResourceEntryName(listOfItems.get(position));
            ;

            iView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(getApplicationContext(), "Click Image is  " + backgroundImageName + " position:" + listOfItems.get(position), Toast.LENGTH_LONG).show();
                    Intent singleEvent = new Intent(getApplicationContext(), EventDashboardActivity.class);
                    singleEvent.putExtra(listOfItems.get(position).toString(), "position");
                    startActivity(singleEvent);

                }
            });


            ((ViewPager) container).addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            ((ViewPager) container).removeView(view);
        }
    }
}
