package com.mohheader.wordsgame.games;

import android.content.Context;

/**
 * Created by thedreamer on 7/25/14.
 */
public interface Gameable {
    int getGameLevel();
    String getGameName();
    String getHumanGameName(Context context);
}
