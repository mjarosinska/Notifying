package com.example.magda.notifying;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNotify(true, true);
    }


    public void setNotify(boolean sound, boolean vibrations) {
        Integer mId = 0;

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("UWAGA UWAGA")
                        .setContentText("Wstawaj śpiochu!");
        if (sound) {
            mBuilder.setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dancetone));
            //mBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        }
        if (vibrations) {
            long[] pattern = {1, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
            mBuilder.setVibrate(pattern);
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(mId, mBuilder.build());
    }
}
