package com.wre.yin.whiterabbiteventapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.R;
import com.wre.yin.whiterabbiteventapp.beans.ChatMessage;

import java.util.List;

/**
 * Created by himanshusoni on 06/09/15.
 */
public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    private static final int MY_MESSAGE = 0, OTHER_MESSAGE = 1, MY_IMAGE = 2, OTHER_IMAGE = 3;

    public ChatMessageAdapter(Context context, List<ChatMessage> data) {
        super(context, R.layout.item_mine_message, data);
    }

    @Override
    public int getViewTypeCount() {
        // my message, other message, my image, other image
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage item = getItem(position);

        if (item.isMine() && !item.isImage()) return MY_MESSAGE;
        else if (!item.isMine() && !item.isImage()) return OTHER_MESSAGE;
        else if (item.isMine() && item.isImage()) return MY_IMAGE;
        else return OTHER_IMAGE;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        if (viewType == MY_MESSAGE) {
            TextView myName, message,myTime;
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);

            message = (TextView) convertView.findViewById(R.id.msg_my);
            myName = (TextView) convertView.findViewById(R.id.msg_my_name);
            myTime = (TextView) convertView.findViewById(R.id.my_time);
            myTime.setText(getItem(position).getTime());
            myName.setText(getItem(position).getName());

            message.setText(getItem(position).getContent());

        } else if (viewType == OTHER_MESSAGE) {
            TextView otherName, otherMessage,othetTime;
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_other_message, parent, false);

            otherMessage = (TextView) convertView.findViewById(R.id.msg_other_msg);
            otherName = (TextView) convertView.findViewById(R.id.msg_other_name);
            othetTime= (TextView) convertView.findViewById(R.id.msg_other_time);

            othetTime.setText(getItem(position).getTime());
            otherName.setText(getItem(position).getName());
            otherMessage.setText(getItem(position).getContent());


        } else if (viewType == MY_IMAGE) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_image, parent, false);
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_other_image, parent, false);
        }

        convertView.findViewById(R.id.chatMessageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getContext(), "onClick", Toast.LENGTH_LONG).show();
            }
        });


        return convertView;
    }
}
