package com.example.a219.api_exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    // 전역변수로 선언.
    RadioGroup Group;
    RadioButton Male;
    RadioButton FeMale;

    EditText ET1;
    EditText ET2;
    EditText ET3;
    EditText ET4;

    Button BT1;
    Button BT2;

    String SEX; // 성별 여부를 확인해 줄 스트링  값.

    Button AfterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Group = (RadioGroup)findViewById(R.id.Group);
        Male = (RadioButton)findViewById(R.id.Male);
        FeMale = (RadioButton)findViewById(R.id.FeMale);

        ET1 = (EditText)findViewById(R.id.et1);
        ET2 = (EditText)findViewById(R.id.et2);
        ET3 = (EditText)findViewById(R.id.et3);
        ET4 = (EditText)findViewById(R.id.et4);

        BT1 = (Button)findViewById(R.id.bt1);
        BT2 = (Button)findViewById(R.id.bt2);

        BT1.setOnClickListener(bt1listener); // 괄호 안에  구현해주기  (on create 밖에서 )
        BT2.setOnClickListener(bt1listener);



        Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = Group.getCheckedRadioButtonId();  //라디오 그룹안에 있는 버튼이 클릭될때마다, 값이 바뀐다.

                switch (id){ // 조건 아이디.

                    case R.id.Male: // 해당하는 아이디값.
                        SEX = "남";
                        break;

                    case R.id.FeMale:
                        SEX ="여";
                        break;

                    default:
                        SEX = "XX"; // 혹시 다른거 선택했을경우.
                        break;

                }

                Log.d("RADIO",SEX);

            }
        });



    }

    Button.OnClickListener bt1listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();// 아이디값 ㅇ받을 변수

            if(id == R.id.bt1 ){  //1번 버튼 클릭 됐ㄷ울때

                String name = ET1.getText().toString(); // edittext에서 받아온걸 string으로 변환해서 저장
                String schoolnumber = ET2.getText().toString();
                String phone = ET3.getText().toString();
                String age = ET4.getText().toString();

                if(name.equals("") || schoolnumber.equals("") || phone.equals("") || age.equals("")) //빈칸이면
                {
                    Toast.makeText(MainActivity.this, "빈칸 확인해 주세여", Toast.LENGTH_SHORT).show();
                }
                else { // 빈칸 아니면

                    try {   // insert task 연결해주는거 , 입력받을 변수들을 넘겨준당  //doInBackground에서 받아주는거
//                        JSONObject result = new InsertTask(MainActivity.this).execute("http://203.255.92.139:8080/Test/rest/JavaAPI/InsertMember", name, schoolnumber, phone, agｅ）.get();
                        JSONObject result = new InsertTask(MainActivity.this).execute("http://203.255.92.139:8080/Test/rest/JavaAPI/InsertMember", name, schoolnumber, phone, age,SEX).get();
                        //파싱해주기

                        JSONObject Head = result.getJSONObject("HEAD"); // 파싱 : key값으로 value 값 얻어오기  // HEAD 라는 변수에, HEAD라는 key 값 을 넣어서 value값 얻어오기 (json object 타입)
                        // STATUS CODE 알아오기.
                        int STATUSCODE = Head.getInt("STATUS_CODE"); // 얘도 파싱하눈것 >< STATUSCODE 알아오려구  (int 타입)

                        if (STATUSCODE == 100) // 연결이 성공했울때  => statuscode 가 100일 때
                        {
                            Toast.makeText(MainActivity.this, "정상적으로 요청되었습니당", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "엥 에러남;", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            else if(id == R.id.bt2 ) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }

        }
    };









}
