package com.example.haseyuuki.gsonlib;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import java.util.ArrayList;

/**
 * Jsonから各オブジェクトにパースを行うクラスです。
 * Created by haseyuuki on 2016/09/05.
 */
public class ParseJson {
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    private PlaceMark placemark1 = new PlaceMark();
    private PlaceList placelist1 = new PlaceList();
    private User user1 = new User();
    private UserList userlist1 = new UserList();
    private Light light1 = new Light();
    private LightList lightlist1 = new LightList();
    private Direction direction = new Direction();

    //Jsonから　PlaceMark 単体へパースを行う
    public PlaceMark parsePlace(String json) throws JSONException{
        placemark1 = gson.fromJson(json,PlaceMark.class);
        return placemark1;
    }
    //Jsonから　PlaceMark配列へパースを行う
    public PlaceList parsePlaceList(String json) throws JSONException {
        placelist1 = gson.fromJson(json, PlaceList.class);
    //    ArrayList<PlaceMark> Places = new ArrayList<PlaceMark>(placelist1.places);
        return  placelist1;
    }


    //Jsonから　User単体へパースを行う
    public User parseUser(String json) throws JSONException {
        user1 = gson.fromJson(json, User.class);
        return  user1;
    }
    //Jsonから　User配列へパースを行う
    public UserList parseUserList(String json) throws JSONException {
        userlist1 = gson.fromJson(json, UserList.class);
        return  userlist1;
    }


    //Jsonから　User単体へパースを行う
    public Light parseLight(String json) throws JSONException {
        light1 = gson.fromJson(json, Light.class);
        return  light1;
    }
    //Jsonから　Light配列へパースを行う
    public LightList parseLightList(String json) throws JSONException {
        lightlist1 = gson.fromJson(json, LightList.class);
        return  lightlist1;
    }

    public Direction parseDirection(String json) throws JSONException{
        direction = gson.fromJson(json, Direction.class);
        return  direction;
    }



}

/*
        //    final String param0 = etitText.getText().toString();
    //    final String param0 = "http://fujitsu-chizai.azurewebsites.net/api/places/63";
 //       final String param0 = "https://fujitsu-chizai.azurewebsites.net/api/places?floor=6";

//        final String param0 = "https://fujitsu-chizai.azurewebsites.net/api/users";
//        final String param0 = "https://fujitsu-chizai.azurewebsites.net/api/users/1";

 //       final String param0 = "http://fujitsu-chizai.azurewebsites.net/api/lights";
        final String param0 = "http://fujitsu-chizai.azurewebsites.net/api/lights/601";



    private PlaceMark placeMark = new PlaceMark();
    private PlaceList placeList = new PlaceList();
    private User user = new User();
    private UserList userList = new UserList();
    private Light light = new Light();
    private LightList lightList = new LightList();

    他クラスでの使用方法(例)
   ParseJson parseJson = new ParseJson();　　　　　　　//ParseJsonクラスのインスタンス化
   placeList = parseJson.parsePlaceList(str);　　　　　　//Jsonデータのパース
   placeMark = placeList.places.get(0);　　　　　　　　　//Listの0番目のオブジェクトを取得
   textview.setText(String.valueOf((placeMark.floor)));　//表示



                    ParseJson parseJson = new ParseJson();
                    userList = parseJson.parseUserList(str);
                    user = userList.users.get(0);
                    textview.setText(String.valueOf(user.createdAt));


                    ParseJson parseJson = new ParseJson();
                    user = parseJson.parseUser(str);
                    textview.setText(String.valueOf(user.createdAt));


                    ParseJson parseJson = new ParseJson();
                    lightList = parseJson.parseLightList(str);
                    light = lightList.lights.get(0);
                    textview.setText(String.valueOf(light.x));

                    ParseJson parseJson = new ParseJson();
                    light = parseJson.parseLight(str);
                    textview.setText(String.valueOf(light.x));

*/
