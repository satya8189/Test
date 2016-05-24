package com.wre.yin.whiterabbiteventapp.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;

        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
       if (groupPosition % 2 == 0) {
            convertView.setBackgroundResource(R.drawable.rectangle_shape_yes);
            // use this when you want to use hexa value of colors
        } else {
            convertView.setBackgroundResource(R.drawable.rectangle_shape_no);
            // use this when you want to use hexa value of colors
        }
       /* int[] androidColors = _context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        convertView.setBackgroundColor(randomAndroidColor);
       Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        convertView.setBackgroundColor(color);*/

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);


        }
        if (groupPosition % 2 == 0) {
            // convertView.setBackgroundColor(Color.parseColor("#67C2E1"));
            convertView.setBackgroundResource(R.drawable.rectangle_shape_yes);

            // use this when you want to use hexa value of colors
        } else {
            convertView.setBackgroundResource(R.drawable.rectangle_shape_no);
            // use this when you want to use hexa value of colors
        }
     /* *//*  Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        convertView.setBackgroundColor(color);*//*
        int[] androidColors = _context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        convertView.setBackgroundColor(randomAndroidColor);*/


        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        TextView taskerName = (TextView) convertView.findViewById(R.id.tasker_name);
        TextView dateTime = (TextView) convertView.findViewById(R.id.date_time_task);

        ImageView plus = (ImageView) convertView.findViewById(R.id.plus);
        ImageView minus = (ImageView) convertView.findViewById(R.id.minus);

        if (isExpanded) {
            plus.setVisibility(View.INVISIBLE);
            minus.setVisibility(View.VISIBLE);
        } else {

            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
