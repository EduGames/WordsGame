package com.mohheader.wordsgame.games;

import com.mohheader.wordsgame.R;
/**
 * Created by thedreamer on 7/5/14.
 */
public class ChooseWordActivity extends ChooseOneGame {
    public final static int GAME_LEVEL = 1;
    @Override
    int getContentView() {
        return R.layout.activity_choose_image;
    }

    public String getGameName() {
        return "ChooseWord";
    }
    public int getGameLevel() {
        return GAME_LEVEL;
    }
}