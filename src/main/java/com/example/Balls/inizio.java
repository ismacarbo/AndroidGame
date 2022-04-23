package com.example.Balls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.Clock;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class inizio extends AppCompatActivity {
    
    MediaPlayer chill;
    MediaPlayer menu;
    boolean prova=true;
    Suoni s;
    Button descrizione;

    private AlertDialog mAlertDialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inizio);
        chill=MediaPlayer.create(inizio.this,R.raw.chill);
        menu=MediaPlayer.create(inizio.this,R.raw.menu);


        menu.start();
        menu.setLooping(true);

        descrizione = findViewById(R.id.descrizione);


        createNotificationChannel();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Intent intent =new Intent(inizio.this,notifica.class);
        PendingIntent pendingIntent =PendingIntent.getBroadcast(inizio.this,0,intent,0);

        AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
    }

    protected void onUserLeaveHint(){
        menu.stop();
        super.onUserLeaveHint();
    }

    public void inizioMetodo(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        menu.stop();
        iniziaMusica();
    }

    public void iniziaMusica(){
        chill.start();
        chill.setLooping(true);
    }

    public void stop(){
        chill.stop();
    }

    public void descrivi(View v) {
        builder = new AlertDialog.Builder(inizio.this);
        builder.setTitle("Eating whale!");
        builder.setMessage("Non farti toccare dai nemici o morirai!\nPrendi le sfere gialle e rosse per guadagnare punti!\nChiudi l'applicazione quando hai finito di giocare!\nAll rights reserved by isma :)");
        builder.setCancelable(true);
        builder.setIcon(R.drawable.naveprova);
        builder.setPositiveButton("Continua", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAlertDialog.cancel();
                    }
                });
            mAlertDialog = builder.create();
            mAlertDialog.show();
    }






    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Notification";
            String description = "Start Activity from a Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel("notify", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    public void personalizza1(View view){
        startActivity(new Intent(getApplicationContext(), personalizzazione.class));
    }

    public void negozio(View view){
        startActivity(new Intent(getApplicationContext(), Negozio.class));
    }

    public void invia(View view){
        String text = "https://mega.nz/file/FphzDIJL#Je8nhPPcgyhguCQTQkegunoWKf7HjQ86GJWnh3BHXS4";

        try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, text);
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Whatsapp non installato",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
    }
}