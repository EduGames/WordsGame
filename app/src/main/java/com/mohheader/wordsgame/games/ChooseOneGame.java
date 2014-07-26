package com.mohheader.wordsgame.games;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import com.mohheader.wordsgame.ParentActivity;
import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.models.GamesManager;
import com.mohheader.wordsgame.models.Score;
import com.mohheader.wordsgame.models.ScoreManager;
import com.mohheader.wordsgame.models.Word;
import com.mohheader.wordsgame.models.WordsManager;
import com.mohheader.wordsgame.interfaces.wordable;

import java.util.List;
import java.util.Random;

/**
 * Created by thedreamer on 7/5/14.
 */
abstract class ChooseOneGame extends GameActivity {
    final int soundIds[] = new int[2];
    SoundPool sp;
    Score score;

    enum sounds{
        WRONG, CHEERING
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        WordsManager.setContext(getApplicationContext());
        List<Word> words = WordsManager.getRandom(3);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        soundIds[sounds.WRONG.ordinal()] = sp.load(this, R.raw.wrong, 1);
        soundIds[sounds.CHEERING.ordinal()] = sp.load(this, R.raw.cheering, 1);

        score = new Score(getGameName(), ScoreManager.getLastScore(this,getGameName()));
        ((RatingBar)findViewById(R.id.rating)).setNumStars(ScoreManager.getMaxScore());
        updateRatingBar();
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
                        rightAnswer();
                    }else{
                        wrongAnswer();
                    }
                }
            });
        }

    }

    private void rightAnswer() {
        sp.play(soundIds[sounds.CHEERING.ordinal()], 1, 1, 1, 0, 1.0f);
        score.addOne();
        ScoreManager.save(this, score);
        if(score.getScore() >= ScoreManager.getMaxScore()){
            GamesManager.successCurrentGame(this,getGameLevel());
            finish();
        }else
            restart();
    }

    private void wrongAnswer() {
        score.minusHalf();
        ScoreManager.save(this, score);
        updateRatingBar();
        sp.play(soundIds[sounds.WRONG.ordinal()], 1, 1, 1, 0, 1.0f);
    }
    private void updateRatingBar(){
        ((RatingBar)findViewById(R.id.rating)).setRating(score.getScore());
    }

    abstract int getContentView();

    private void restart(){
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
    }
}
