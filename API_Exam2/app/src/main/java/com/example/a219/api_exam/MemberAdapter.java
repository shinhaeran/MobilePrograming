package com.example.a219.api_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by 219 on 2018-11-28.
 */

public class MemberAdapter extends BaseAdapter {

    Context parent;
    ArrayList<JsonItem> items = new ArrayList<JsonItem>();


    public MemberAdapter(ArrayList<JsonItem> items) {

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
            convertView = inflater.inflate(R.layout.item, null); //  R.layout.item, null); 이거는, item 레이아웃을  가져다 붙이는것....

        }

        TextView Name = (TextView) convertView.findViewById(R.id.name);
        TextView SchoolNumber = (TextView) convertView.findViewById(R.id.schoolnumber);
        TextView Phone = (TextView) convertView.findViewById(R.id.phone);
        TextView Age = (TextView) convertView.findViewById(R.id.age);
        TextView Sex = (TextView) convertView.findViewById(R.id.sex);

        JsonItem item = getItem(position);

        Name.setText(item.getName());
        SchoolNumber.setText(item.getSchoolNumber());
        Phone.setText(item.getPhone());
        Age.setText(item.getAge());
        Sex.setText(item.getSex());
        return convertView;
    }


}
