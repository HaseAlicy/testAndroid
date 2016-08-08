package com.example.alicy.testmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView)this.findViewById(R.id.imageView2);
        Bitmap bitmap = Bitmap.createBitmap(1100,1600,Bitmap.Config.ARGB_8888);
        int i;
        Canvas canvas;
        canvas = new Canvas(bitmap);


        Paint paint;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        canvas.drawCircle(100,680,10,paint);//kaidan1
        for(i=0;i<=15;i++) {
            canvas.drawCircle(100+(i*60), 608, 10, paint);
        }
        canvas.drawCircle(100+((i-5)*60),680,10,paint);//elevetor1
        canvas.drawCircle(100+((i-1)*60),680,10,paint);//kaidan2

        for(i=0;i<=6;i++) {
            canvas.drawCircle(700, 680+(i*60), 10, paint);
        }
        canvas.drawCircle(760,680+(60*6),10,paint);//elevetor2
        canvas.drawCircle(100, 1050, 10, paint);//kaidan3
        for(i=0;i<=15;i++) {
            canvas.drawCircle(100+(i*60), 1110, 10, paint);
        }
        canvas.drawCircle(1000, 1050, 10, paint); //kaidan4


        //canvas.drawText("67.8",90,90,paint);

        imageView.setImageBitmap(bitmap);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
