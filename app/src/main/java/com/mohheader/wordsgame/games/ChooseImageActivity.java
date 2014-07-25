package com.mohheader.wordsgame.games;

import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.models.GamesManager;

public class ChooseImageActivity extends ChooseOneGame{
    public final static int GAME_LEVEL = GamesManager.Games.ChooseImage.ordinal();
    @Override
    int getContentView() {
        return R.layout.activity_choose_word;
    }

    public String getGameName() {
        return GamesManager.Games.ChooseImage.getName();
    }

    public int getGameLevel() {
        return GAME_LEVEL;
    }
}