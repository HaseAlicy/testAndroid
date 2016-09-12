package com.example.haseyuuki.fujitsuchizaihase;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.ColorUtils;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.NotActiveException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private boolean getAPI = false;
    public  static boolean routeSearch = true;
    private int userId = -1;
    private int floor = 6;
    private Countries countries;
    public static FujitsuAPI fujitsuAPI = new FujitsuAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if(userId < 0){
            //User登録画面へ遷移する処理
            userId = 1;
            countries = Countries.Japan;
        }

        if(getAPI == false){
            GetAPI();
            getAPI = true;
        }

/*
        //校内図表示
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView);
        Resources res = getResources();
        Bitmap bitmap = null;
        switch(floor){
            case 1:
               // bitmap = BitmapFactory.decodeResource(res, R.drawable.map1);
                break;
            case 2:
              //  bitmap = BitmapFactory.decodeResource(res, R.drawable.map2);
                break;
            case 3:
              //  bitmap = BitmapFactory.decodeResource(res, R.drawable.map3);
                break;
            case 4:
              //  bitmap = BitmapFactory.decodeResource(res, R.drawable.map4);
                break;
            case 5:
                bitmap = BitmapFactory.decodeResource(res, R.drawable.map5);
                break;
            case 6:
                bitmap = BitmapFactory.decodeResource(res, R.drawable.map6);
                break;
            case 7:
                bitmap = BitmapFactory.decodeResource(res, R.drawable.map7);
                break;
            default:
                bitmap = BitmapFactory.decodeResource(res, R.drawable.sao);
                break;
        }
        Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap,3436,3616,false);
        imageView2.setImageBitmap(bitmap2);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
*/
        Button btnDisp = (Button)findViewById(R.id.button2);
        btnDisp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 登録画面へ遷移
                Intent intent = new Intent(getApplication(), DebugPage.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, RouteSearchActivity.class);
            try {
                startActivity(intent);
                Log.d("onClick","intent");
            }
            catch(NullPointerException e){
                Log.d("onClick","Exception");
            }

        }

        else if (id == R.id.nav_setting) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, RouteSearchActivity.class);
            try {
                startActivity(intent);
                Log.d("onClick","intent");
            }
            catch(NullPointerException e){
                Log.d("onClick","Exception");
            }

        }
          /*else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

    public void InvalidateScreen(){
        /*
        int kai;
        MyView myview1 = (MyView)findViewById(R.id.myView1);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView);
        kai = myview1.showStorey();
        if(kai == 5){
            imageView2.setImageResource(R.drawable.figure1);
        }
        else if(kai == 4){
            imageView2.setImageResource(R.drawable.test);
        }
        myview1.invalidate();//再描画　onDraw()
        */
    }


}
