package com.baishakhee.forgroundsamplecode;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {

    public static final String CHANAL_ID="ServicesChannal";

    @Override
    public void onCreate() {
        super.onCreate();

createNotification();

    }

    private void createNotification() {

        NotificationChannel notificationChannel= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(
                    CHANAL_ID,"Forground Services Channal", NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        }
}
