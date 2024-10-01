package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/*
    @Author Magnus Graham
    This class, PaintView, extends the SurfaceView class.
    It draws a scene with a sun, tree, turtle, butterfly, and grass.
    Each of these elements is drawn using custom graphical components.
 */
public class PaintView extends SurfaceView {
    // Reference to the ColorController for managing color changes
    private ColorController control;

    // Paint object for custom drawing
    private Paint paint;

    /*
    Custom graphical components for different parts of the scene
    */
    private CustomCircle sun;  // Sun component
    private CustomRect treeTrunk;  // Tree trunk component
    private CustomCircle leaves;  // Tree leaves component
    private CustomRect turtleBody, frontLeg, backLeg;  // Turtle body and legs components
    private CustomCircle turtleHead;  // Turtle head component
    private CustomArc turtleShell;  // Turtle shell component
    private CustomCircle butterWingBL, butterWingBR, butterWingTL, butterWingTR;  // Butterfly wings components
    private CustomRect butterBody;  // Butterfly body component
    private CustomRect grass;  // Grass component

    // Setter to link the ColorController to this PaintView
    public void setControl(ColorController control) {
        this.control = control;
    }

    // Getter for the Sun object
    public CustomCircle getSun() {
        return sun;
    }

    // Getters for the Tree components
    public CustomRect getTreeTrunk() {
        return treeTrunk;
    }

    public CustomCircle getTreeLeaves() {
        return leaves;
    }

    // Getters for the Turtle components
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

    // Getters for the Butterfly components
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

    // Getter for the Grass component
    public CustomRect getGrass() {
        return grass;
    }

