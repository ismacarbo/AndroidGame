package com.example.Balls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Negozio extends AppCompatActivity {

    Risultato risultato;

    boolean immagine1=false;
    boolean immagine2=false;
    boolean immagine3=false;

    boolean immagine1Acquistata=false;
    boolean immagine2Acquistata=false;
    boolean immagine3Acquistata=false;

    boolean gucci=false;
    boolean gucciAcquistata=false;



    int monete1;
    int moneteMassime1;
    TextView moneteMassime;
    boolean prova=false;
    boolean prova1=false;
    boolean prova2=false;
    boolean prova3=false;
    boolean prova4=false;
    boolean prova5=false;
    boolean prova6=false;
    boolean prova7=false;

    Button personalizza;


    inizio i;

    SharedPreferences sharedPreferences3;
    SharedPreferences.Editor editor;

    SharedPreferences sharedPreferences1;
    SharedPreferences.Editor editor1;

    SharedPreferences sharedPreferences2;
    SharedPreferences.Editor editor2;

    SharedPreferences sharedPreferences4;
    SharedPreferences.Editor editor4;

    SharedPreferences sharedPreferences5;
    SharedPreferences.Editor editor5;

    SharedPreferences sharedPreferences6;
    SharedPreferences.Editor editor6;

    SharedPreferences sharedPreferences7;
    SharedPreferences.Editor editor7;

    SharedPreferences sharedPreferences8;
    SharedPreferences.Editor editor8;

    SharedPreferences sharedPreferences9;
    SharedPreferences.Editor editor9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negozio);
        moneteMassime=findViewById(R.id.moneteMassime);
        personalizza=findViewById(R.id.personalizza);


        sharedPreferences3=getSharedPreferences("GAME_COINS", Context.MODE_PRIVATE);
        moneteMassime1=sharedPreferences3.getInt("HIGH_COINS",0);

        sharedPreferences1=getSharedPreferences("GAME_SKINS",Context.MODE_PRIVATE);
        immagine2=sharedPreferences1.getBoolean("GAME_SKIN2",prova);


        sharedPreferences2=getSharedPreferences("GAME_SKINS1",Context.MODE_PRIVATE);
        immagine1=sharedPreferences2.getBoolean("GAME_SKIN1",prova1);


        sharedPreferences4=getSharedPreferences("GAME_SKINS2",Context.MODE_PRIVATE);
        immagine3=sharedPreferences2.getBoolean("GAME_SKIN3",prova2);

        sharedPreferences5=getSharedPreferences("GAME_SKINSGUCCI",Context.MODE_PRIVATE);
        gucci=sharedPreferences5.getBoolean("GAME_SKINGUCCI",prova3);

        sharedPreferences6=getSharedPreferences("SKINS_PRESE",Context.MODE_PRIVATE);
        immagine1Acquistata=sharedPreferences6.getBoolean("SKIN1_PRESA",prova4);

        sharedPreferences7=getSharedPreferences("SKINS_PRESE2",Context.MODE_PRIVATE);
        immagine2Acquistata=sharedPreferences7.getBoolean("SKIN2_PRESA",prova5);

        sharedPreferences8=getSharedPreferences("SKINS_PRESE3",Context.MODE_PRIVATE);
        immagine3Acquistata=sharedPreferences8.getBoolean("SKIN3_PRESA",prova6);

        sharedPreferences9=getSharedPreferences("SKINS_PRESEGUCCI",Context.MODE_PRIVATE);
        gucciAcquistata=sharedPreferences9.getBoolean("SKINGUCCI_PRESA",prova7);


        moneteMassime.setText(getString(R.string.monete_Massime,moneteMassime1));
    }

    public void secondaImmagine(View view){
        immagine2=true;
        immagine1=false;
        immagine2Acquistata=true;

        if(moneteMassime1>50&&moneteMassime1>=0){
            editor=sharedPreferences3.edit();
            editor.putInt("HIGH_COINS",moneteMassime1-50);
            editor.apply();

            editor1=sharedPreferences1.edit();
            editor1.putBoolean("GAME_SKIN2",immagine2);
            editor1.apply();

            editor2=sharedPreferences2.edit();
            editor2.putBoolean("GAME_SKIN1",immagine1);
            editor2.apply();



            editor7=sharedPreferences7.edit();
            editor7.putBoolean("SKIN2_PRESA",immagine2Acquistata);
            editor7.apply();



            Intent intent =new Intent(Negozio.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.box2);
            startActivity(intent);

        }else{
             Toast.makeText(getApplicationContext(),"Non hai abbastanza monete!",Toast.LENGTH_SHORT).show();
        }
    }

    public void  primaImmagine(View view){
        immagine1=true;
        immagine2=false;
        immagine1Acquistata=true;

        if(moneteMassime1>25&&moneteMassime1>=0){
            editor=sharedPreferences3.edit();
            editor.putInt("HIGH_COINS",moneteMassime1-25);
            editor.apply();

            editor2=sharedPreferences2.edit();
            editor2.putBoolean("GAME_SKIN1",immagine1);
            editor2.apply();

            editor1=sharedPreferences1.edit();
            editor1.putBoolean("GAME_SKIN2",immagine2);
            editor1.apply();


            editor6=sharedPreferences6.edit();
            editor6.putBoolean("SKIN1_PRESA",immagine1Acquistata);
            editor6.apply();

            Intent intent =new Intent(Negozio.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.box1);
            intent.putExtra("resId3",R.drawable.box1);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(),"Non hai abbastanza monete!",Toast.LENGTH_SHORT).show();
        }
    }





    public void terzaImmagine(View view){
        immagine3=true;
        immagine2=false;
        immagine1=false;
        immagine3Acquistata=true;

        if(moneteMassime1>100&&moneteMassime1>=0){
            editor=sharedPreferences3.edit();
            editor.putInt("HIGH_COINS",moneteMassime1-100);
            editor.apply();


            editor4=sharedPreferences4.edit();
            editor4.putBoolean("GAME_SKIN3",immagine3);
            editor4.apply();


            editor2=sharedPreferences2.edit();
            editor2.putBoolean("GAME_SKIN1",immagine1);
            editor2.apply();

            editor1=sharedPreferences1.edit();
            editor1.putBoolean("GAME_SKIN2",immagine2);
            editor1.apply();

            editor8=sharedPreferences8.edit();
            editor8.putBoolean("SKIN3_PRESA",immagine3Acquistata);
            editor8.apply();

            Intent intent =new Intent(Negozio.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.boxocchio);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(),"Non hai abbastanza monete!",Toast.LENGTH_SHORT).show();
        }
    }


    public void gucciImmagine(View view){
        gucci=true;
        immagine3=false;
        immagine2=false;
        immagine1=false;
        gucciAcquistata=true;

        if(moneteMassime1>1000&&moneteMassime1>=0){
            editor=sharedPreferences3.edit();
            editor.putInt("HIGH_COINS",moneteMassime1-1000);
            editor.apply();

            editor5=sharedPreferences5.edit();
            editor5.putBoolean("GAME_SKINGUCCI",gucci);
            editor5.apply();


            editor4=sharedPreferences4.edit();
            editor4.putBoolean("GAME_SKIN3",immagine3);
            editor4.apply();


            editor2=sharedPreferences2.edit();
            editor2.putBoolean("GAME_SKIN1",immagine1);
            editor2.apply();

            editor1=sharedPreferences1.edit();
            editor1.putBoolean("GAME_SKIN2",immagine2);
            editor1.apply();

            editor9=sharedPreferences9.edit();
            editor9.putBoolean("SKINGUCCI_PRESA",gucciAcquistata);
            editor9.apply();

            Intent intent =new Intent(Negozio.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.guccibanana);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(),"Non hai abbastanza monete!",Toast.LENGTH_SHORT).show();
        }
    }

    public void personalizza(View view){
        startActivity(new Intent(getApplicationContext(),personalizzazione.class));
    }
}