package com.mohheader.wordsgame.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by thedreamer on 7/19/14.
 */
public class GamesManager {
    public enum Games {
        ChooseImage("ChooseImage"),
        ChooseWord("ChooseWord"),
        MissingLetter("MissingLetter");

        private final String value;

        private Games(String value) {
            this.value = value;
        }

        public String getName() {
            return value;
        }
    }
    public static int getCurrentGame(Context context){
        SharedPreferences prefs = context
                .getSharedPreferences("Game", Context.MODE_PRIVATE);;
        return prefs.getInt("currentGame", 0);
    }

    public static void successCurrentGame(Context context, int currentGame){
        SharedPreferences prefs = context
                .getSharedPreferences("Game", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("currentGame",currentGame + 1);
        editor.apply();
    }
}
