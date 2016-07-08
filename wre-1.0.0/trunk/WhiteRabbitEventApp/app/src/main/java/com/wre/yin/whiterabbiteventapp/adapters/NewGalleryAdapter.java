package com.wre.yin.whiterabbiteventapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wre.yin.whiterabbiteventapp.R;
import com.wre.yin.whiterabbiteventapp.beans.GridItem;
import com.wre.yin.whiterabbiteventapp.utils.ResizableImageView;

import java.util.ArrayList;

/**
 * Created by root on 17/6/16.
 */
public class NewGalleryAdapter extends ArrayAdapter<GridItem> {

    //private final ColorMatrixColorFilter grayscaleFilter;
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();

    public NewGalleryAdapter(Context mContext, int layoutResourceId, ArrayList<GridItem> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }


    /**
     * Updates grid data and refresh grid items.
     *
     * @param mGridData
     */
    public void setGridData(ArrayList<GridItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final ViewHolder holder;
        TextView titleTextView;
        ResizableImageView imageView;
        ImageView likeImage;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.gall_like_count);
            holder.imageView = (ResizableImageView) row.findViewById(R.id.grid_item_image);
            holder.likeImage = (ImageView) row.findViewById(R.id.gall_like_heart);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        GridItem item = mGridData.get(position);
        holder.titleTextView.setText(item.getLikeCount());
        if (item.getLikeStatus() != null) {
            holder.likeImage.setImageResource(R.drawable.full);
            holder.titleTextView.setTextColor(Color.parseColor("#FFC400"));
        }
        //holder.titleTextView.setText(Html.fromHtml(item.getTitle()));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridItem item = mGridData.get(position);
                holder.likeImage.setImageResource(R.drawable.full);
                holder.titleTextView.setTextColor(Color.parseColor("#FFC400"));
                holder.titleTextView.setText(item.getLikeCount());

            }
        });
        Picasso.with(mContext).load(item.getImage()).into(holder.imageView);
        return row;
    }

    static class ViewHolder {
        TextView titleTextView;
        ResizableImageView imageView;
        ImageView likeImage;
    }
}