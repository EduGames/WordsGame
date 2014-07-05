package com.mohheader.wordsgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ChooseImageActivity extends ParentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word);
        WordsManager.setContext(this);
        List<Word> words = WordsManager.getRandom(3);
        final SoundPool sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int soundIds[] = new int[2];
        soundIds[0] = sp.load(this, R.raw.wrong, 1);


        final Word rightWord = words.get(new Random().nextInt((words.size())));
        ((TextView)findViewById(R.id.word_title)).setText(rightWord.getTitle());

        for (int i = 0; i < words.size();i++){
            final Word word = words.get(i);
            Drawable d = getResources().getDrawable(word.getDrawableResource());
            int id = getResources().getIdentifier("image_"+(i+1), "id", getPackageName());
            ((ImageView)findViewById(id)).setImageDrawable(d);
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

    private void restart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }
}