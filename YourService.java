package com.example.a4;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class YourService extends Service
{
    Reciever_ alarm = new Reciever_();
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        alarm.setAlarm(this);
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        alarm.setAlarm(this);
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
