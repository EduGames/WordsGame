package com.mohheader.wordsgame.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by thedreamer on 7/19/14.
 */
public class ScoreManager {

    public static int getLastScore(Context context, String gameName) {
        SharedPreferences prefs = context
                .getSharedPreferences("Score", Context.MODE_PRIVATE);;
        return prefs.getInt(gameName, 0);
    }

    public static void save(Context context, Score score) {
        SharedPreferences prefs = context
                .getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(score.getGame(),score.getScore());
        editor.apply();
    }
    public static void clearAll(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
