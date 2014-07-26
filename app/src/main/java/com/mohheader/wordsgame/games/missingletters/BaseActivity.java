package com.mohheader.wordsgame.games.missingletters;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.games.GameActivity;
import com.mohheader.wordsgame.games.missingletters.logic.LetterManager;
import com.mohheader.wordsgame.models.GamesManager;
import com.mohheader.wordsgame.models.Word;
import com.mohheader.wordsgame.models.WordsManager;
import com.mohheader.wordsgame.views.WordTextView;

import java.util.List;

/**
 * Created by thedreamer on 7/25/14.
 */
public class BaseActivity extends GameActivity{
    public final static int GAME_LEVEL = GamesManager.Games.MissingLetter.ordinal();
    int missingLetterNumber = 1;
    Word word;
    WordTextView missingLetterTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_letter);

        LinearLayout llWord = (LinearLayout) findViewById(R.id.word_container);
        LinearLayout llLetters = (LinearLayout) findViewById(R.id.letters);
        WordsManager.setContext(getApplicationContext());
        word = WordsManager.getRandrom();
        List<String> d = LetterManager.spread(word.getTitle(), missingLetterNumber);
        ((ImageView)findViewById(R.id.image)).setImageDrawable(word.getDrawable(this));

        for(String s : d){
            WordTextView tv = new WordTextView(this);
            tv.setText(s);
            if (s.equals(LetterManager.MISSING_DOTS)) {
                missingLetterTV = tv;
                tv.setPadding(20, 0, 20, 0);
            }
            tv.setTextSize(30);
            llWord.addView(tv);
        }

        for(final String s : LetterManager.randomLetters(5,String.valueOf(word.getTitle().charAt(missingLetterNumber)))){
            WordTextView tv = new WordTextView(this);
            tv.setText(s);
            tv.setPadding(20, 0, 20, 0);
            tv.setTextSize(30);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(s.equals(String.valueOf(word.getTitle().charAt(missingLetterNumber)))){
                        wrightAnswer(s);

                    }else{
                        wrongAnswer();
                    }
                }
            });
            llLetters.addView(tv);
        }
    }
    private void wrightAnswer(String s) {
        String before = "";
        if(missingLetterNumber > 0)
            before = word.getTitle().charAt(missingLetterNumber - 1)+"";
        boolean isLast = false;
        if(missingLetterNumber ==word.getTitle().length() -1)
            isLast = true;
        missingLetterTV.setText(LetterManager.correct(before,word.getTitle().charAt(missingLetterNumber),isLast));
        missingLetterTV.setPadding(0, 0, 0, 0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                restart();
            }
        }, 1500);
    }
    private void wrongAnswer() {

    }

    public String getGameName() {
        return GamesManager.Games.MissingLetter.getName();
    }
    public int getGameLevel() {
        return GAME_LEVEL;
    }
}