    // Constructor with context and attribute set, initializing the view and disabling draw optimizations
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();  // Custom initialization method
        setWillNotDraw(false);  // Ensures that onDraw() is called
    }

    // Initializes the Paint object and sets the background color
    private void init() {
        paint = new Paint();
        setBackgroundColor(Color.BLUE);  // Set background color to blue
    }

    // Draw the sun component
    public void drawSun(Canvas canvas) {
        int sunRefX = 200;  // X coordinate for the sun's center
        int sunRefY = 200;  // Y coordinate for the sun's center

        sun = new CustomCircle("Sun", Color.RED, sunRefX, sunRefY, 100);  // Create the sun
        // Update sun color if it is the current element being changed
        if (control.getCurrElem().getName().equals("Sun")) {
            sun.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        sun.drawMe(canvas);  // Draw the sun on the canvas
    }

    // Draw the tree with trunk and leaves
    public void drawTree(Canvas canvas) {
        int treeRefX = 700;  // X coordinate for the tree trunk
        int treeRefY = 600;  // Y coordinate for the tree trunk

        // Create and draw the tree trunk
        treeTrunk = new CustomRect("Tree Trunk", Color.BLACK, treeRefX, treeRefY, treeRefX + 200, treeRefY + 750);
        if (control.getCurrElem().getName().equals("Tree Trunk")) {
            treeTrunk.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        treeTrunk.drawMe(canvas);

        // Create and draw the leaves
        leaves = new CustomCircle("Leaves", Color.GREEN, treeRefX + 100, treeRefY, 200);
        if (control.getCurrElem().getName().equals("Leaves")) {
            leaves.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        leaves.drawMe(canvas);
    }

    // Draw the turtle with body, legs, head, and shell
    public void drawTurtle(Canvas canvas) {
        int turtleRefX = 150;  // X coordinate for the turtle's body
        int turtleRefY = 1200;  // Y coordinate for the turtle's body

        // Create and draw the turtle body
        turtleBody = new CustomRect("Turtle Body", Color.MAGENTA, turtleRefX, turtleRefY, turtleRefX + 250, turtleRefY + 100);
        if (control.getCurrElem().getName().equals("Turtle Body")) {
            turtleBody.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        turtleBody.drawMe(canvas);

        // Create and draw the front leg
        frontLeg = new CustomRect("Turtle Body", Color.MAGENTA, turtleRefX, turtleRefY + 100, turtleRefX + 50, turtleRefY + 150);
        if (control.getCurrElem().getName().equals("Turtle Body")) {
            frontLeg.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        frontLeg.drawMe(canvas);

        // Create and draw the back leg
        backLeg = new CustomRect("Turtle Body", Color.MAGENTA, turtleRefX + 200, turtleRefY + 100, turtleRefX + 250, turtleRefY + 150);
        if (control.getCurrElem().getName().equals("Turtle Body")) {
            backLeg.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        backLeg.drawMe(canvas);

        // Create and draw the turtle shell (arc)
        turtleShell = new CustomArc("Turtle Shell", Color.YELLOW, turtleRefX + 130, turtleRefY, 280, 300, 180, 180);
        if (control.getCurrElem().getName().equals("Turtle Shell")) {
            turtleShell.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        turtleShell.drawMe(canvas);

        // Create and draw the turtle head
        turtleHead = new CustomCircle("Turtle Body", Color.MAGENTA, turtleRefX + 270, turtleRefY - 20, 60);
        if (control.getCurrElem().getName().equals("Turtle Body")) {
            turtleHead.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        turtleHead.drawMe(canvas);
    }

    // Draw the butterfly with its wings and body

    public void drawButterfly(Canvas canvas) {
        // Reference point for the butterfly's position on the canvas
        int butterflyRefX = 250;  // Reference X coordinate
        int butterflyRefY = 580;  // Reference Y coordinate

        // Bottom left wing of the butterfly
        butterWingBL = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX + 10, butterflyRefY + 100, 40);
        // Change the color if the butterfly is the currently selected element
        if (control.getCurrElem().getName() == "Butterfly") {
            butterWingBL.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        // Draw the bottom left wing on the canvas
        butterWingBL.drawMe(canvas);

        // Bottom right wing of the butterfly
        butterWingBR = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX + 90, butterflyRefY + 100, 40);
        // Change the color if the butterfly is the currently selected element
        if (control.getCurrElem().getName() == "Butterfly") {
            butterWingBR.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        // Draw the bottom right wing on the canvas
        butterWingBR.drawMe(canvas);

        // Top left wing of the butterfly
        butterWingTL = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX, butterflyRefY + 35, 50);
        // Change the color if the butterfly is the currently selected element
        if (control.getCurrElem().getName() == "Butterfly") {
            butterWingTL.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        // Draw the top left wing on the canvas
        butterWingTL.drawMe(canvas);

        // Top right wing of the butterfly
        butterWingTR = new CustomCircle("Butterfly", Color.YELLOW,
                butterflyRefX + 100, butterflyRefY + 35, 50);
        // Change the color if the butterfly is the currently selected element
        if (control.getCurrElem().getName() == "Butterfly") {
            butterWingTR.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        // Draw the top right wing on the canvas
        butterWingTR.drawMe(canvas);

        // Body of the butterfly
        butterBody = new CustomRect("Butterfly", Color.BLACK,
                butterflyRefX + 40, butterflyRefY, butterflyRefX + 60, butterflyRefY + 120);
        // (Optional) Uncomment to change body color based on user selection
    /*if (control.getCurrElem().getName() == "Butterfly"){
        butterBody.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
    }*/
        // Draw the butterfly's body on the canvas
        butterBody.drawMe(canvas);
    }

    public void drawGrass(Canvas canvas) {
        // Reference point for the grass's position on the canvas
        int grassRefX = 0;     // Reference X coordinate
        int grassRefY = 1350;  // Reference Y coordinate

        // Create the grass rectangle
        grass = new CustomRect("Grass", Color.GREEN,
                grassRefX, grassRefY, grassRefX + 1050, grassRefY + 200);
        // Change the color if the grass is the currently selected element
        if (control.getCurrElem().getName() == "Grass") {
            grass.setColor(Color.rgb(control.getRed(), control.getGreen(), control.getBlue()));
        }
        // Draw the grass on the canvas
        grass.drawMe(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); // Call the superclass method

        // Draw all components of the scene
        drawSun(canvas);      // Draw the sun
        drawGrass(canvas);    // Draw the grass
        drawTree(canvas);     // Draw the tree
        drawTurtle(canvas);   // Draw the turtle
        drawButterfly(canvas); // Draw the butterfly
    }
}
