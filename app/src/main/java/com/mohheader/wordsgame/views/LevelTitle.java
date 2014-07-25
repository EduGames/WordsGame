package com.mohheader.wordsgame.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.games.ChooseImageActivity;
import com.mohheader.wordsgame.games.Gameable;
import com.mohheader.wordsgame.models.GamesManager;

/**
 * Created by thedreamer on 7/25/14.
 */
public class LevelTitle extends RelativeLayout {
    private TextView name;
    private ImageView lock;
    public LevelTitle(Context context) {
        this(context, null);
    }

    public LevelTitle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LevelTitle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.compound_level_title, this);
        setup();
    }

    private void setup() {
        name = (TextView) findViewById(R.id.name);
        lock = (ImageView) findViewById(R.id.lock);
    }

    public void setText(String text){
        name.setText(text);
    }
    public void setGame(Gameable game){
        setText(game.getHumanGameName(getContext()));
        if(GamesManager.getCurrentGame(getContext()) >= game.getGameLevel()){
            setPlayable(true);
        }else{
            setPlayable(false);
        }
    }
    public void setPlayable(Boolean isPlayable){
        if(isPlayable){
            lock.setVisibility(GONE);
        }else{
            lock.setVisibility(VISIBLE);
        }
    }
    public boolean isLocked(){
        return lock.getVisibility() != VISIBLE;
    }
    public void breakTheLock(){
        //TODO : set Scale Animation + Fade Out + Sound Effect.
    }
}
