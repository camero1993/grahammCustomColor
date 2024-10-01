package com.example.customcoloring;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    // View objects for managing color and drawing
    private ColorElemView Cview; // For updating the color element view
    private PaintView Pview;     // For managing the canvas where shapes are drawn

    // Current color and seekbars for controlling RGB values
    private int currcolor;
    private SeekBar redSeekbar, greenSeekbar, blueSeekbar;

    // TextView to display the current element's name
    private TextView tview;

    // Flag to track if the user is interacting with the UI
    private Boolean userAction = false;

    // Default element (used when no specific element is selected)
    public final CustomElement defaultElem = new CustomCircle("None", 0, 0, 0, 0);
    private CustomElement CurrElem = defaultElem; // Currently selected element

    // Getter method for the current element
    public CustomElement getCurrElem() {
        return CurrElem;
    }

    // Constructor to initialize views and seekbars
    public ColorController(PaintView Pview, ColorElemView Cview, TextView tview,
                           SeekBar seekRed, SeekBar seekGreen, SeekBar seekBlue) {
        this.Pview = Pview;
        this.Cview = Cview;
        this.tview = tview;
        this.redSeekbar = seekRed;
        this.greenSeekbar = seekGreen;
        this.blueSeekbar = seekBlue;
    }

    // Getter methods for individual RGB components from seekbars
    public int getRed() {
        return redSeekbar.getProgress();
    }

    public int getGreen() {
        return greenSeekbar.getProgress();
    }

    public int getBlue() {
        return blueSeekbar.getProgress();
    }

    // Method to update the color of the selected element based on the seekbar progress
    private void updateColor(CustomElement elem, int color, SeekBar seekBar) {

        // If the red seekbar is changed, update the red component of the element's color
        if (seekBar == redSeekbar) {
            Log.d("update", elem.getName() + " New Color: " + color);
            elem.setColor(Color.rgb(color, Color.green(elem.getColor()), Color.blue(elem.getColor())), Pview);
            Log.d("ColorUpdate", "Element color after update: " + elem.getColor());
            Cview.setColor(Color.rgb(Color.red(CurrElem.getColor()), Color.green(CurrElem.getColor()), Color.blue(CurrElem.getColor())));
        }
        // If the green seekbar is changed, update the green component of the element's color
        else if (seekBar == greenSeekbar) {
            Log.d("update", elem.getName() + " New Color: " + color);
            elem.setColor(Color.rgb(Color.red(elem.getColor()), color, Color.blue(elem.getColor())), Pview);
            Log.d("ColorUpdate", "Element color after update: " + elem.getColor());
            Cview.setColor(Color.rgb(Color.red(CurrElem.getColor()), Color.green(CurrElem.getColor()), Color.blue(CurrElem.getColor())));
        }
        // If the blue seekbar is changed, update the blue component of the element's color
        else if (seekBar == blueSeekbar) {
            Log.d("update", elem.getName() + " New Color: " + color);
            elem.setColor(Color.rgb(Color.red(elem.getColor()), Color.green(elem.getColor()), color), Pview);
            Log.d("ColorUpdate", "Element color after update: " + elem.getColor() + " " + elem.getName());
            Cview.setColor(Color.rgb(Color.red(CurrElem.getColor()), Color.green(CurrElem.getColor()), Color.blue(CurrElem.getColor())));
        }
    }

    // Method triggered when the seekbar progress is changed
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // Change the color of the selected element based on the seekbar progress
        Pview.getSun().setColor(Color.BLACK); // (Example change, could be adjusted)
        updateColor(CurrElem, i, seekBar); // Update color of the currently selected element
        Pview.invalidate(); // Redraw the PaintView to reflect color change
    }

    // Getter for the current color
    public int getColor() {
        return this.currcolor;
    }

    // Method called when the user starts interacting with the seekbar
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.d("changecolor", CurrElem + " true"); // Log start of color change
    }

    // Method called when the user stops interacting with the seekbar
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        CurrElem.changeColor = false; // Reset color change flag
        Log.d("changecolor", CurrElem + " false"); // Log end of color change
    }

    // Method to display the current element's name and update the seekbars
    public void displayElement(CustomElement elem, TextView tview, SeekBar seekRed, SeekBar seekBlue, SeekBar seekGreen) {
        Log.i("display", "Displaying element " + elem.getName()); // Log the selected element
        tview.setText(elem.getName()); // Update the TextView with the element's name
        seekRed.setProgress(Color.red(elem.getColor())); // Update the red seekbar with the element's red value
        seekBlue.setProgress(Color.blue(elem.getColor())); // Update the blue seekbar with the element's blue value
        seekGreen.setProgress(Color.green(elem.getColor())); // Update the green seekbar with the element's green value
        CurrElem = elem; // Set the currently selected element
        Log.d("update1", "CurrElem " + CurrElem.getName());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // Get the x and y coordinates of the user's touch on the view
        Pview.invalidate(); // Redraw the view to reflect any changes
        int x = (int) motionEvent.getX(); // X-coordinate of the touch
        int y = (int) motionEvent.getY(); // Y-coordinate of the touch

        // Check if the touch is within the Sun element
        if (Pview.getSun().containsPoint(x, y)) {
            // Display the Sun's properties in the UI (color sliders and text view)
            displayElement(Pview.getSun(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getSun(); // Set the Sun as the currently selected element
        }

        // Check if the touch is within the Tree components (leaves or trunk)

        else if (Pview.getTreeLeaves().containsPoint(x, y)) {
            // Display the Tree leaves' properties in the UI
            displayElement(Pview.getTreeLeaves(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTreeLeaves(); // Set the Tree leaves as the currently selected element
        } else if (Pview.getTreeTrunk().containsPoint(x, y)) {
            // Display the Tree trunk's properties in the UI
            displayElement(Pview.getTreeTrunk(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTreeTrunk(); // Set the Tree trunk as the currently selected element
        }

        // Check if the touch is within the Turtle components (head, body, legs, shell)

        else if (Pview.getTurtleHead().containsPoint(x, y)) {
            // Display the Turtle head's properties in the UI
            displayElement(Pview.getTurtleHead(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleHead(); // Set the Turtle head as the currently selected element
        } else if (Pview.getTurtleBody().containsPoint(x, y)) {
            // Display the Turtle body's properties in the UI
            displayElement(Pview.getTurtleBody(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleBody(); // Set the Turtle body as the currently selected element
        } else if (Pview.getTurtleFrontLeg().containsPoint(x, y)) {
            // Display the Turtle's front leg properties in the UI
            displayElement(Pview.getTurtleFrontLeg(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleFrontLeg(); // Set the Turtle front leg as the currently selected element
        } else if (Pview.getTurtleBackLeg().containsPoint(x, y)) {
            // Display the Turtle's back leg properties in the UI
            displayElement(Pview.getTurtleBackLeg(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleBackLeg(); // Set the Turtle back leg as the currently selected element
        } else if (Pview.getTurtleShell().containsPoint(x, y)) {
            // Display the Turtle shell's properties in the UI
            displayElement(Pview.getTurtleShell(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleShell(); // Set the Turtle shell as the currently selected element
        }

        // Check if the touch is within the Butterfly components (wings, body)

        else if (Pview.getButterflyWingBL().containsPoint(x, y)) {
            // Display the Butterfly's bottom-left wing properties in the UI
            displayElement(Pview.getButterflyWingBL(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingBL(); // Set the bottom-left wing as the currently selected element
        } else if (Pview.getButterflyWingBR().containsPoint(x, y)) {
            // Display the Butterfly's bottom-right wing properties in the UI
            displayElement(Pview.getButterflyWingBR(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingBR(); // Set the bottom-right wing as the currently selected element
        } else if (Pview.getButterflyWingTL().containsPoint(x, y)) {
            // Display the Butterfly's top-left wing properties in the UI
            displayElement(Pview.getButterflyWingTL(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingTL(); // Set the top-left wing as the currently selected element
        } else if (Pview.getButterflyWingTR().containsPoint(x, y)) {
            // Display the Butterfly's top-right wing properties in the UI
            displayElement(Pview.getButterflyWingTR(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingTR(); // Set the top-right wing as the currently selected element
        } else if (Pview.getButterflyBody().containsPoint(x, y)) {
            // Display the Butterfly's body properties in the UI
            displayElement(Pview.getButterflyBody(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyBody(); // Set the Butterfly body as the currently selected element
        }

        // Check if the touch is within the Grass component
        else if (Pview.getGrass().containsPoint(x, y)) {
            // Display the Grass properties in the UI
            displayElement(Pview.getGrass(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getGrass(); // Set the Grass as the currently selected element
        }

        // Set the flag to allow color changes for the currently selected element
        CurrElem.changeColor = true;

        // Indicate that the touch event has been handled
        return true;
    }
}