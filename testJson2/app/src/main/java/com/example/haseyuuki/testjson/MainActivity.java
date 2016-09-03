package com.example.haseyuuki.testjson;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    private TextView textview;
    private ImageView imageView;
    private EditText etitText;
    private Button downloadButton;
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
    //    final String param0 = etitText.getText().toString();
        final String param0 = "http://fujitsu-chizai.azurewebsites.net/api/places/63";
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            Bitmap bmp;
            String str;

            @Override
            protected Void doInBackground(Void... params) {
          //      bmp = downloadImage(param0);
                str = downloadJson(param0);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
       //         imageView.setImageBitmap(bmp);
                //textview.setText(str);
                try{
                    str = parseJson(str);
                    textview.setText(str);
                }
                catch(JSONException e){
                    e.printStackTrace();
                }

            }
        };
        task.execute();
    }

    private Bitmap downloadImage(String address) {
        Bitmap bmp = null;

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
                    bmp = BitmapFactory.decodeStream(is);
                    is.close();
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            Log.d(TAG, "downloadImage error");
            e.printStackTrace();
        }

        return bmp;
    }


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

    private String parseJson(String str) throws JSONException{
        JSONObject jsonObject = new JSONObject(str);
        String x = jsonObject.getString("type");
        return x;
    }

}