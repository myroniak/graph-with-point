package com.letzgro.graph;

import android.graphics.Paint;

/**
 * Created by bomko on 24.10.16.
 */

public class CustomPoint {

    public float getX() {
        return mX;
    }

    public float getY() {
        return mY;
    }

    private float mX;
    private float mY;

    public Paint getPaint() {
        return mPaint;
    }

    private Paint mPaint;

    CustomPoint(float x, float y, Paint paint) {
        mX = x;
        mY = y;
        mPaint = paint;
    }
}
