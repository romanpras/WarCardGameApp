package com.example.warcardgame.utils;

import android.content.Context;
import android.media.MediaPlayer;

public class MySoundUtils {
    private MediaPlayer mp;
    private int rawId;

    public MySoundUtils() {
    }

    public MySoundUtils(int rawId) {
        this.rawId = rawId;
    }

    /**
     * This function create and play sound
     * @param context The Context to use
     * @param isLoop Flag player to be looping or non-looping.
     */
    public void playSound(Context context , boolean isLoop) {
        mp = MediaPlayer.create(context, rawId);
        setLooping(isLoop);
        mp.setOnCompletionListener(mp -> {
            mp.reset();
            mp.release();
            mp=null;
        });
        mp.start();
    }

    public void setLooping(boolean loop){
        mp.setLooping(loop);
    }

    public void setMp(MediaPlayer mp) {
        this.mp = mp;
    }

    public MediaPlayer getMp() {
        return mp;
    }
}
