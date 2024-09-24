package com.example.customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    //PaintView view = findViewById(R.id.PaintView);
    //ColorController control = new ColorController(view);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SeekBar seekRed = findViewById(R.id.redSeekBar);
        seekRed.setOnSeekBarChangeListener(control);

        SeekBar seekGreen = findViewById(R.id.greenSeekBar);
        seekGreen.setOnSeekBarChangeListener(control);

        SeekBar seekBlue = findViewById(R.id.blueSeekBar);
        seekBlue.setOnSeekBarChangeListener(control);*/

    }
}