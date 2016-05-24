package com.wre.yin.whiterabbiteventapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.R;
import com.wre.yin.whiterabbiteventapp.gridlibrary.BaseDynamicGridAdapter;

import java.util.List;


public class CheeseDynamicAdapter extends BaseDynamicGridAdapter {
    public CheeseDynamicAdapter(Context context, List<?> items, int columnCount) {
        super(context, items, columnCount);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CheeseViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grid, null);
            holder = new CheeseViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (CheeseViewHolder) convertView.getTag();
        }
        holder.build(getItem(position).toString());
        return convertView;
    }

    private class CheeseViewHolder {
        private TextView titleText1, titleText2;
        private ImageView image;

        private CheeseViewHolder(View view) {
            titleText1 = (TextView) view.findViewById(R.id.item_title1);

            titleText2 = (TextView) view.findViewById(R.id.item_title2);
            image = (ImageView) view.findViewById(R.id.item_img);
        }

        void build(String title) {
            titleText1.setText(title);
            image.setImageResource(R.drawable.user_icon);
        }
    }
}