package com.mohheader.wordsgame.games;

import com.mohheader.wordsgame.R;
public class ChooseImageActivity extends ChooseOneGame{
    public final static int GAME_LEVEL = 0;
    @Override
    int getContentView() {
        return R.layout.activity_choose_word;
    }

    public String getGameName() {
        return "ChooseImage";
    }

    public int getGameLevel() {
        return GAME_LEVEL;
    }
}