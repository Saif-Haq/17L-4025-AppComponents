//https://stackoverflow.com/questions/4459058/alarm-manager-example

package com.example.a4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class Reciever_ extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {

        Toast.makeText(context, "ALARM", Toast.LENGTH_LONG).show();

//        Intent i= new Intent(AlarmClock.ACTION_SET_ALARM);
//        i.putExtra(AlarmClock.EXTRA_HOUR, 01);
//        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
//        context.startActivity(i);



    }

    public void setAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Reciever_.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pi); // Millisec * Second * Minute
    }

    public void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, Reciever_.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

//    public void setAlarm(Context context)
//    {
//        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
//        Intent i = new Intent(context, Reciever_.class);
//        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
//        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pi); // Millisec * Second * Minute
//    }
//
//    public void cancelAlarm(Context context)
//    {
//        Intent intent = new Intent(context, Reciever_.class);
//        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        alarmManager.cancel(sender);
//    }

//    public  void SetAlarm1()
//    {
//
//        Intent i= new Intent(AlarmClock.ACTION_SET_ALARM);
//        i.putExtra(AlarmClock.EXTRA_HOUR, 01);
//        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
//        context.startActivity(i);
//    }
//    void SetAlarm2()
//    {
//        Intent i= new Intent(AlarmClock.ACTION_SET_ALARM);
//        i.putExtra(AlarmClock.EXTRA_HOUR, 02);
//        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
//        startActivity(i);
//    }
}
