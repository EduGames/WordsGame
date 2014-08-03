package com.mohheader.wordsgame.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.mohheader.wordsgame.models.Word;
import com.mohheader.wordsgame.interfaces.wordable;

/**
 * Created by thedreamer on 7/5/14.
 */
public class WordImageView extends ImageView implements wordable {
    boolean isWrong = false;
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

    @Override
    public boolean setWrong() {
        boolean result = !isWrong;
        if(result) {
            isWrong = true;
            invalidate();
        }
        return result;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isWrong) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeWidth(10);
            canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
            canvas.drawLine(getWidth(), 0, 0, getHeight(), paint);
        }
    }
}
