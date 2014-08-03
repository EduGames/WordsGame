package com.mohheader.wordsgame.games.chooseOne;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import com.mohheader.wordsgame.ParentActivity;
import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.games.GameActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        WordsManager.setContext(getApplicationContext());
        List<Word> words = WordsManager.getRandom(3);

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
                        wrongAnswer(view);
                    }
                }
            });
        }
    }

    private void rightAnswer() {
        playSound(sounds.CHEERING);
        ScoreManager.save(this, score.addOne());
        if(score.getScore() >= ScoreManager.getMaxScore()){
            GamesManager.successCurrentGame(this,getGameLevel());
            finish();
        }else
            restart();
    }

    private void wrongAnswer(View view) {
        if(((wordable)view).setWrong()) {
            ScoreManager.save(this, score.minusHalf());
            updateRatingBar();
            playSound(sounds.WRONG);
        }
    }
    private void updateRatingBar(){
        ((RatingBar)findViewById(R.id.rating)).setRating(score.getScore());
    }

    abstract int getContentView();
}
