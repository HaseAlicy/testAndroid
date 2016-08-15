package com.example.alicy.pinchinoutsample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by alicy on 2016/08/15.
 */
public class MyView extends View {
    private static final int RECT_SIZE = 64;

    private float mScale = 1.0f;
    private ScaleGestureDetector mScaleDetector;

    private Paint mRectPaint = new Paint();
    private Paint mTextPaint = new Paint();

    {
    mRectPaint.setStyle(Paint.Style.STROKE);
    mRectPaint.setColor(Color.BLUE);
    mRectPaint.setStrokeWidth(2.0f);

    mTextPaint.setTextSize(64.0f);
    }

    public MyView(Context context) {
        super(context);

        mScaleDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                Log.d("MyView", "MyView.OnScale factor:" + detector.getScaleFactor());
                mScale *= detector.getScaleFactor();
                invalidate();
                return true;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                Log.d("MyView", "MyView.onScaleBegin");
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
                Log.d("MyView", "MyView.onScaleEnd");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mScaleDetector.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //現在の表示倍率を表示
        canvas.drawText("Scale" + mScale, 0, 72, mTextPaint);

        //正方形のいっぺんの長さを求める
        float rectSize = RECT_SIZE * mScale;

        //描画位置をViewの中心にする
        float left = getWidth() / 2 - rectSize / 2;
        float top = getHeight() / 2 - rectSize / 2;
        float bottom = top + rectSize;
        float right = left + rectSize;

        canvas.drawRect(left, top, right, bottom, mRectPaint);
    }
}


