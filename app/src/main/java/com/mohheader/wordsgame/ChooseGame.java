package com.mohheader.wordsgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mohheader.wordsgame.games.ChooseImageActivity;
import com.mohheader.wordsgame.games.ChooseWordActivity;
import com.mohheader.wordsgame.games.missingletters.BaseActivity;
import com.mohheader.wordsgame.models.GamesManager;
import com.mohheader.wordsgame.models.ScoreManager;
import com.mohheader.wordsgame.views.LevelTitle;

/**
 * Created by thedreamer on 7/5/14.
 */
public class ChooseGame extends ParentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_game);

        findViewById(R.id.word).setOnClickListener(new GameClickListener(ChooseWordActivity.class,
                ChooseWordActivity.GAME_LEVEL));

        findViewById(R.id.image).setOnClickListener(new GameClickListener(ChooseImageActivity.class,
                ChooseImageActivity.GAME_LEVEL));

        findViewById(R.id.missing).setOnClickListener(new GameClickListener(BaseActivity.class,
                BaseActivity.GAME_LEVEL));
        ScoreManager.clearAll(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LevelTitle)findViewById(R.id.word)).setGame(new ChooseWordActivity());
        ((LevelTitle)findViewById(R.id.image)).setGame(new ChooseImageActivity());
        ((LevelTitle)findViewById(R.id.missing)).setGame(new BaseActivity());
    }

    private class GameClickListener implements View.OnClickListener {
        Class gameClass;
        int gameLevel;
        GameClickListener(Class gameClass, int gameLevel){
            this.gameClass = gameClass;
            this.gameLevel = gameLevel;
        }
        @Override
        public void onClick(View view) {
            if(GamesManager.getCurrentGame(ChooseGame.this) >= gameLevel){
                Intent i = new Intent(ChooseGame.this,gameClass);
                startActivity(i);
            }
        }
    }
}
