package com.example.a219.api_exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    MemberAdapter memberadapter;
    ArrayList<JsonItem> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        listView = (ListView)findViewById(R.id.member);

        items = new ArrayList<>();

        try{

//            JSONObject result = new SelectTask(SecondActivity.this).execute("http://203.255.92.139:8080/Test/rest/JavaAPI/SelectAPI", "sdf").get();
            JSONObject result = new SelectTask(SecondActivity.this).execute("http://203.255.92.139:8080/Test/rest/JavaAPI/SelectAPI", "haeran").get();


            JSONObject Head = result.getJSONObject("HEAD");
            int STATUSCOD = Head.getInt("STATUS_CODE");  // head  오브젝트 안의 status code 받아오려구.,,,,
            JSONObject Body = result.getJSONObject("BODY");
            JSONArray List = Body.getJSONArray("LIST"); // Body 오브젝트 안의 list 받아오려구,,,,

            if(STATUSCOD == 100){

                for(int i=0; i< List.length(); i++){

                    JsonItem item =  new JsonItem(); //  setter 이용하려고 생성....

                    JSONObject tmp = List.getJSONObject(i);

                    String scoolnumber = tmp.getString("SCHOOLNUMBER");  // key값 적어주는 것
                    String name = tmp.getString("NAME");
                    String phone = tmp.getString("PHONE");
                    String age = tmp.getString("AGE");
                    String sex = tmp.getString("SEX");

                    item.setAge(age);
                    item.setName(name);
                    item.setPhone(phone);
                    item.setSchoolNumber(scoolnumber);
                    item.setSex(sex);

                    items.add(item);

                }

                memberadapter = new MemberAdapter(items); // adapter에 items를 넘겨준당
                listView.setAdapter(memberadapter); // listview 에 adapter를 붙여준당


            }


        }

        catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(SecondActivity.this, "정상적으로 요청되었습니당", Toast.LENGTH_SHORT).show();
        }









    };
}
