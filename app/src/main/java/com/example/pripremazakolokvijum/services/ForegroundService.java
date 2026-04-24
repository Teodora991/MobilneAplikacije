package com.example.pripremazakolokvijum.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.pripremazakolokvijum.R;


public class ForegroundService extends Service {

    private static final String TAG = "ForegroundService";

    public static final String ACTION_START = "ACTION_START_FOREGROUND_SERVICE";
    public static final String ACTION_PLAY = "ACTION_PLAY";
    public static final String ACTION_PAUSE = "ACTION_PAUSE";
    public static final String ACTION_STOP = "ACTION_STOP";
    public static final String ACTION_STOPPED = "com.example.shopapp.ACTION_STOPPED";

    private static final int NOTIFICATION_ID = 50;

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;

        if (action == null) return START_NOT_STICKY;

        Log.i(TAG, "Action: " + action);

        switch (action) {
            case ACTION_START:
                startServiceInForeground();
                break;

            case ACTION_PLAY:
                play();
                break;

            case ACTION_PAUSE:
                pause();
                break;

            case ACTION_STOP:
                stop();
                break;
        }

        return START_NOT_STICKY;
    }

    private void play() {
        if (player != null && !player.isPlaying()) {
            player.start();
            Log.i(TAG, "Play");
        }
    }

    //test
    private void pause() {
        if (player != null && player.isPlaying()) {
            player.pause();
            Log.i(TAG, "Pause");
        }
    }

    private void stop() {
        Log.i(TAG, "Stop");

        releasePlayer();

        Intent intent = new Intent(ACTION_STOPPED);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        stopForeground(true);
        stopSelf();
    }

    private void startServiceInForeground() {
        Log.i(TAG, "Starting foreground service");

        initPlayer();
        startForeground(NOTIFICATION_ID, buildNotification());
    }

    private void initPlayer() {
        if (player == null) {
            player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            player.setLooping(true);
        }

        player.start();
    }

    private NotificationCompat.Builder baseNotificationBuilder() {
        return new NotificationCompat.Builder(this, "music_channel")
                .setContentTitle("ShopApp")
                .setContentText("Music service running")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .setOnlyAlertOnce(true);
    }

    private android.app.Notification buildNotification() {

        PendingIntent playPi = PendingIntent.getService(
                this, 1,
                new Intent(this, ForegroundService.class).setAction(ACTION_PLAY),
                PendingIntent.FLAG_IMMUTABLE
        );

        PendingIntent pausePi = PendingIntent.getService(
                this, 2,
                new Intent(this, ForegroundService.class).setAction(ACTION_PAUSE),
                PendingIntent.FLAG_IMMUTABLE
        );

        PendingIntent stopPi = PendingIntent.getService(
                this, 3,
                new Intent(this, ForegroundService.class).setAction(ACTION_STOP),
                PendingIntent.FLAG_IMMUTABLE
        );

        return baseNotificationBuilder()
                .addAction(android.R.drawable.ic_media_play, "Play", playPi)
                .addAction(android.R.drawable.ic_media_pause, "Pause", pausePi)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Stop", stopPi)
                .build();
    }

    private void releasePlayer() {
        if (player != null) {
            try {
                if (player.isPlaying()) {
                    player.stop();
                }
                player.release();
            } catch (Exception ignored) {}

            player = null;
        }
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service destroyed");

        releasePlayer();
        stopForeground(true);

        super.onDestroy();
    }
}