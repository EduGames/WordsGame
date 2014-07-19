package com.mohheader.wordsgame.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.mohheader.wordsgame.models.Word;
import com.mohheader.wordsgame.interfaces.wordable;

/**
 * Created by thedreamer on 7/5/14.
 */
public class WordImageView extends ImageView implements wordable {
    public WordImageView(Context context) {
        super(context);
    }

    public WordImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WordImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setWord(Word word) {
        Drawable d = getResources().getDrawable(word.getDrawableResource());
        setImageDrawable(d);
    }
}
