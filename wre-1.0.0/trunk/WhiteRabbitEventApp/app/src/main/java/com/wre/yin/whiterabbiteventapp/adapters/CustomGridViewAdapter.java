package com.wre.yin.whiterabbiteventapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.R;
import com.wre.yin.whiterabbiteventapp.beans.Item;

import java.util.ArrayList;

/**
 * Created by YINSOL on 5/2/2016.
 */
public class CustomGridViewAdapter extends ArrayAdapter<Item> {
    Context context;
    int layoutResourceId;
    ArrayList<Item> data = new ArrayList<Item>();

    public CustomGridViewAdapter(Context context, int layoutResourceId,
                                 ArrayList<Item> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Item item = data.get(position);

        holder.txtTitle.setText(item.getTitle());

        int idIndex = item.getId();
        TypedArray img;
        img = context.getResources().obtainTypedArray(R.array.services);
        holder.imageItem.setImageResource(img.getResourceId(idIndex - 1, 1));
        return row;

    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;

    }
}
