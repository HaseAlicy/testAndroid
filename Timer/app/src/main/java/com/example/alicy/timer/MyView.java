package com.example.alicy.timer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

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

        int paddingLeft = getPaddingLeft();
        int paddingTop =getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contextWidth = getWidth() - paddingLeft - paddingRight;
        int contextHeight = getHeight() - paddingTop -paddingBottom;

        //background
        Rect r = new Rect(0,0,canvas.getWidth(),canvas.getHeight());
        Paint p = new Paint();
        p.setColor(Color.argb(255,0,0,0));
        canvas.drawRect(r,p);

        Random rnd = new Random();
        int rx = rnd.nextInt(canvas.getWidth());//画面サイズ（横） random座標
        int ry = rnd.nextInt(canvas.getHeight());

        int rr = rnd.nextInt(255); //1~255 random
        int rg = rnd.nextInt(255);
        int rb = rnd.nextInt(255);

        Rect rs = new Rect(rx,ry,rx+32,ry+32);
        Paint ps = new Paint();
        ps.setColor(Color.argb(255,rr,rg,rb));
        canvas.drawRect(rs,ps);
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
