package com.example.customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign Paint View and text view to xml elements
        PaintView Pview = findViewById(R.id.PaintView);
        TextView Tview = findViewById(R.id.displayElementText);



        //assign seekbars to xml elements
        SeekBar seekRed = findViewById(R.id.redSeekBar);

        SeekBar seekGreen = findViewById(R.id.greenSeekBar);

        SeekBar seekBlue = findViewById(R.id.blueSeekBar);

        ColorElemView CEV = findViewById(R.id.colorElemView);
        CEV.setColor(Color.BLACK);
        //instantiate controller
        ColorController control = new ColorController(Pview, CEV, Tview, seekRed, seekGreen, seekBlue);
        Pview.setControl(control);

        //set seekbar listeners to controller class
        seekRed.setOnSeekBarChangeListener(control);
        seekGreen.setOnSeekBarChangeListener(control);
        seekBlue.setOnSeekBarChangeListener(control);
        Pview.setOnTouchListener(control);

        control.displayElement(control.defaultElem, Tview, seekRed, seekGreen, seekBlue);

    }
}