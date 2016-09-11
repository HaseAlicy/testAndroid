package com.example.haseyuuki.fujitsuchizaihase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by TAKUYA on 2016/09/11.
 */
public class UserRegistFin  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistfin);



        Button btnHome = (Button)findViewById(R.id.homebutton);  //ホーム画面に戻る
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ホーム画面に戻る
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
