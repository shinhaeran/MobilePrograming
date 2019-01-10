package com.example.lee.jsonparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String ID;
    Adapter adapter ;
    ArrayList<JsonItem> items ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.ListView);

        ID ="TEST";

        try {
            JSONObject RESULT = new MainTask(this).execute("http://203.255.92.139:10080/Test/rest/JavaAPI/SelectAPI",ID).get();
            JSONObject HEAD = RESULT.getJSONObject("HEAD");
            JSONObject BODY = RESULT.getJSONObject("BODY");
            JSONArray LIST = BODY.getJSONArray("LIST");
            int STATUS = HEAD.getInt("STATUS_CODE");

            items = new ArrayList<>();

            if(STATUS == 100){
                for(int i=0; i<LIST.length(); i++){

                    JsonItem item = new JsonItem();
                    JSONObject tmp = LIST.getJSONObject(i);

                    String WRITER = tmp.getString("WRITER");
                    String TITLE = tmp.getString("TITLE");
                    String CONTENTS = tmp.getString("CONTENTS");

                    Log.d("WRITER"+" ["+i+"]"+"번째",WRITER);
                    Log.d("TITLE"+" ["+ i +"]"+"번째",TITLE);
                    Log.d("CONTENTS"+" ["+i+"]"+"번째",CONTENTS);

                    item.setTitle(TITLE);
                    item.setWriter(WRITER);
                    item.setContents(CONTENTS);
                    items.add(item);

                }


            }

            adapter = new Adapter(items);
            listView.setAdapter(adapter);






        } catch (Exception e) {


            e.printStackTrace();
        }


    }
}
