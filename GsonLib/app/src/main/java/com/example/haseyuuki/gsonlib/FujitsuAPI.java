package com.example.haseyuuki.gsonlib;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

/**
 * 富士通知財のAPIを扱うクラス　GET関係のみを記載しています
 * Created by haseyuuki on 2016/09/06.
 */
public class FujitsuAPI {
    private String json;
    public Light light;
    public LightList lightList;
    public User user;
    public UserList userList;
    public PlaceMark placeMark;
    public PlaceList placeList;


    /*User API*/
    //指定されたIDからユーザ情報を取得
    public void userPoint(int id){
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/users/" + String.valueOf(id);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    user = parseJson.parseUser(json);
                    Log.d("onPostExecute:UserAPI","User Point Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();

    }

    //すべてのユーザのユーザ情報をリストで取得
    public void userAll(){
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/users";
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    userList = parseJson.parseUserList(json);
                    Log.d("onPostExecute:UserAPI","User All Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }



    /*Place API*/
    //指定されたIDから場所情報を取得
    public void placePoint(int id){
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/places/" + String.valueOf(id);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    placeMark = parseJson.parsePlace(json);
                    Log.d("onPostExecute:PlaceAPI","Place Point Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();

    }

    //すべての照明光IDの照明情報をリストを取得
    public void placeAll(){
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/places";
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    placeList = parseJson.parsePlaceList(json);
                    Log.d("onPostExecute:PlaceAPI","Place All Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //キーワードで曖昧検索した場所情報を取得
    public void placeKeyword(String keyword){
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/places?keyword="+keyword;
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    placeList = parseJson.parsePlaceList(json);
                    Log.d("onPostExecute:PlaceAPI","Place Keyword Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //指定した座標(x,y)、階(floor)の半径radiusの場所情報リストを取得
    public void placeSearch(int x,int y,int floor,int radius){
        //final String url ="http://fujitsu-chizai.azurewebsites.net/api/places?x=890&y=558&floor=6&radius=1000";
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/places?x=" + String.valueOf(x) + "&y=" + String.valueOf(y) + "&floor=" + String.valueOf(floor) + "&radius=" + String.valueOf(radius);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    placeList = parseJson.parsePlaceList(json);
                    Log.d("onPostExecute:PlaceAPI","Place Search Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //指定した座標(x,y)、階(floor)の半径radiusの場所情報リストからキーワードで曖昧検索した結果のアンドを取得
    public void placeSearchAndKeyword(String keyword,int x,int y,int floor,int radius){
        //final String url ="http://fujitsu-chizai.azurewebsites.net/api/places?x=890&y=558&floor=6&radius=1000";
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/places?keyword="+ keyword +"&x=" + String.valueOf(x) + "&y=" + String.valueOf(y) + "&floor=" + String.valueOf(floor) + "&radius=" + String.valueOf(radius);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    placeList = parseJson.parsePlaceList(json);
                    Log.d("onPostExecute:PlaceAPI","Place SearchAndKeyword Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //指定した階数のすべての場所情報を取得
    public void placeFloor(int floor){
        //final String url ="http://fujitsu-chizai.azurewebsites.net/api/places?floor=6";
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/places?floor=" + String.valueOf(floor);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    placeList = parseJson.parsePlaceList(json);
                    Log.d("onPostExecute:PlaceAPI","Place Floor Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }



    /*Light API*/
    //指定された照明光IDに一致する照明情報を取得
    public void lightPoint(int id){
        // final String url = "http://fujitsu-chizai.azurewebsites.net/api/lights/601";
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/lights/" + String.valueOf(id);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    light = parseJson.parseLight(json);
                    Log.d("onPostExecute:LightAPI","Light Point Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //すべての照明光IDの照明情報をリストを取得
    public void lightAll(){
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/lights";
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    lightList = parseJson.parseLightList(json);
                    Log.d("onPostExecute:LightAPI","Light All Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //指定した座標(x,y)、階(floor)の半径radiusの照明情報リストを取得
    public void lightSearch(int x,int y,int floor,int radius){
        //final String url ="http://fujitsu-chizai.azurewebsites.net/api/lights?x=890&y=558&floor=6&radius=1000";
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/lights?x=" + String.valueOf(x) + "&y=" + String.valueOf(y) + "&floor=" + String.valueOf(floor) + "&radius=" + String.valueOf(radius);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    lightList = parseJson.parseLightList(json);
                    Log.d("onPostExecute:LightAPI","Light Search Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }

    //指定した階数のすべての照明情報を取得
    public void lightFloor(int floor){
        //final String url ="http://fujitsu-chizai.azurewebsites.net/api/lights?floor=6";
        final String url = "http://fujitsu-chizai.azurewebsites.net/api/lights?floor=" + String.valueOf(floor);
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                HttpJson httpJson = new HttpJson();
                json = httpJson.Get(url);
                Log.d("doIn",json);
                return null;
            }

            @Override
            protected void onPostExecute(Void result){
                try {
                    ParseJson parseJson = new ParseJson();
                    lightList = parseJson.parseLightList(json);
                    Log.d("onPostExecute:LightAPI","Light Floor Parse Json OK");
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        task.execute();
    }


}
