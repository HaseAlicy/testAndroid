package com.example.haseyuuki.fujitsuchizaihase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

/**
 * 地図表示系
 * Created by alicy on 2016/08/13.
 */
public class MyView extends View {
    private String mExampleString;
    private int mExampleColor = Color.RED;
    private float mExampleDimension = 0;
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    private  int i=0;
    private static int countX = 0;//genzaichi X
    private static int countY = 0;//genzaichi Y
    private static int id=0;//genzaiti muki sikibetusi
    private static int px,py;//xy position
    private static int storey=5;// kai

    Paint paint = new Paint();

    public MyView(Context context){
        super(context);
        init(null,0);
    }

    public MyView(Context context,AttributeSet attrs){
        super(context,attrs);
        init(attrs,0);
    }

    private void init(AttributeSet attrs,int deStyle){

    }

    private void invalidateTextPaintAndMeasurements(){
        mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setTextSize(mExampleDimension);
        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;
    }

    @Override
    protected void onDraw(Canvas canvas){

        super.onDraw(canvas);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        //drawMapping(MainActivity.fujitsuAPI.lightList.lights.get(0).x,MainActivity.fujitsuAPI.lightList.lights.get(0).y , canvas);

     if(MainActivity.routeSearch) {
         //   canvas.drawCircle((int)(65),(int)(160),8,paint);
        /*Place*/
         drawMapping(380, 315, canvas);//id:63
         drawMapping(590, 315, canvas);
         drawMapping(925, 315, canvas);
         drawMapping(1340, 315, canvas);
         drawMapping(1770, 315, canvas);
         drawMapping(2310, 315, canvas);
         drawMapping(2740, 315, canvas);
         drawMapping(3040, 315, canvas);
         drawMapping(3250, 315, canvas);//id:71

         drawMapping(610, 3295, canvas);//id:72
         drawMapping(1040, 3295, canvas);
         drawMapping(1510, 3295, canvas);
         drawMapping(1930, 3295, canvas);
         drawMapping(2260, 3295, canvas);
         drawMapping(2500, 3295, canvas);
         drawMapping(2655, 3295, canvas);
         drawMapping(2810, 3295, canvas);
         drawMapping(2965, 3295, canvas);
         drawMapping(3125, 3295, canvas);
         drawMapping(3280, 3295, canvas);//id:82


         paint.setColor(Color.RED);
        /*Light*/
         drawMapping(210, 558, canvas);//id:1
         drawMapping(310, 558, canvas);
         drawMapping(455, 558, canvas);
         drawMapping(600, 558, canvas);
         drawMapping(745, 558, canvas);
         drawMapping(890, 558, canvas);
         drawMapping(1035, 558, canvas);
         drawMapping(1180, 558, canvas);
         drawMapping(1325, 558, canvas);
         drawMapping(1470, 558, canvas);
         drawMapping(1615, 558, canvas);
         drawMapping(1760, 558, canvas);
         drawMapping(1905, 558, canvas);
         drawMapping(2050, 558, canvas);
         drawMapping(2195, 558, canvas);
         drawMapping(2340, 558, canvas);
         drawMapping(2485, 558, canvas);
         drawMapping(2630, 558, canvas);
         drawMapping(2775, 558, canvas);
         drawMapping(2920, 558, canvas);
         drawMapping(3065, 558, canvas);
         drawMapping(3210, 558, canvas);//id:22

         drawMapping(210, 3065, canvas);//id:23
         drawMapping(310, 3065, canvas);
         drawMapping(455, 3065, canvas);
         drawMapping(600, 3065, canvas);
         drawMapping(745, 3065, canvas);
         drawMapping(890, 3065, canvas);
         drawMapping(1035, 3065, canvas);
         drawMapping(1180, 3065, canvas);
         drawMapping(1325, 3065, canvas);
         drawMapping(1470, 3065, canvas);
         drawMapping(1615, 3065, canvas);
         drawMapping(1760, 3065, canvas);
         drawMapping(1905, 3065, canvas);
         drawMapping(2050, 3065, canvas);
         drawMapping(2195, 3065, canvas);
         drawMapping(2340, 3065, canvas);
         drawMapping(2485, 3065, canvas);
         drawMapping(2630, 3065, canvas);
         drawMapping(2775, 3065, canvas);
         drawMapping(2920, 3065, canvas);
         drawMapping(3065, 3065, canvas);
         drawMapping(3210, 3065, canvas);//id:44

         drawMapping(2048, 680, canvas);//id:45
         drawMapping(2048, 780, canvas);
         drawMapping(2048, 880, canvas);
         drawMapping(2048, 1012, canvas);
         drawMapping(2048, 1157, canvas);
         drawMapping(2048, 1302, canvas);
         drawMapping(2048, 1447, canvas);
         drawMapping(2048, 1592, canvas);
         drawMapping(2048, 1737, canvas);
         drawMapping(2048, 1882, canvas);
         drawMapping(2048, 2027, canvas);
         drawMapping(2048, 2172, canvas);
         drawMapping(2048, 2317, canvas);
         drawMapping(2048, 2462, canvas);
         drawMapping(2048, 2607, canvas);
         drawMapping(2048, 2740, canvas);
         drawMapping(2048, 2940, canvas);
         drawMapping(2048, 680, canvas);
     }

    }

    public void drawMapping(int x,int y,Canvas canvas){
        canvas.drawCircle((int)(x/3.506153),(int)(y/3.47875),8,paint);
    }

    public void setStorey(int exampleStorey){
        storey = exampleStorey;
    }

    public int showStorey(){
        return storey;
    }

    public void setExampleString(String exampleString){
        mExampleString = exampleString;
        invalidateTextPaintAndMeasurements();
    }

    public Drawable getExampleDrawable(){
        return mExampleDrawable;
    }

    public void setExampleDrawable(Drawable exampleDrawable){
        mExampleDrawable = exampleDrawable;
    }

}
