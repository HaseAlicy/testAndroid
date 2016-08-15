package com.example.alicy.timermap;

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

        if(countX < 540 ) {
            countX += 60;
            id = 0;
        }
        else{
            if(countY <  360){
                if(countY==0) {
                    countY += 30;
                    id = 1;
                }else{
                        countY += 60;
                }
            }
            else {
                if(id != 0) {
                    id = 0;
                    countX += 60;
                }
            }
        }

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        canvas.drawCircle(100,600,10,paint);//kaidan1
        for(i=0;i<=14;i++) {
            canvas.drawCircle(100+(i*60), 545, 10, paint);
        }
        canvas.drawCircle(100+((i-5)*60),605,10,paint);//elevetor1
        canvas.drawCircle(100+((i-2)*60),605,10,paint);//kaidan2

        for(i=0;i<=6;i++) {
            canvas.drawCircle(640, 605+(i*60), 10, paint);
        }
        canvas.drawCircle(700,580+(60*6),10,paint);//elevetor2
        canvas.drawCircle(100, 940, 10, paint);//kaidan3
        for(i=0;i<15;i++) {
            canvas.drawCircle(100+(i*60), 996, 10, paint);
        }
        canvas.drawCircle(880, 940, 10, paint); //kaidan4


        //DrawLine keiro
        int c=680;
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        canvas.drawLine(700,605,640,605,paint);
        canvas.drawLine(640,605,640,1000,paint);
        canvas.drawLine(640,996,100,996,paint);
        //canvas.drawText("67.8",90,90,paint);

        //basyo idou



        //gennzaiti
        int px=100+countX;
        int py=996-countY;
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(px, py, 15, paint);//genzaiti
        if(id == 0) {
            canvas.drawLine(px, py, px + 33, py, paint);//migi
        }else if(id == 1){
            canvas.drawLine(px,py,px,py-33,paint);//hidari
        }else if(id == 2){
            canvas.drawLine(px,py,px-33,py,paint);//ue
        }else{
            canvas.drawLine(px,py,px,py+33,paint);//sita
        }

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
