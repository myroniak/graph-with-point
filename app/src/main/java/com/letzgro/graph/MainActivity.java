package com.letzgro.graph;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

import static com.letzgro.graph.R.id.linechart;


public class MainActivity extends AppCompatActivity {
    LineView graph;
    Paint mPaint, mPaintRed, mPaintBlue;
    public static List<CustomPoint> points;

    float startPoint = 10;
    float endPoint;

    float count = 5;
    float averageSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = new ArrayList<CustomPoint>();
        graph = (LineView) findViewById(linechart);

        mPaint = new Paint();
        mPaintRed = new Paint();
        mPaintBlue = new Paint();
        mPaintBlue.setColor(Color.BLUE);

        mPaint.setColor(Color.GREEN);
        mPaintRed.setColor(Color.RED);

        ViewTreeObserver vto = graph.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                float width = graph.getWidth();

                graph.setStartX(0);
                graph.setStartY(100);
                graph.setStopY(100);
                graph.setStopX(width);

                Log.d("myLog", "size: " + width);
                averageSize = width / (count - 1);
                endPoint = width - 10;

            }
        });


        (findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                points = new ArrayList<CustomPoint>();
                points.add(new CustomPoint(startPoint, 100, mPaint));
                points.add(new CustomPoint(endPoint, 100, mPaintRed));

            }
        });

        (findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                points = new ArrayList<CustomPoint>();
                points.add(new CustomPoint(startPoint, 100, mPaint));
                points.add(new CustomPoint(averageSize * 2, 100, mPaintBlue));
                points.add(new CustomPoint(endPoint, 100, mPaintRed));

            }
        });

        (findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                points = new ArrayList<CustomPoint>();
                points.add(new CustomPoint(startPoint, 100, mPaint));
                points.add(new CustomPoint(averageSize, 100, mPaintBlue));
                points.add(new CustomPoint(averageSize * 2, 100, mPaintBlue));
                points.add(new CustomPoint(averageSize * 3, 100, mPaintBlue));
                points.add(new CustomPoint(endPoint, 100, mPaintRed));
            }
        });

    }
}
