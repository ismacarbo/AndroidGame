package com.example.Balls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class personalizzazione extends AppCompatActivity {

    boolean immagine1Acquistata=false;
    boolean immagine2Acquistata=false;
    boolean immagine3Acquistata=false;
    boolean gucciAcquistata=false;
    boolean immagineNormaleAcquistata=true;

    boolean immagine1personalizza=false;
    boolean immagine2personalizza=false;
    boolean immagine3personalizza=false;
    boolean guccipersonalizza=false;
    boolean immagineNormalepersonalizza=false;

    boolean prova4=false;
    boolean prova5=false;
    boolean prova6=false;
    boolean prova7=false;

    boolean prova8=false;
    boolean prova9=false;
    boolean prova10=false;
    boolean prova11=false;
    boolean prova12=false;
    inizio i;


    SharedPreferences sharedPreferences6;
    SharedPreferences.Editor editor6;

    SharedPreferences sharedPreferences7;
    SharedPreferences.Editor editor7;

    SharedPreferences sharedPreferences8;
    SharedPreferences.Editor editor8;

    SharedPreferences sharedPreferences9;
    SharedPreferences.Editor editor9;

    SharedPreferences sharedPreferences10;
    SharedPreferences.Editor editor10;

    SharedPreferences sharedPreferences11;
    SharedPreferences.Editor editor11;

    SharedPreferences sharedPreferences12;
    SharedPreferences.Editor editor12;

    SharedPreferences sharedPreferences13;
    SharedPreferences.Editor editor13;

    SharedPreferences sharedPreferences14;
    SharedPreferences.Editor editor14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizzazione);

        //PRENDI VALORE SKIN
        sharedPreferences6=getSharedPreferences("SKINS_PRESE",Context.MODE_PRIVATE);
        immagine1Acquistata=sharedPreferences6.getBoolean("SKIN1_PRESA",prova4);

        sharedPreferences7=getSharedPreferences("SKINS_PRESE2",Context.MODE_PRIVATE);
        immagine2Acquistata=sharedPreferences7.getBoolean("SKIN2_PRESA",prova5);

        sharedPreferences8=getSharedPreferences("SKINS_PRESE3",Context.MODE_PRIVATE);
        immagine3Acquistata=sharedPreferences8.getBoolean("SKIN3_PRESA",prova6);

        sharedPreferences9=getSharedPreferences("SKINS_PRESEGUCCI",Context.MODE_PRIVATE);
        gucciAcquistata=sharedPreferences9.getBoolean("SKINGUCCI_PRESA",prova7);

        //DAI VALORE AL MAIN SKIN
        sharedPreferences10=getSharedPreferences("SKINS_PRESE_PASSA",Context.MODE_PRIVATE);
        immagine1personalizza=sharedPreferences10.getBoolean("SKIN1_PRESA_PASSA",prova8);

        sharedPreferences11=getSharedPreferences("SKINS_PRESE2_PASSA",Context.MODE_PRIVATE);
        immagine2personalizza=sharedPreferences11.getBoolean("SKIN2_PRESA_PASSA",prova9);

        sharedPreferences12=getSharedPreferences("SKINS_PRESE3_PASSA",Context.MODE_PRIVATE);
        immagine3personalizza=sharedPreferences12.getBoolean("SKIN3_PRESA_PASSA",prova10);

        sharedPreferences13=getSharedPreferences("SKINS_PRESEGUCCI_PASSA",Context.MODE_PRIVATE);
        guccipersonalizza=sharedPreferences13.getBoolean("SKINGUCCI_PRESA_PASSA",prova11);

        sharedPreferences14=getSharedPreferences("SKINS_PRESE_NORMALEPASSA",Context.MODE_PRIVATE);
        immagineNormalepersonalizza=sharedPreferences14.getBoolean("SKIN_NORMALE_PASSA",prova12);


    }



    public void normaleImmagine(View view){

        immagine1personalizza=false;
        immagine3personalizza=false;
        immagine2personalizza=false;
        guccipersonalizza=false;
        immagineNormalepersonalizza=true;

        editor14=sharedPreferences14.edit();
        editor14.putBoolean("SKIN_NORMALE_PASSA",immagineNormalepersonalizza);
        editor14.apply();


        editor10=sharedPreferences10.edit();
        editor10.putBoolean("SKIN1_PRESA_PASSA",immagine1personalizza);
        editor10.apply();


        editor11=sharedPreferences11.edit();
        editor11.putBoolean("SKIN2_PRESA_PASSA",immagine2personalizza);
        editor11.apply();

        editor12=sharedPreferences12.edit();
        editor12.putBoolean("SKIN3_PRESA_PASSA",immagine3personalizza);
        editor12.apply();

        editor13=sharedPreferences13.edit();
        editor13.putBoolean("SKINGUCCI_PRESA_PASSA",guccipersonalizza);
        editor13.apply();

        Intent intent =new Intent(personalizzazione.this,MainActivity.class);
        intent.putExtra("resId",R.drawable.naveprova);
        startActivity(intent);


    }

    public void primaImmagine(View view){


        if(immagine1Acquistata){
            immagine2personalizza=false;
            immagine3personalizza=false;
            guccipersonalizza=false;
            immagine1personalizza=true;
            immagineNormalepersonalizza=false;

            editor14=sharedPreferences14.edit();
            editor14.putBoolean("SKIN_NORMALE_PASSA",immagineNormalepersonalizza);
            editor14.apply();


            editor10=sharedPreferences10.edit();
            editor10.putBoolean("SKIN1_PRESA_PASSA",immagine1personalizza);
            editor10.apply();

            editor11=sharedPreferences11.edit();
            editor11.putBoolean("SKIN2_PRESA_PASSA",immagine2personalizza);
            editor11.apply();

            editor12=sharedPreferences12.edit();
            editor12.putBoolean("SKIN3_PRESA_PASSA",immagine3personalizza);
            editor12.apply();

            editor13=sharedPreferences13.edit();
            editor13.putBoolean("SKINGUCCI_PRESA_PASSA",guccipersonalizza);
            editor13.apply();

            Intent intent =new Intent(personalizzazione.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.box1);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Non hai ancora acquistato questa skin!",Toast.LENGTH_SHORT).show();
        }
    }

    public void secondaImmagine(View view){
        immagine1personalizza=false;
        immagine3personalizza=false;
        guccipersonalizza=false;
        immagine2personalizza=true;
        immagineNormalepersonalizza=false;
        if(immagine2Acquistata){

            editor14=sharedPreferences14.edit();
            editor14.putBoolean("SKIN_NORMALE_PASSA",immagineNormalepersonalizza);
            editor14.apply();


            editor10=sharedPreferences10.edit();
            editor10.putBoolean("SKIN1_PRESA_PASSA",immagine1personalizza);
            editor10.apply();


            editor11=sharedPreferences11.edit();
            editor11.putBoolean("SKIN2_PRESA_PASSA",immagine2personalizza);
            editor11.apply();

            editor12=sharedPreferences12.edit();
            editor12.putBoolean("SKIN3_PRESA_PASSA",immagine3personalizza);
            editor12.apply();

            editor13=sharedPreferences13.edit();
            editor13.putBoolean("SKINGUCCI_PRESA_PASSA",guccipersonalizza);
            editor13.apply();



            Intent intent =new Intent(personalizzazione.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.box2);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Non hai ancora acquistato questa skin!",Toast.LENGTH_SHORT).show();
        }
    }

    public void terzaImmagine(View view){
        immagine1personalizza=false;
        immagine3personalizza=true;
        guccipersonalizza=false;
        immagine2personalizza=false;
        immagineNormalepersonalizza=false;
        if(immagine3Acquistata){

            editor14=sharedPreferences14.edit();
            editor14.putBoolean("SKIN_NORMALE_PASSA",immagineNormalepersonalizza);
            editor14.apply();


            editor10=sharedPreferences10.edit();
            editor10.putBoolean("SKIN1_PRESA_PASSA",immagine1personalizza);
            editor10.apply();


            editor11=sharedPreferences11.edit();
            editor11.putBoolean("SKIN2_PRESA_PASSA",immagine2personalizza);
            editor11.apply();

            editor12=sharedPreferences12.edit();
            editor12.putBoolean("SKIN3_PRESA_PASSA",immagine3personalizza);
            editor12.apply();

            editor13=sharedPreferences13.edit();
            editor13.putBoolean("SKINGUCCI_PRESA_PASSA",guccipersonalizza);
            editor13.apply();

            Intent intent =new Intent(personalizzazione.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.boxocchio);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Non hai ancora acquistato questa skin!",Toast.LENGTH_SHORT).show();
        }
    }

    public void gucciImmagine(View view){
        immagine1personalizza=false;
        immagine3personalizza=false;
        immagine2personalizza=false;
        guccipersonalizza=true;
        immagineNormalepersonalizza=false;
        if(gucciAcquistata){

            editor14=sharedPreferences14.edit();
            editor14.putBoolean("SKIN_NORMALE_PASSA",immagineNormalepersonalizza);
            editor14.apply();


            editor10=sharedPreferences10.edit();
            editor10.putBoolean("SKIN1_PRESA_PASSA",immagine1personalizza);
            editor10.apply();


            editor11=sharedPreferences11.edit();
            editor11.putBoolean("SKIN2_PRESA_PASSA",immagine2personalizza);
            editor11.apply();

            editor12=sharedPreferences12.edit();
            editor12.putBoolean("SKIN3_PRESA_PASSA",immagine3personalizza);
            editor12.apply();

            editor13=sharedPreferences13.edit();
            editor13.putBoolean("SKINGUCCI_PRESA_PASSA",guccipersonalizza);
            editor13.apply();

            Intent intent =new Intent(personalizzazione.this,MainActivity.class);
            intent.putExtra("resId",R.drawable.guccibanana);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Non hai ancora acquistato questa skin!",Toast.LENGTH_SHORT).show();
        }
    }

}