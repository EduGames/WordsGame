package com.mohheader.wordsgame.models;

/**
 * Created by thedreamer on 7/19/14.
 */
public class Score {
    private String game;
    private float score;

    public Score(String _game, float _score){
        game = _game;
        score = _score;
    }
    public void add(float n){
        score = score + n;
        if(score < 0) score = 0;
    }
    public Score addOne(){
        add(1);
        return this;
    }
    public Score minusHalf(){
        add(- 0.5f);
        return this;
    }
    public float getScore(){
        return score;
    }
    public String getGame(){
        return game;
    }
}
