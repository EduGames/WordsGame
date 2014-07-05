package com.mohheader.wordsgame.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mohheader.wordsgame.Word;
import com.mohheader.wordsgame.interfaces.wordable;

/**
 * Created by thedreamer on 7/5/14.
 */
public class WordTextView extends TextView implements wordable {
    public WordTextView(Context context) {
        super(context);
    }

    public WordTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WordTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setWord(Word word) {
        setText(word.getTitle());
    }
}
