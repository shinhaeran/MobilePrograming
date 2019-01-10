package com.example.netdb.custonlistview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // static final String[] LIST_MENY={"LIST1","LIST2","LIST3"};
    ArrayList<ListViewItem> items=new ArrayList<ListViewItem>();
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*
        ListView listView=(ListView)findViewById(R.id.listview1);//리스트뷰를 전역으로 설정해 줄 수 있어,,,
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,LIST_MENY);
        //this를 simple_list_item_1라는 안드로이드에서 기본으로 제공해주는 레이아웃으로 View에 맵핑될거임, 내가 만든 LIST_MENY데이터로
        //
        listView.setAdapter(adapter);//커스텀 레이아웃은 담을 수 있는 item.xml을 반드시 만들어줘야함!(레이아웃)
*/
        adapter=new ListAdapter();

        ListView listView=(ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_launcher_background),"2016037075","신혜란");//adapter클래스에서 설정해놓은 순서와 일치해야함(내가 만든거였음)

    }

}
