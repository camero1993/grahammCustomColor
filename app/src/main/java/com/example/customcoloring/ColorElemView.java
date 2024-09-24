package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;
import android.util.AttributeSet;

public class ColorElemView extends SurfaceView {

    //ColorController handler;
    public ColorElemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); // Call the superclass method

        // Fill the entire canvas with red color
        canvas.drawColor(Color.RED);
    }
}
