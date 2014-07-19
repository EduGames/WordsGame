package com.mohheader.wordsgame.models;

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
}
