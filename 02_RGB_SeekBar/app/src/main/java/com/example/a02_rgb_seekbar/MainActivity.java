package com.example.a02_rgb_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvRed, tvRedColor, tvGreen, tvGreenColor, tvBlue, tvBlueColor, tvAllColors;
    SeekBar sbRed, sbGreen, sbBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = (SeekBar) findViewById(R.id.seekBarRed);
        sbGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        sbBlue = (SeekBar) findViewById(R.id.seekBarBlue);

        sbRed.setOnSeekBarChangeListener(seekBarChangeListener);
        sbGreen.setOnSeekBarChangeListener(seekBarChangeListener);
        sbBlue.setOnSeekBarChangeListener(seekBarChangeListener);

        tvRed = (TextView) findViewById(R.id.textViewRed);
        tvRedColor = (TextView) findViewById(R.id.textViewRedColor);

        tvGreen = (TextView) findViewById(R.id.textViewGreen);
        tvGreenColor = (TextView) findViewById(R.id.textViewGreenColor);

        tvBlue = (TextView) findViewById(R.id.textViewBlue);
        tvBlueColor = (TextView) findViewById(R.id.textViewBlueColor);

        tvAllColors = (TextView) findViewById(R.id.textViewAllColors);

        updateBackground();

    }

    public SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateBackground();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };

    public void updateBackground() {
        int redValue, greenValue, blueValue;
        redValue = sbRed.getProgress();
        greenValue = sbGreen.getProgress();
        blueValue = sbBlue.getProgress();

        // Вывод значения ProgressBar в десятичной и шестнадцатиричной форме
        tvRed.setText("RED  " + redValue + "   " + Integer.toHexString(redValue));
        tvGreen.setText("GREEN  " + greenValue + "   " + Integer.toHexString(greenValue));
        tvBlue.setText("BLUE  " + blueValue + "   " + Integer.toHexString(blueValue));

        // меняем фон через формат RGB
        tvRedColor.setBackgroundColor(Color.rgb(redValue, 0 , 0));
        tvGreenColor.setBackgroundColor(Color.rgb(0, greenValue,0));
        tvBlueColor.setBackgroundColor(Color.rgb(0,0,blueValue));
        tvAllColors.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));
    }
}
