package com.mohheader.wordsgame.games;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import com.mohheader.wordsgame.ParentActivity;
import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.Word;
import com.mohheader.wordsgame.WordsManager;
import com.mohheader.wordsgame.interfaces.wordable;

import java.util.List;
import java.util.Random;

/**
 * Created by thedreamer on 7/5/14.
 */
abstract class ChooseOneGame extends ParentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        WordsManager.setContext(this);
        List<Word> words = WordsManager.getRandom(3);
        final SoundPool sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int soundIds[] = new int[2];
        soundIds[0] = sp.load(this, R.raw.wrong, 1);


        final Word rightWord = words.get(new Random().nextInt((words.size())));
        ((wordable)findViewById(R.id.word_title)).setWord(rightWord);

        for (int i = 0; i < words.size();i++){
            final Word word = words.get(i);
            int id = getResources().getIdentifier("image_"+(i+1), "id", getPackageName());
            ((wordable)findViewById(id)).setWord(word);
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rightWord.getTitle().equals(word.getTitle())){
                        restart();
                    }else{
                        sp.play(soundIds[0], 1, 1, 1, 0, 1.0f);
                    }
                }
            });
        }

    }

    abstract int getContentView();

    private void restart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
