/*package com.example.customcoloring;

import android.graphics.Color;
import android.view.View;
import android.widget.SeekBar;

public class ColorController implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private CCModel model;
    private ColorElemView Cview;
    private PaintView view;
    private int currcolor;
    private SeekBar redSeekbar, greenSeekbar, blueSeekbar;

    public ColorController(PaintView object){
        view = object;
    }

    private void updateColor() {
        int red = redSeekbar.getProgress();
        int green = greenSeekbar.getProgress();
        int blue = blueSeekbar.getProgress();

        // Create the RGB color and update the current color
        currcolor = Color.rgb(red, green, blue);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // Get the current RGB values
       //updateColor();

    }

    public int getColor() {
        return this.currcolor;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {

    }
}
*/