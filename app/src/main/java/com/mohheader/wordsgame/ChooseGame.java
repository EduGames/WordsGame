package com.mohheader.wordsgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mohheader.wordsgame.games.ChooseImageActivity;
import com.mohheader.wordsgame.games.ChooseWordActivity;

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
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.word:
                i = new Intent(ChooseGame.this,ChooseWordActivity.class);
                startActivity(i);
                break;
            case R.id.image:
                i = new Intent(ChooseGame.this,ChooseImageActivity.class);
                startActivity(i);
                break;
        }

    }
}
