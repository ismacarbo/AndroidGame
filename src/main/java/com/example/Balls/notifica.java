package com.example.Balls;


import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class notifica extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notify")
                .setSmallIcon(R.drawable.naveprova)
                //.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.box1))
                .setContentTitle("Che ne diresti di fare una partita su eating whale!?")
                .setContentText("Premi per giocare :)")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent resultIntent = new Intent(context.getApplicationContext(), inizio.class);

        // Create the TaskStackBuilder and add the intent ,with inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context.getApplicationContext());
        stackBuilder.addNextIntentWithParentStack(resultIntent);

        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);


        NotificationManagerCompat notificationManager =NotificationManagerCompat.from(context);
        notificationManager.notify(200,builder.build());
    }
}
