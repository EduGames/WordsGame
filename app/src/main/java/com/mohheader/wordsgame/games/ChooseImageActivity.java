package com.mohheader.wordsgame.games;

import com.mohheader.wordsgame.R;
public class ChooseImageActivity extends ChooseOneGame{
    @Override
    int getContentView() {
        return R.layout.activity_choose_word;
    }

    @Override
    String getGameName() {
        return "ChooseImage";
    }
}