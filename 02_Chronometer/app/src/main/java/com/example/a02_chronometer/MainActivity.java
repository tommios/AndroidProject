package com.example.a02_chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            }
        });
    }

    public void onStartClick(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    public void onStopClick(View view) {
        chronometer.stop();
    }

    public void onResetClick(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
    }
}

