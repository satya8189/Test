package com.wre.yin.whiterabbiteventapp.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.DocShareActivity;
import com.wre.yin.whiterabbiteventapp.R;

/**
 * Created by YINSOL on 5/24/2016.
 */
public class CustomAdapter extends BaseAdapter {
    String[] result;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(DocShareActivity docShareActivity, String[] wordDocsNameList, int[] wordDocImage) {
        result = wordDocsNameList;
        context = docShareActivity;
        imageId = wordDocImage;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView docsName;
        ImageView docsTypeImage;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.docs_list_row, null);
        holder.docsName = (TextView) rowView.findViewById(R.id.docs_name_text);
        holder.docsTypeImage = (ImageView) rowView.findViewById(R.id.docs_type_image);

        holder.docsName.setText(result[position]);
        holder.docsTypeImage.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();

                final String[] items = {"Share", "View", "Download"};


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(result[position]);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        String itemName = (items[item]);
                        if (itemName == "Share") {
                            Toast.makeText(context, "You Clicked " + itemName, Toast.LENGTH_LONG).show();

                        } else if (itemName == "View") {
                            Toast.makeText(context, "You Clicked " + itemName, Toast.LENGTH_LONG).show();

                        } else if (itemName == "Download") {
                            Toast.makeText(context, "You Clicked " + itemName, Toast.LENGTH_LONG).show();
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return rowView;
    }
}
