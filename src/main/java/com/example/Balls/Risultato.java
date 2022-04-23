package com.example.Balls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Risultato extends AppCompatActivity {
    MediaPlayer chill;
    int moneteMassime1;

    skin s;
    inizio i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultato);


        TextView monete=findViewById(R.id.monete);
        TextView moneteMassime=findViewById(R.id.moneteMassime);



        TextView punteggioNumero=findViewById(R.id.punteggioNumero);
        TextView punteggioMassimo=findViewById(R.id.punteggioMassimo);

        int punteggio1=getIntent().getIntExtra("Punteggio",0);
        punteggioNumero.setText(getString(R.string.numero,punteggio1));

        //puntegggio Massimo
        SharedPreferences sharedPreferences =getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int punteggioMassimo1=sharedPreferences.getInt("HIGH_SCORE",0);

        if(punteggio1>punteggioMassimo1){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("HIGH_SCORE",punteggio1);
            editor.apply();

            punteggioMassimo.setText(getString(R.string.punteggio_massimo,punteggio1));
        }else{
            punteggioMassimo.setText(getString(R.string.punteggio_massimo,punteggioMassimo1));
        }

        int monete1=getIntent().getIntExtra("Monete",0);
        monete.setText(getString(R.string.monete,monete1));

        SharedPreferences sharedPreferences1=getSharedPreferences("GAME_COINS",Context.MODE_PRIVATE);
        moneteMassime1=sharedPreferences1.getInt("HIGH_COINS",0);
        monete1=monete1+moneteMassime1;

        if(monete1>moneteMassime1){
            SharedPreferences.Editor editor=sharedPreferences1.edit();
            editor.putInt("HIGH_COINS",monete1);
            editor.apply();
            moneteMassime.setText(getString(R.string.monete_Massime,monete1));
        }else{
            moneteMassime.setText(getString(R.string.monete_Massime,moneteMassime1));
        }
    }

    public void Provadinuovo(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


    public void Home(View view){
        startActivity(new Intent(getApplicationContext(),inizio.class));
        i.stop();
    }



    public void negozioProva(View view){
        startActivity(new Intent(getApplicationContext(),Negozio.class));
    }

    @Override
    public void onBackPressed() {

    }
}