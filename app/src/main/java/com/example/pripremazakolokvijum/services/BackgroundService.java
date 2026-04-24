package com.example.pripremazakolokvijum.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.pripremazakolokvijum.helpers.CheckConnectionTools;

public class BackgroundService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // 1. provjera konekcije
        int connectionStatus = CheckConnectionTools.checkConnection(this);

        Log.i("Service", "Connection status: " + connectionStatus);

        // 2. ako ima interneta pokreni asinhroni zadatak
        if (connectionStatus != 0) {

            new Thread(() -> {

                Log.i("Service", "Background task started");

                for (int i = 0; i < 5; i++) {
                    Log.i("Service", "Working... " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Log.i("Service", "Task finished");

                stopSelf();

            }).start();
        } else {
            Log.i("Service", "No internet connection");
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Service", "Service destroyed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}