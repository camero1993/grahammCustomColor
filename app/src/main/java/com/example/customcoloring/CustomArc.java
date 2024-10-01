package com.example.customcoloring;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.example.customcoloring.CustomElement;

public class CustomArc extends CustomElement {
    /**
     * <!-- class com.example.customcoloring.com.example.customcoloring.CustomArc -->
     *
     * This class defines a custom drawing element that is an arc, based off
     *Professor Nux's code for CustomCircle
     *
     * @author Magnus Graham
     * @version Spring 2024
     * @see CustomElement
     *
     */

    /** these variables define the location and dimensions of an arc */
    private int x;
    private int y;
    private int width;
    private int height;
    private float startAngle;
    private float sweepAngle;

    /** the arc's dimensions must be defined at construction */
    public CustomArc(String name, int color, int x, int y, int width, int height, float startAngle, float sweepAngle) {
        super(name, color);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
    }

@Override
public void drawMe(Canvas canvas) {
    // Create a RectF object to define the bounds of the arc
    RectF rectF = new RectF(x - width / 2, y - height / 2, x + width / 2, y + height / 2);
    canvas.drawArc(rectF, startAngle, sweepAngle, true, myPaint);  // Draw the arc
    canvas.drawArc(rectF, startAngle, sweepAngle, true, outlinePaint);  // Outline around the arc
}

/** Check if a point is within the bounding box of the arc
 *  Could be more accurate, but serves its purpose
 *
 * */
    @Override
    public boolean containsPoint(int x, int y) {
        // Calculate the distance to the center of the bounding rectangle
        int xDist = Math.abs(x - this.x);
        int yDist = Math.abs(y - this.y);
        return (xDist < width / 2 + TAP_MARGIN) && (yDist < height / 2 + TAP_MARGIN);
    }

}
