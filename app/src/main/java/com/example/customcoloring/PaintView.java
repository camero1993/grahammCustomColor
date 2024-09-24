package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
/*
    @Author Magnus Graham
    This class PaintView is an extension of the SurfaceView interface.
    It draws a picture of a turtle, a butterfly, a tree, grass, and the sun.
 */
public class PaintView extends SurfaceView {
    private Paint paint;



    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        setWillNotDraw(false);
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.YELLOW); // Set the color of the circle
        paint.setStyle(Paint.Style.FILL); // Fill the circle
        setBackgroundColor(Color.BLUE);
    }

    public void drawSun(Canvas canvas){
        CustomCircle drawSun = new CustomCircle("My Circle", Color.RED, 200, 200, 100);
        drawSun.drawMe(canvas);
    }

    public void drawTree(Canvas canvas) {

        CustomRect treeTrunk = new CustomRect("Tree Trunk", Color.BLACK, 700, 600, 900, 1550);
        treeTrunk.drawMe(canvas);
        CustomCircle leaves = new CustomCircle("Leaves", Color.GREEN, 800, 600,200);
        leaves.drawMe(canvas);
    }

    public void drawTurtle(Canvas canvas) {

        CustomRect turtleBody = new CustomRect("Turtle Body", Color.MAGENTA, 150, 1200, 400, 1300);
        turtleBody.drawMe(canvas);

        CustomRect frontLeg = new CustomRect("Turtle Body", Color.MAGENTA, 150, 1300, 200, 1350);
        frontLeg.drawMe(canvas);

        CustomRect backLeg = new CustomRect("Turtle Body", Color.MAGENTA, 350, 1300, 400, 1350);
        backLeg.drawMe(canvas);

        canvas.drawArc(150, 1050, 400,1350,180,180,false,paint);

        CustomCircle turtleHead = new CustomCircle("Turtle Body", Color.MAGENTA, 420, 1180, 60);
        turtleHead.drawMe(canvas);
    }

    public void drawButterfly(Canvas canvas) {

        CustomCircle butterWingBL = new CustomCircle("Butterfly", Color.YELLOW,260, 680,40);
        butterWingBL.drawMe(canvas);
        CustomCircle butterWingBR = new CustomCircle("Butterfly", Color.YELLOW,340, 680,40);
        butterWingBR.drawMe(canvas);

        CustomCircle butterWingTL = new CustomCircle("Butterfly", Color.YELLOW,250, 615,50);
        butterWingTL.drawMe(canvas);
        CustomCircle butterWingTR = new CustomCircle("Butterfly", Color.YELLOW,350, 615,50);
        butterWingTR.drawMe(canvas);

        CustomRect butterBody = new CustomRect("Butterfly", Color.BLACK, 290, 580, 310, 700);
        butterBody.drawMe(canvas);
    }

    public void drawGrass(Canvas canvas) {
        CustomRect grass = new CustomRect("Grass", Color.GREEN,0,1350,1050,1550);
        grass.drawMe(canvas);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); // Call the superclass method
        drawSun(canvas);
        drawTree(canvas);
        drawGrass(canvas);
        drawTurtle(canvas);
        drawButterfly(canvas);
    }
}
