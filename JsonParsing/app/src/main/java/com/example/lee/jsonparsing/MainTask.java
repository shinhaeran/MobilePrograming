package com.example.lee.jsonparsing;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainTask extends AsyncTask<String, Void, JSONObject> {


    Context Parent;
    //MyAdapter myadapter;


    public MainTask(Context context) {
        this.Parent = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute(); // Override 되는 함수의 경우 그 함수 이전에 상위 클래스를 가지게 된다. 함수를 이용할 때는 상위 함수에 우리가 하고 있는 작업에 대해 정보를 전달해 주어야 한다.
                              // 이때 사용되는것이 super, super를 사용함에 있어 상위클래스와 소통을 하는 것이다.
                            //background쓰레드를 실행하기전 준비 단계이다. 변수의 초기화나, 네트워크 통신전 셋팅해야 할 것들을 작성
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {

    }


    /**
     *
     * 해당 메서드가 background 스레드로 일처리를 해주는 곳이다.
     * 보통 네트워크, 병행 일처리등을 위 메서드 공간에 작성한다.
     * 중요한건 마찬가지로 스레드 이므로 UI스레드가 어떤 일을 하고 있는지 상관없이
     * 별개의 일을 진행한다는 점이다. 따라서 AysncTask는 비동기적으로 작동한다.
     **/
    @Override
    protected JSONObject doInBackground(String... params) {
        JSONObject result = null;

        try {
            String url = params[0];

            String Body = "ID=" + params[1];/** +
                    "&WRITER=" + params[2] +
                    "&CONTENTS=" + params[3];**/

            Log.d("doInBackground", Body);

            URL URLObj = new URL(url);

            HttpURLConnection Conn = (HttpURLConnection) URLObj.openConnection();

            Conn.setReadTimeout(100000);
            Conn.setConnectTimeout(15000);

            Conn.setRequestMethod("POST");
            Conn.setRequestProperty("Accept-Charset", "UTF-8");
            Conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            Conn.setDoInput(true);
            Conn.setDoOutput(true);


            /**
             * InputStream = Reader
             * OutputStream = Writer
             * BufferedReader / BufferedWriter는 문자 입력 스트림으로부터 문자를 읽어 들이거나 문자 출력 스트림으로 문자를 내보낼 때 버퍼링을 함으로써
             * 문자, 문자 배열, 문자열 라인 등을 보다 효율적으로 처리할 수 있도록 해준다
             * InputStreamReader / OutputStreamWriter를 사용하는 경우는 한 문자씩 읽지만 버퍼링을 하게 되면 입출력 스트림으로부터 미리 버퍼에 데이터를 갖다 놓기 때문에 보다 효율적으로 입출력할 수 있다.
             **/

            OutputStream OutStream = Conn.getOutputStream();
            OutStream.write(Body.getBytes("utf-8"));

            InputStreamReader InputStream = new InputStreamReader(Conn.getInputStream(), "UTF-8");

            BufferedReader Reader = new BufferedReader(InputStream);
            StringBuilder Builder = new StringBuilder();
            String ResultStr;

            while ((ResultStr = Reader.readLine()) != null) {
                Builder.append(ResultStr + "\n");
            }

            result = new JSONObject(Builder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            result = null;
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        } finally {
            //Todo finally..
        }

        return result;
    }


}