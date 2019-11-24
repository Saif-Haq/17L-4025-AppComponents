package com.example.a4;
//https://www.youtube.com/watch?v=QcF4M2yUpY4  basic concept of alarm manager :)
//
//
//

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;

    AlarmManager am;
    PendingIntent pi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //time rn is hardcoded :3
                int time= 3;  //time in seconds -_-


                Intent intent = new Intent(getApplicationContext(), Reciever_.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 0,intent, 0);



               am=  (AlarmManager) getSystemService(ALARM_SERVICE); //STARTS ALARM ??

                 am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ time*1000,pi);





               // Intent i= new Intent(AlarmClock.ACTION_SET_ALARM);
                //i.putExtra(AlarmClock.EXTRA_HOUR, 01);
                //i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
                //startActivity(i);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                 if (am!= null) {
                     am.cancel(pi);
                }
            }
        });




    }
   public  void SetAlarm1()
    {

         Intent i= new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, 01);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
        startActivity(i);
    }
    void SetAlarm2()
    {
         Intent i= new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, 02);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
        startActivity(i);
    }
}
