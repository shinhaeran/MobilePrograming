package com.example.lee.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context parent;


    ArrayList<JsonItem> items = new ArrayList<>();


    public  Adapter(ArrayList<JsonItem> items){

        this.items = items;


    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public JsonItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.json_item, null);

        }

        TextView Title = (TextView)convertView.findViewById(R.id.Title);
        TextView Writer = (TextView)convertView.findViewById(R.id.Writer);
        TextView Contents = (TextView)convertView.findViewById(R.id.Contents);

        JsonItem item = getItem(position);

        Title.setText(item.getTitle());
        Writer.setText(item.getWriter());
        Contents.setText(item.getContents());
        return convertView;
    }
}
