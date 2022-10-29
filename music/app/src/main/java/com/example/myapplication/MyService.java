package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    private Mybinder binder;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zjn);
        mediaPlayer.start();
        Log.d("MyService", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
        Log.d("MyService", "onDestroy");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService", "onBind");
        binder = new Mybinder();
        return binder;
    }

    class Mybinder extends Binder {
        public void myplay() {
            mediaPlayer.start();
        }
    }

}