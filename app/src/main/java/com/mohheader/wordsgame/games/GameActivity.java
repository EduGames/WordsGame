package com.mohheader.wordsgame.games;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;

import com.mohheader.wordsgame.ParentActivity;
import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.models.Score;
import com.mohheader.wordsgame.models.ScoreManager;

/**
 * Created by thedreamer on 7/25/14.
 */
abstract public class GameActivity extends ParentActivity implements Gameable{
    protected final int soundIds[] = new int[2];
    protected SoundPool sp;
    protected enum sounds{
        WRONG, CHEERING
    }

    protected Score score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        soundIds[sounds.WRONG.ordinal()] = sp.load(this, R.raw.wrong, 1);
        soundIds[sounds.CHEERING.ordinal()] = sp.load(this, R.raw.cheering, 1);
        score = new Score(getGameName(), ScoreManager.getLastScore(this, getGameName()));
    }

    public String getHumanGameName(Context context){
        int id = context.getResources().getIdentifier(getGameName(), "string", context.getPackageName());
        if(id != 0 )
            return context.getString(id);
        else
            return "";
    }
    protected void restart(){
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
    }
    protected void playSound(sounds sound){
        sp.play(soundIds[sound.ordinal()], 1, 1, 1, 0, 1.0f);
    }
}
