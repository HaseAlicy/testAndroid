package com.example.haseyuuki.fujitsuchizaihase;

import android.content.Context;

import java.util.TimerTask;
import android.os.Handler;

/**
 * Created by alicy on 2016/08/13.
 */
public class MyTimerTask extends TimerTask {
    private android.os.Handler handler;
    private Context context;

    public MyTimerTask(Context context){
        handler = new android.os.Handler();
        this.context = context;
    }

    @Override
    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run(){
                ((MainActivity)context).InvalidateScreen();
            }
        });
    }

}
