package com.example.pripremazakolokvijum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pripremazakolokvijum.services.ForegroundService;

public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);

        Button start = findViewById(R.id.btnStart);
        Button play = findViewById(R.id.btnPlay);
        Button pause = findViewById(R.id.btnPause);
        Button stop = findViewById(R.id.btnStop);

        start.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForegroundService.class);
            intent.setAction(ForegroundService.ACTION_START);
            startForegroundService(intent);
        });

        play.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForegroundService.class);
            intent.setAction(ForegroundService.ACTION_PLAY);
            startService(intent);
        });

        pause.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForegroundService.class);
            intent.setAction(ForegroundService.ACTION_PAUSE);
            startService(intent);
        });

        stop.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForegroundService.class);
            intent.setAction(ForegroundService.ACTION_STOP);
            startService(intent);
        });
    }
}