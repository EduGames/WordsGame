package com.mohheader.wordsgame;

import android.content.Context;

import com.mohheader.wordsgame.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thedreamer on 7/4/14.
 */
public class WordsManager {
    private static Context context;
    public static List<Word> getRandom(int i) {
        List<Word> words = new ArrayList<Word>();

        List<String> d = Arrays.asList(context.getResources().getStringArray(R.array.words));
        for(String word : Random.getRandomSubList(d, i)){
            int id = context.getResources().getIdentifier(word, "string", context.getPackageName());
            String title = context.getString(id);
            int dId = context.getResources().getIdentifier(word, "drawable", context.getPackageName());

            words.add(new Word(title,dId));
        }
        return words;
    }

    public static void setContext(Context _context) {
        context = _context;
    }
}
