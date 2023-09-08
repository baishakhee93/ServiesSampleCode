package com.baishakhee.forgroundsamplecode;

import static com.baishakhee.forgroundsamplecode.App.CHANAL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class SampleServices extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Sample Services","onCreate method Started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Sample Services","onStartCommand method Started");


        String input=intent.getStringExtra("inputData");

        Intent notificationIntent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_IMMUTABLE);


        Notification notification= new NotificationCompat.Builder(this,CHANAL_ID)
                .setContentTitle("Sample Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.baseline_room_service_24)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);// it is use for get notify about service working if we not you foreground then it will work on background servoce

        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Sample Services","onDestroy method Started");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Sample Services","onBind method Started");

        return null;
    }
}
