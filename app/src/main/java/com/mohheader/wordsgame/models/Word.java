package com.mohheader.wordsgame.models;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by mohheader on 6/22/14.
 */
public class Word {
    private String title;
    private int drawableResource;
    public Word(String _title, int _drawable_resource){
        title = _title;
        drawableResource = _drawable_resource;
    }
    public String getTitle(){
        return title;
    }

    public int getDrawableResource() {
        return drawableResource;
    }
    public Drawable getDrawable(Context context){
        return context.getResources().getDrawable(getDrawableResource());
    }
}
