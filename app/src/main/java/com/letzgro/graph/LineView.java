package com.letzgro.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static com.letzgro.graph.MainActivity.points;

public class LineView extends View {

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStopX() {
        return stopX;
    }

    public void setStopX(float stopX) {
        this.stopX = stopX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getStopY() {
        return stopY;
    }

    public void setStopY(float stopY) {
        this.stopY = stopY;
    }

    private float startX;
    private float stopX;
    private float startY;
    private float stopY;

    Paint paintBlack = new Paint();

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs, defstyle);
    }


    public LineView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawLine(getStartX(), getStartY(), getStopX(), getStopY(), paintBlack);
        for (CustomPoint point : points) {
            canvas.drawCircle(point.getX(), point.getY(), 10, point.getPaint());
        }


        invalidate();
    }


}