package com.example.haseyuuki.gsonlib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by haseyuuki on 2016/09/05.
 */
public class ParseJson {
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    private PlaceList placelist1 = new PlaceList();
    private UserList userlist1 = new UserList();

    public PlaceList parsePlaceList(String json) throws JSONException {
        placelist1 = gson.fromJson(json, PlaceList.class);
    //    ArrayList<PlaceMark> Places = new ArrayList<PlaceMark>(placelist1.places);
        return  placelist1;
    }
    public UserList parseUserList(String json) throws JSONException {
        userlist1 = gson.fromJson(json, UserList.class);
        return  userlist1;
    }

}

/*
    他クラスでの使用方法
   ParseJson parseJson = new ParseJson();　　　　　　　//ParseJsonクラスのインスタンス化
   placeList = parseJson.parsePlaceList(str);　　　　　　//Jsonデータのパース
   placeMark = placeList.places.get(0);　　　　　　　　　//Listの0番目のオブジェクトを取得
   textview.setText(String.valueOf((placeMark.floor)));　//表示
*/
