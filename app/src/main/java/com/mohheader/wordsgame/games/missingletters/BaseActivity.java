package com.mohheader.wordsgame.games.missingletters;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.games.GameActivity;
import com.mohheader.wordsgame.games.missingletters.logic.LetterManager;
import com.mohheader.wordsgame.models.Word;
import com.mohheader.wordsgame.models.WordsManager;

import java.util.List;

/**
 * Created by thedreamer on 7/25/14.
 */
public class BaseActivity extends GameActivity{
    public final static int GAME_LEVEL = 0;
    int missingLetterNumber = 1;
    Word word;

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
            TextView tv = new TextView(this);
            tv.setText(s);
            if (s.equals(LetterManager.MISSING_DOTS))
                tv.setPadding(20, 0, 20, 0);
            tv.setTextSize(30);
            llWord.addView(tv);
        }

        for(final String s : LetterManager.randomLetters(5,String.valueOf(word.getTitle().charAt(missingLetterNumber)))){
            TextView tv = new TextView(this);
            tv.setText(s);
            tv.setPadding(20, 0, 20, 0);
            tv.setTextSize(30);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(s.equals(String.valueOf(word.getTitle().charAt(missingLetterNumber)))){
                        finish();
                    }
                }
            });
            llLetters.addView(tv);
        }
    }

    @Override
    public int getGameLevel() {
        return 0;
    }

    @Override
    public String getGameName() {
        return "MissingLetter";
    }
}
