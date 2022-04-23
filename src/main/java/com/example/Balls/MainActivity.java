package com.example.Balls;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    //imageview
    private ImageView nave;
    private ImageView nemici;
    private ImageView giallo;
    private ImageView rosa;
    private ImageView nemico2;

    private ImageView prova;
    private ImageView box2;
    private ImageView box1;
    private ImageView gucciProva;

    private FrameLayout frame;
    private int frameAltezza;

    private float naveY;
    private float nemiciX, nemiciY;
    private float rosaX, rosaY;
    private float gialloX,gialloY;
    private float nemico2X,nemico2Y;
    private int schermoGrandezza;
    private TextView punteggio;
    private TextView inizio;

    private int sizeNave;

    private int punteggio1;
    private int monete1;

    private int velocitaNave,velocitaGiallo,velocitaNemici,velocitaRosa,velocitaNemico2;


    boolean immagine1personalizza=false;
    boolean immagine2personalizza=false;
    boolean immagine3personalizza=false;
    boolean guccipersonalizza=false;
    boolean immagineNormalepersonalizza=false;

    boolean immagine2;
    boolean immagine1;
    boolean immagine3;
    boolean gucci;
    boolean check=false;
    boolean check1=false;
    boolean check2=false;
    boolean check3=false;
    boolean prova8=false;
    boolean prova9=false;
    boolean prova10=false;
    boolean prova11=false;
    boolean prova12=false;

    Button pausaButton;


    int resid;


    private boolean action_flg=false;
    private boolean start_flg=false;
    private boolean pause=false;

    private Suoni suoni;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    inizio i;


    SharedPreferences sharedPreferences3;
    SharedPreferences.Editor editor;

    SharedPreferences sharedPreferences2;
    SharedPreferences.Editor editor2;

    SharedPreferences sharedPreferences4;
    SharedPreferences.Editor editor4;

    SharedPreferences sharedPreferences5;
    SharedPreferences.Editor editor5;

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


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nave = findViewById(R.id.nave);

        //PASSAGGIO IMAGEVIEW PER NAVE
        prova=findViewById(R.id.prova);
        box2=findViewById(R.id.box2);
        box1=findViewById(R.id.box1);
        gucciProva=findViewById(R.id.gucciProva);
        pausaButton=findViewById(R.id.pausaButton);




        sharedPreferences3=getSharedPreferences("GAME_SKINS", Context.MODE_PRIVATE);
        immagine2=sharedPreferences3.getBoolean("GAME_SKIN2",check);

        sharedPreferences2=getSharedPreferences("GAME_SKINS1", Context.MODE_PRIVATE);
        immagine1=sharedPreferences2.getBoolean("GAME_SKIN1",check1);

        sharedPreferences4=getSharedPreferences("GAME_SKINS2", Context.MODE_PRIVATE);
        immagine3=sharedPreferences4.getBoolean("GAME_SKIN3",check2);

        sharedPreferences5=getSharedPreferences("GAME_SKINSGUCCI", Context.MODE_PRIVATE);
        gucci=sharedPreferences5.getBoolean("GAME_SKINGUCCI",check3);

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

        checkSkin();
        //checkSkinDaPersonalizzazione();


        inizio=findViewById(R.id.inizio);

        punteggio = findViewById(R.id.punteggio);
        giallo=findViewById(R.id.giallo);
        rosa=findViewById(R.id.rosa);
        nemico2=findViewById(R.id.nemico2);

        nemici = findViewById(R.id.nemici);

        nemici.setY(-80.0f);
        nemici.setX(-80.0f);
        giallo.setY(-80.0f);
        giallo.setX(-80.0f);
        rosa.setX(-80.0f);
        rosa.setY(-80.0f);
        nemico2.setX(-80.0f);
        nemico2.setX(-80.0f);

        suoni=new Suoni(this);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        schermoGrandezza = size.x;
        int schermoAltezza = size.y;

        velocitaNave=Math.round(schermoAltezza /90.0f);
        velocitaGiallo=Math.round(schermoGrandezza/50.0f);
        velocitaRosa=Math.round(schermoGrandezza/52.0f);
        velocitaNemici=Math.round(schermoGrandezza/40.0f);
        velocitaNemico2=Math.round(schermoGrandezza/52.0f);


        //Log.v("SPEED_NAVE",velocitaNave+"");
        //Log.v("SPEED_GIALLO",velocitaGiallo+"");
        //Log.v("SPEED_ROSA",velocitaRosa+"");
        //Log.v("SPEED_NEMICI",velocitaNemici+"");

        punteggio.setText(getString(R.string.punteggio,punteggio1));
        //punteggio.setText("punteggio: "+punteggio1);


    }





    public void cambiaPos() {

        collisione();

        skin();


        gialloX-=velocitaGiallo;
        if(gialloX<0){
            gialloX=schermoGrandezza+20;
            gialloY=(float)Math.floor(Math.random()*frameAltezza-giallo.getHeight());
        }
        giallo.setX(gialloX);
        giallo.setY(gialloY);


        nemiciX-=velocitaNemici;
        if(nemiciX<0){
            nemiciX=schermoGrandezza+10;
            nemiciY=(float)Math.floor(Math.random()*(frameAltezza-nemici.getHeight()));
        }
        nemici.setX(nemiciX);
        nemici.setY(nemiciY);

        rosaX-=velocitaRosa;
        if(rosaX<0){
            rosaX=schermoGrandezza+5000;
            rosaY=(float)Math.floor(Math.random()*(frameAltezza-rosa.getHeight()));
        }
        rosa.setX(rosaX);
        rosa.setY(rosaY);

        nemico2X-=velocitaNemico2;
        if(nemico2X<0){
            nemico2X=schermoGrandezza+10;
            nemico2Y=(float)Math.floor(Math.random()*(frameAltezza-nemico2.getHeight()));
        }
        nemico2.setX(nemico2X);
        nemico2.setY(nemico2Y);

        if(action_flg){
            naveY-=velocitaNave;
        }else{
            naveY+=velocitaNave;
        }

        if(naveY<0){
            naveY=0;
        }
        if(naveY>frameAltezza-sizeNave){
            naveY=frameAltezza-sizeNave;
        }

        nave.setY(naveY);

        //punteggio.setText("punteggio: "+punteggio1);
        punteggio.setText(getString(R.string.punteggio,punteggio1));
    }



    public void skin(){
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            resid=bundle.getInt("resId");
            nave.setImageResource(resid);
            nave.findViewById(R.id.prova);
        }
    }


    public void checkSkin(){
        if(immagineNormalepersonalizza) {
            nave.setImageResource(R.drawable.naveprova);
        }else if(immagine1||immagine1personalizza){
            nave.setImageResource(R.drawable.box1);
        }else if(immagine2||immagine2personalizza){
            nave.setImageResource(R.drawable.box2);
        }else if(immagine3||immagine3personalizza){
            nave.setImageResource(R.drawable.boxocchioprova);
        }else if(gucci||guccipersonalizza){
            nave.setImageResource(R.drawable.guccibananaprova);
        }
    }


    public void collisione(){
        float gialloCentroX=gialloX+giallo.getWidth()/2.0f;
        float gialloCentroY=gialloY+giallo.getHeight()/2.0f;

        if(0<=gialloCentroX&&gialloCentroX<=sizeNave&&naveY<=gialloCentroY&&gialloCentroY<=naveY+sizeNave){
            gialloX=-100.0f;
            punteggio1+=10;
            monete1+=1;
            suoni.playHitSound();
        }

        float rosaCentroX=rosaX+rosa.getWidth()/2.0f;
        float rosaCentroY=rosaY+rosa.getHeight()/2.0f;

        if(0<=rosaCentroX&&rosaCentroX<=sizeNave&&naveY<=rosaCentroY&&rosaCentroY<=naveY+sizeNave){
            rosaX=-100.0f;
            punteggio1+=30;
            monete1+=3;
            suoni.playHitSound();
        }

        float nemico2CentroX=nemico2X+nemico2.getWidth()/2.0f;
        float nemico2CentroY=nemico2Y+nemico2.getHeight()/2.0f;
        if(0<=nemico2CentroX&&nemico2CentroX<=sizeNave&&naveY<=nemico2CentroY&&nemico2CentroY<=naveY+sizeNave){
            suoni.playOverSound();
            nemico2X=-100.0f;
            if(punteggio1<50){
                if(timer!=null){
                    timer.cancel();
                    timer=null;
                }
                Intent intent =new Intent(getApplicationContext(), Risultato.class);
                intent.putExtra("Punteggio",punteggio1);
                intent.putExtra("Monete",monete1);
                startActivity(intent);
            }else{
                punteggio1-=50;
            }
        }

        float nemiciCentroX=nemiciX+nemici.getWidth()/2.0f;
        float nemiciCentroY=nemiciY+nemici.getHeight()/2.0f;

        if(0<=nemiciCentroX&&nemiciCentroX<=sizeNave&&naveY<=nemiciCentroY&&nemiciCentroY<=naveY+sizeNave){
            suoni.playOverSound();
            if(timer!=null){
                timer.cancel();
                timer=null;
            }
            Intent intent=new Intent(getApplicationContext(), Risultato.class);
            intent.putExtra("Punteggio",punteggio1);
            intent.putExtra("Monete",monete1);
            startActivity(intent);
        }
    }


    public void pausa(View view){
        if(pause==false){
            pause=true;

            timer.cancel();
            timer=null;

            pausaButton.setText(">");

        }else{
            pause=false;

            pausaButton.setText("| |");
            timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            cambiaPos();
                        }
                    });
                }
            },0,20);

        }
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!start_flg){
            start_flg=true;

            FrameLayout frameLayout =findViewById(R.id.frame);
            frameAltezza=frameLayout.getHeight();

            naveY=nave.getY();
            sizeNave=nave.getHeight();

            inizio.setVisibility(View.GONE);


            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            cambiaPos();
                        }
                    });
                }
            },0,20);

        } else{
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                action_flg=true;
            } else if(event.getAction()==MotionEvent.ACTION_UP) {
                action_flg=false;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
    }
}
