package com.example.haseyuuki.gsonlib;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Type;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends Activity {

    private TextView textview;
    private ImageView imageView;
    private EditText etitText;
    private Button downloadButton;
    private PlaceMark placeMark = new PlaceMark();
    private PlaceList placeList = new PlaceList();
    private User user = new User();
    private UserList userList = new UserList();
    private Light light = new Light();
    private LightList lightList = new LightList();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textView);
        etitText = (EditText) findViewById(R.id.uri);
        imageView = (ImageView) findViewById(R.id.result);
        downloadButton = (Button) findViewById(R.id.download);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskExe();
            }
        });
    }


    private void taskExe(){
        final String param0 = "http://fujitsu-chizai.azurewebsites.net/api/lights/601";
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            Bitmap bmp;
            String str;


            @Override
            protected Void doInBackground(Void... params) {
                str = downloadJson(param0);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){

                try {
                    ParseJson parseJson = new ParseJson();
                    light = parseJson.parseLight(str);
                    textview.setText(String.valueOf(light.x));
                }
                catch(JSONException e){
                    e.printStackTrace();
                }

            }
        };
        task.execute();
    }

//Http　GETメソッド　処理メソッド
    private String downloadJson(String address) {
        String str = null;

        try {
            URL url = new URL( address );

            // HttpURLConnection インスタンス生成
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // タイムアウト設定
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(20000);

            // リクエストメソッド
            urlConnection.setRequestMethod("GET");

            // リダイレクトを自動で許可しない設定
            urlConnection.setInstanceFollowRedirects(false);

            // ヘッダーの設定(複数設定可能)
            urlConnection.setRequestProperty("Accept-Language", "jp");

            // 接続
            urlConnection.connect();

            int resp = urlConnection.getResponseCode();

            switch (resp){
                case HttpURLConnection.HTTP_OK:
                    InputStream is = urlConnection.getInputStream();
                    str = InputStreamToString(is);
                    is.close();
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            Log.d(TAG, "downloadJson error");
            e.printStackTrace();
        }

        return str;
    }

    //取得したストリームを文字列に変換するメソッド
    static String InputStreamToString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}


