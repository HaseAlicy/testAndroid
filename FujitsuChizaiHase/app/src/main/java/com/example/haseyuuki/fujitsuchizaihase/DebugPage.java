package com.example.haseyuuki.fujitsuchizaihase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by TAKUYA on 2016/09/11.
 */
public class DebugPage  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugpage);


        Button btnregit = (Button)findViewById(R.id.button_regit);
        btnregit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 登録画面へ遷移
                Intent intent = new Intent(getApplication(), UserRegist.class);
                startActivity(intent);
            }
        });
        Button btnqr = (Button)findViewById(R.id.button_qr);
        btnqr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 登録画面へ遷移
                Intent intent = new Intent(getApplication(), QRReader.class);
                startActivity(intent);
            }
        });


    }


}
