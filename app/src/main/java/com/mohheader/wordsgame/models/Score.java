package com.mohheader.wordsgame.models;

/**
 * Created by thedreamer on 7/19/14.
 */
public class Score {
    private String game;
    private int score;

    public Score(String _game, int _score){
        game = _game;
        score = _score;
    }
    public void add(int n){
        score = score + n;
    }
    public void addOne(){
        add(1);
    }
    public int getScore(){
        return score;
    }
    public String getGame(){
        return game;
    }
}
