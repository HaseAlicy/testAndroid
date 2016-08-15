package com.example.alicy.timermap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {
    Timer timer;
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   ImageView imageView2 = (ImageView)findViewById(R.id.imageView);
     //   imageView2.setImageResource(R.drawable.figure1);

        timer = new Timer();
        TimerTask timerTask = new MyTimerTask(this);
        timer.scheduleAtFixedRate(timerTask,0,1000);

    }

    public void InvalidateScreen(int kai){
        MyView myview1 = (MyView)findViewById(R.id.myView1);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView);
        if(kai == 5){
               imageView2.setImageResource(R.drawable.figure1);
        }
        myview1.invalidate();//再描画　onDraw()
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
