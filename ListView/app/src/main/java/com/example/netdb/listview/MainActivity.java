package com.example.netdb.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    static final String[] LIST={"list1","list2","list3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      ListView listVIew=(ListView)findViewById(R.id.listView1);

      ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,LIST);

        listVIew.setAdapter(adapter);
    }
}
