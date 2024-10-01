package com.example.customcoloring;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.view.SurfaceView;
        import android.util.AttributeSet;

public class ColorElemView extends SurfaceView {

    private int currentColor = Color.BLACK;  // Default color

    //ColorController handler;
    public ColorElemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); // Call the superclass method

        // Fill the entire canvas with current color
        canvas.drawColor(currentColor);
    }

    public void setColor(int color) {
        this.currentColor = color;  // Update the current color
        invalidate();  // Trigger a redraw
    }
}
