package com.example.customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign PaintView and TextView to their respective UI elements in the layout
        PaintView Pview = findViewById(R.id.PaintView);
        TextView Tview = findViewById(R.id.displayElementText);

        // Assign SeekBars for RGB values to their respective UI elements in the layout
        SeekBar seekRed = findViewById(R.id.redSeekBar);
        SeekBar seekGreen = findViewById(R.id.greenSeekBar);
        SeekBar seekBlue = findViewById(R.id.blueSeekBar);

        // Assign ColorElemView to handle color preview
        ColorElemView CEV = findViewById(R.id.colorElemView);
        // Set the initial color of the color element view to black
        CEV.setColor(Color.BLACK);

        // Instantiate the ColorController to handle interactions between UI elements and logic
        ColorController control = new ColorController(Pview, CEV, Tview, seekRed, seekGreen, seekBlue);
        // Assign the controller to the PaintView
        Pview.setControl(control);

        // Set the SeekBars' listeners to the ColorController to manage color changes
        seekRed.setOnSeekBarChangeListener(control);
        seekGreen.setOnSeekBarChangeListener(control);
        seekBlue.setOnSeekBarChangeListener(control);
        // Set the touch listener for the PaintView to allow interaction with drawn elements
        Pview.setOnTouchListener(control);

        // Display the default element's information in the TextView and update SeekBars accordingly
        control.displayElement(control.defaultElem, Tview, seekRed, seekGreen, seekBlue);
    }
}
