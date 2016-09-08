package com.example.haseyuuki.gsonlib;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Type;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
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
    private PlaceMark placeMark;
    private PlaceList placeList;
    private User user;
    private UserList userList;
    private Light light;
    private LightList lightList;
    private Direction direction;
    private Geocode geocode;

    private String json = null;
    FujitsuAPI fujitsuAPI = new FujitsuAPI();
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
                touch();
            }
        });
        GetAPI();
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void touch(){
        try {
            light = fujitsuAPI.light;
            lightList = fujitsuAPI.lightList;
            placeMark = fujitsuAPI.placeMark;
            placeList = fujitsuAPI.placeList;
            user = fujitsuAPI.user;
            userList = fujitsuAPI.userList;
            direction = fujitsuAPI.direction;
            geocode = fujitsuAPI.geocode;


            Log.d("MainActivity lightId1",String.valueOf(light.lightId));
            Log.d("MainActivity lightId2",String.valueOf(lightList.lights.get(1).lightId));
            Log.d("MainActivity placeId1",String.valueOf(placeMark.id));
            Log.d("MainActivity placeId2",String.valueOf(placeList.places.get(0).id));
            Log.d("MainActivity userId1",String.valueOf(user.id));
            Log.d("MainActivity userId1",String.valueOf(userList.users.get(0).id));
            Log.d("MainActivity DirectX",String.valueOf(direction.routes.get(0).steps.get(0).start.x));
            Log.d("MainActivity GeocodeX",String.valueOf(geocode.x));


            textview.setText("");

        }
        catch(NullPointerException npe){
            textview.setText("TextView NullPointException");
        }
    }

    public void GetAPI(){
        try {
            /*Light API*/
            fujitsuAPI.lightPoint(601);
         //   fujitsuAPI.lightAll();
         //   fujitsuAPI.lightSearch(890,558,6,1000);
            fujitsuAPI.lightFloor(6);

            /*Place API*/
            fujitsuAPI.placePoint(63);
          //  fujitsuAPI.placeAll();
          //  fujitsuAPI.placeKeyword("実験室");
          //  fujitsuAPI.placeSearch(890,558,6,1000);
          //  fujitsuAPI.placeSearchAndKeyword("実験室",890,558,6,1000);
            fujitsuAPI.placeFloor(6);

            /*User API*/
            fujitsuAPI.userPoint(1);
            fujitsuAPI.userAll();

            /*Direction API*/
            fujitsuAPI.direction(63,82,PlaceMarkType.Place,PlaceMarkType.Place);
           // fujitsuAPI.directionRegistered(1,63,82,PlaceMarkType.Place,PlaceMarkType.Place);

            /*Geocode API*/
            fujitsuAPI.geocode(604,605);
        }
        catch(NullPointerException npe){
            Log.d("FujitsuAPI","NullPointerException");
        }
    }

}


