package com.mohheader.wordsgame.games;

import android.content.Context;

import com.mohheader.wordsgame.ParentActivity;

/**
 * Created by thedreamer on 7/25/14.
 */
abstract public class GameActivity extends ParentActivity implements Gameable{
    public String getHumanGameName(Context context){
        int id = context.getResources().getIdentifier(getGameName(), "string", context.getPackageName());
        if(id != 0 )
            return context.getString(id);
        else
            return "";
    }
}
