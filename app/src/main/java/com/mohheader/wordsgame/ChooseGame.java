package com.mohheader.wordsgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mohheader.wordsgame.games.ChooseImageActivity;
import com.mohheader.wordsgame.games.ChooseWordActivity;
import com.mohheader.wordsgame.models.GamesManager;
import com.mohheader.wordsgame.models.ScoreManager;
import com.mohheader.wordsgame.views.LevelTitle;

/**
 * Created by thedreamer on 7/5/14.
 */
public class ChooseGame extends ParentActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_game);
        findViewById(R.id.word).setOnClickListener(this);
        findViewById(R.id.image).setOnClickListener(this);
        ScoreManager.clearAll(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LevelTitle)findViewById(R.id.word)).setGame(new ChooseWordActivity());
        ((LevelTitle)findViewById(R.id.image)).setGame(new ChooseImageActivity());
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.image:
                //TODO : Refactor ( GamesManager.isLevelGameAble(ChooseImageActivity);  )
                if(GamesManager.getCurrentGame(this) >= ChooseImageActivity.GAME_LEVEL){
                    i = new Intent(ChooseGame.this,ChooseImageActivity.class);
                    startActivity(i);
                }
                break;
            case R.id.word:
                if(GamesManager.getCurrentGame(this) >= ChooseWordActivity.GAME_LEVEL ){
                    i = new Intent(ChooseGame.this,ChooseWordActivity.class);
                    startActivity(i);
                }
                break;
        }

    }
}
