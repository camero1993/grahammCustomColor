package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
/*
    @Author Magnus Graham
    This class PaintView is an extension of the SurfaceView interface.
    It draws a picture of a turtle, a butterfly, a tree, grass, and the sun.
 */
public class PaintView extends SurfaceView {
    private ColorController control;
    private Paint paint;
    /*
    Sun components
     */
    private CustomCircle sun;

    /*
    Tree components
     */
    private CustomRect treeTrunk;
    private CustomCircle leaves;

    /*
    Turtle components
     */
    private CustomRect turtleBody;
    private CustomRect frontLeg;
    private CustomRect backLeg;
    private CustomCircle turtleHead;
    private CustomArc turtleShell;

    /*
    Butterfly components
     */
    private CustomCircle butterWingBL;
    private CustomCircle butterWingBR;
    private CustomCircle butterWingTL;
    private CustomCircle butterWingTR;
    private CustomRect butterBody;

    /*
     Grass component
     */
    private CustomRect grass;

    public void setControl(ColorController control) {
        this.control = control;
    }

    // Getter for Sun
    public CustomCircle getSun() {
        return sun;
    }

    /*
    Getter for Tree components
     */
    public CustomRect getTreeTrunk() {
        return treeTrunk;
    }

    public CustomCircle getTreeLeaves() {
        return leaves;
    }

    /*
    Getter for Turtle components
     */
    public CustomRect getTurtleBody() {
        return turtleBody;
    }

    public CustomRect getTurtleFrontLeg() {
        return frontLeg;
    }

    public CustomRect getTurtleBackLeg() {
        return backLeg;
    }

    public CustomCircle getTurtleHead() {
        return turtleHead;
    }

    public CustomArc getTurtleShell() {
        return turtleShell;
    }

    /*
    Getter for Butterfly components
     */
    public CustomCircle getButterflyWingBL() {
        return butterWingBL;
    }
    public CustomCircle getButterflyWingBR() {
        return butterWingBR;
    }
    public CustomCircle getButterflyWingTL() {
        return butterWingTL;
    }
    public CustomCircle getButterflyWingTR() {
        return butterWingTR;
    }
    public CustomRect getButterflyBody() {
        return butterBody;
    }
    /*
    Getter for Grass
     */
    public CustomRect getGrass() {
        return grass;
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        setWillNotDraw(false);
    }

    private void init() {
        paint = new Paint();
        setBackgroundColor(Color.BLUE);
    }


    public void drawSun(Canvas canvas) {
        //reference point for sun
        int sunRefX = 200;  // Reference X coordinate
        int sunRefY = 200;  // Reference Y coordinate

        sun = new CustomCircle("Sun", Color.RED,
                sunRefX, sunRefY, 100);
        if (control.getCurrElem().getName() == "Sun"){
            Log.d("CE","sun is curelem");
            sun.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        sun.drawMe(canvas);
    }

    public void drawTree(Canvas canvas) {
        // reference point for tree
        int treeRefX = 700;  // Reference X coordinate
        int treeRefY = 600;  // Reference Y coordinate

        // Draw tree trunk relative to the reference point
        treeTrunk = new CustomRect("Tree Trunk", Color.BLACK,
                treeRefX, treeRefY, treeRefX + 200, treeRefY + 750); // Width: 200, Height: 750
        if (control.getCurrElem().getName() == "Tree Trunk"){
            treeTrunk.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }

        treeTrunk.drawMe(canvas);

        // Draw tree leaves relative to the reference point
        leaves = new CustomCircle("Leaves", Color.GREEN,
                treeRefX + 100, treeRefY, 200);  // Center is offset by 100 px from the trunk
        if (control.getCurrElem().getName() == "Leaves"){
            leaves.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        leaves.drawMe(canvas);
    }


    public void drawTurtle(Canvas canvas) {
        // reference point for the turtle
        int turtleRefX = 150;  // Reference X coordinate
        int turtleRefY = 1200; // Reference Y coordinate

        // Turtle Body
        turtleBody = new CustomRect("Turtle Body", Color.MAGENTA,
                turtleRefX, turtleRefY, turtleRefX + 250, turtleRefY + 100);
        if (control.getCurrElem().getName() == "Turtle Body"){
            turtleBody.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }

        turtleBody.drawMe(canvas);

        // Front Leg
        frontLeg = new CustomRect("Turtle Body", Color.MAGENTA,
                turtleRefX, turtleRefY + 100, turtleRefX + 50, turtleRefY + 150);
        if (control.getCurrElem().getName() == "Turtle Body"){
            frontLeg.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        frontLeg.drawMe(canvas);

        // Back Leg
        backLeg = new CustomRect("Turtle Body", Color.MAGENTA,
                turtleRefX + 200, turtleRefY + 100, turtleRefX + 250, turtleRefY + 150);
        if (control.getCurrElem().getName() == "Turtle Body"){
            backLeg.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        backLeg.drawMe(canvas);

        // Draw an arc for the shell
        turtleShell = new CustomArc("Turtle Shell", Color.YELLOW,
                turtleRefX + 130, turtleRefY, 280, 300, 180, 180);
        if (control.getCurrElem().getName() == "Turtle Shell"){
            turtleShell.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        turtleShell.drawMe(canvas);

        // Turtle Head
        turtleHead = new CustomCircle("Turtle Body", Color.MAGENTA,
                turtleRefX + 270, turtleRefY - 20, 60);
        if (control.getCurrElem().getName() == "Turtle Body"){
            turtleHead.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        turtleHead.drawMe(canvas);
    }

    public void drawButterfly(Canvas canvas) {
        // reference point for the butterfly
        int butterflyRefX = 250;  // Reference X coordinate
        int butterflyRefY = 580;  // Reference Y coordinate

        // Bottom of Left Wing
        butterWingBL = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX + 10, butterflyRefY + 100, 40);
        if (control.getCurrElem().getName() == "Butterfly"){
            butterWingBL.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        butterWingBL.drawMe(canvas);

        // Bottom of Right Wing
        butterWingBR = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX + 90, butterflyRefY + 100, 40);
        if (control.getCurrElem().getName() == "Butterfly"){
            butterWingBR.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        butterWingBR.drawMe(canvas);

        // Top of Left Wing
        butterWingTL = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX, butterflyRefY + 35, 50);
        if (control.getCurrElem().getName() == "Butterfly"){
            butterWingTL.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        butterWingTL.drawMe(canvas);

        // Top of Right Wing
        butterWingTR = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX + 100, butterflyRefY + 35, 50);
        if (control.getCurrElem().getName() == "Butterfly"){
            butterWingTR.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        butterWingTR.drawMe(canvas);

        // Butterfly Body
        butterBody = new CustomRect("Butterfly", Color.BLACK,
                butterflyRefX + 40, butterflyRefY, butterflyRefX + 60, butterflyRefY + 120);
        /*if (control.getCurrElem().getName() == "Butterfly"){
            butterBody.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }*/
        butterBody.drawMe(canvas);
    }

    public void drawGrass(Canvas canvas) {
        // reference point for the grass
        int grassRefX = 0;     // Reference X coordinate
        int grassRefY = 1350;  // Reference Y coordinate

        // Grass
        grass = new CustomRect("Grass", Color.GREEN,
                grassRefX, grassRefY, grassRefX + 1050, grassRefY + 200);
        if (control.getCurrElem().getName() == "Grass"){
            grass.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        grass.drawMe(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); // Call the superclass method

        drawSun(canvas);
        drawGrass(canvas);
        drawTree(canvas);
        drawTurtle(canvas);
        drawButterfly(canvas);

    }
}
