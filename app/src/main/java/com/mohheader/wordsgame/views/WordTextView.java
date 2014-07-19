package com.mohheader.wordsgame.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.mohheader.wordsgame.models.Word;
import com.mohheader.wordsgame.interfaces.wordable;

/**
 * Created by thedreamer on 7/5/14.
 */
public class WordTextView extends TextView implements wordable {
    private static Typeface mTypeface;
    public WordTextView(Context context) {
        this(context, null);
    }

    public WordTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WordTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTextColor(Color.BLUE);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/shoroq.ttf");
        }
        setTypeface(mTypeface);
        setPaintFlags(Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public void setWord(Word word) {
        setText(word.getTitle());
    }
}
