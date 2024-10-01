package com.example.customcoloring;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private ColorElemView Cview;
    private PaintView Pview;

    private int currcolor;
    private SeekBar redSeekbar, greenSeekbar, blueSeekbar;

    private TextView tview;

    private Boolean userAction = false;
    public final CustomElement defaultElem = new CustomCircle("None", 0, 0, 0, 0);
    private CustomElement CurrElem = defaultElem;

    public CustomElement getCurrElem() {
        return CurrElem;
    }

    public ColorController(PaintView Pview, ColorElemView Cview, TextView tview, SeekBar seekRed, SeekBar seekGreen, SeekBar seekBlue){
        this.Pview = Pview;
        this.Cview = Cview;
        this.tview = tview;
        this.redSeekbar = seekRed;
        this.greenSeekbar = seekGreen;
        this.blueSeekbar = seekBlue;
    }

    public int getRed() {
        return redSeekbar.getProgress();
    }
    public int getGreen() {
        return greenSeekbar.getProgress();
    }

    public int getBlue() {
        return blueSeekbar.getProgress();
    }

    private void updateColor(CustomElement elem, int color, SeekBar seekBar) {

        if (seekBar == redSeekbar) {
            Log.d("update", "" + elem.getName() + " New Color: " + color);
            elem.setColor(Color.rgb(color, Color.green(elem.getColor()), Color.blue(elem.getColor())),Pview);
            Log.d("ColorUpdate", "Element color after update: " + elem.getColor());
            Cview.setColor(Color.rgb(Color.red(CurrElem.getColor()), Color.green(CurrElem.getColor()), Color.blue(CurrElem.getColor())));

        }
        else if (seekBar == greenSeekbar) {
            Log.d("update", "" + elem.getName() + " New Color: " + color);
            elem.setColor(Color.rgb(Color.red(elem.getColor()), color, Color.blue(elem.getColor())),Pview);
            Log.d("ColorUpdate", "Element color after update: " + elem.getColor());
            Cview.setColor(Color.rgb(Color.red(CurrElem.getColor()), Color.green(CurrElem.getColor()), Color.blue(CurrElem.getColor())));


        }
        else if (seekBar == blueSeekbar) {
            Log.d("update", "" + elem.getName() + " New Color: " + color);
            elem.setColor(Color.rgb(Color.red(elem.getColor()), Color.green(elem.getColor()), color),Pview);
            Log.d("ColorUpdate", "Element color after update: " + elem.getColor() + "" + elem.getName());
            Cview.setColor(Color.rgb(Color.red(CurrElem.getColor()), Color.green(CurrElem.getColor()), Color.blue(CurrElem.getColor())));

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // Get the current RGB values
        Pview.getSun().setColor(Color.BLACK);
        updateColor(CurrElem, i, seekBar);
        Pview.invalidate();
    }

    public int getColor() {
        return this.currcolor;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        Log.d("changecolor","" + CurrElem + " true");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        CurrElem.changeColor = false;
        Log.d("changecolor","" + CurrElem + " false");

    }

    public void displayElement(CustomElement elem, TextView tview, SeekBar seekRed, SeekBar seekBlue, SeekBar seekGreen) {
        Log.i("display", "Displaying element" + elem.getName());
        //set textview string to element name
        tview.setText(elem.getName());
        //set seekbars to RGB of colors
        seekRed.setProgress(Color.red(elem.getColor()));
        seekBlue.setProgress(Color.blue(elem.getColor()));
        seekGreen.setProgress(Color.green(elem.getColor()));
        CurrElem = elem;
        Log.d("update1","CurrElem " + CurrElem.getName());
    }

    @Override


    public boolean onTouch(View view, MotionEvent motionEvent) {
        //get coords of touch
        Pview.invalidate();
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();
        //change color TEST

// Check for Sun
        if (Pview.getSun().containsPoint(x, y)) {
            displayElement(Pview.getSun(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getSun();

        }

// Check for Tree components

        else if (Pview.getTreeLeaves().containsPoint(x, y)) {
            displayElement(Pview.getTreeLeaves(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTreeLeaves();
        }

        else if (Pview.getTreeTrunk().containsPoint(x, y)) {
            displayElement(Pview.getTreeTrunk(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTreeTrunk();
        }

// Check for Turtle components

        else if (Pview.getTurtleHead().containsPoint(x, y)) {
            displayElement(Pview.getTurtleHead(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleHead();
        }

        else if (Pview.getTurtleBody().containsPoint(x, y)) {
            displayElement(Pview.getTurtleBody(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleBody();

        }

        else if (Pview.getTurtleFrontLeg().containsPoint(x, y)) {
            displayElement(Pview.getTurtleFrontLeg(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleFrontLeg();

        }

        else if (Pview.getTurtleBackLeg().containsPoint(x, y)) {
            displayElement(Pview.getTurtleBackLeg(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleBackLeg();

        }

        else if (Pview.getTurtleShell().containsPoint(x, y)) {
            displayElement(Pview.getTurtleShell(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getTurtleShell();

        }


// Check for Butterfly components
        else if (Pview.getButterflyWingBL().containsPoint(x, y)) {
            displayElement(Pview.getButterflyWingBL(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingBL();

        }

        else if (Pview.getButterflyWingBR().containsPoint(x, y)) {
            displayElement(Pview.getButterflyWingBR(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingBR();

        }

        else if (Pview.getButterflyWingTL().containsPoint(x, y)) {
            displayElement(Pview.getButterflyWingTL(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingTL();
        }

        else if (Pview.getButterflyWingTR().containsPoint(x, y)) {
            displayElement(Pview.getButterflyWingTR(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyWingTR();
        }

        else if (Pview.getButterflyBody().containsPoint(x, y)) {
            displayElement(Pview.getButterflyBody(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getButterflyBody();
        }

// Check for Grass
        else if (Pview.getGrass().containsPoint(x, y)) {
            displayElement(Pview.getGrass(), tview, redSeekbar, blueSeekbar, greenSeekbar);
            CurrElem = Pview.getGrass();
        }


        CurrElem.changeColor = true;
        Log.d("CC","treetrunk" + CurrElem.changeColor);
        //if element containspoint
        return true;
    }
}