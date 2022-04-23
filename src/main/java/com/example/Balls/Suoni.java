package com.example.Balls;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;

class Suoni {

    private AudioAttributes audioAttributes;
    private static SoundPool soundPool;
    private static int hit,over,lessgo;



    Suoni(Context context){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(2)
                    .build();
        }else{
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        }
        hit = soundPool.load(context, R.raw.hit, 1);
        over = soundPool.load(context, R.raw.over, 1);
        lessgo = soundPool.load(context, R.raw.lessgo, 1);
    }

    void playHitSound() {
        soundPool.play(hit, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    void playOverSound() {
        soundPool.play(over, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    void stacca(){
        soundPool.play(lessgo, 1.0f, 1.0f, 1, 0, 1.0f);
    }


}
