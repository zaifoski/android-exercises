package com.example.umberto.listviewwithnumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by umberto on 23/03/16.
 */
public class MyListViewAdapter extends ArrayAdapter {

    private ArrayList<ListItem> mItems;
    private Context mContext;
    private int mListRowLayout;

    public MyListViewAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        mItems = objects;
        mContext = context;
        mListRowLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mListRowLayout, null);

        ListItem element = mItems.get(position);

        TextView  t = (TextView) convertView.findViewById(R.id.textViewListItem);
        t.setText(element.getName());

        return convertView;
    }
}
