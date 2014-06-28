package com.mohheader.wordsgame;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ChooseWordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word);

        List<Word> words = new ArrayList<Word>();

        for(String word : getResources().getStringArray(R.array.words)){
            Log.i("INFO", "Word  = "+word);
            int id = getResources().getIdentifier(word, "string", getPackageName());
            String title = getString(id);
            int dId = getResources().getIdentifier(word, "drawable", getPackageName());

            words.add(new Word(title,dId));
        }

        for (Word word:words){
            Log.i("INFO", "Word Noun = "+word.getTitle());
            Drawable d = getResources().getDrawable(word.getDrawableResource());
            ImageView i = new ImageView(this);
            i.setImageDrawable(d);
            ((LinearLayout)findViewById(R.id.container)).addView(i);
        }
    }

}
