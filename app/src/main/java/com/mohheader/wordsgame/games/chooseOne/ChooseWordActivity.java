package com.mohheader.wordsgame.games.chooseOne;

import com.mohheader.wordsgame.R;
import com.mohheader.wordsgame.models.GamesManager;

/**
 * Created by thedreamer on 7/5/14.
 */
public class ChooseWordActivity extends ChooseOneGame {
    public final static int GAME_LEVEL = GamesManager.Games.ChooseWord.ordinal();
    @Override
    int getContentView() {
        return R.layout.activity_choose_image;
    }

    public String getGameName() {
        return GamesManager.Games.ChooseWord.getName();
    }
    public int getGameLevel() {
        return GAME_LEVEL;
    }
}