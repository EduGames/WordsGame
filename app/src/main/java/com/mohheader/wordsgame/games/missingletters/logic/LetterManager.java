package com.mohheader.wordsgame.games.missingletters.logic;

import com.mohheader.wordsgame.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by thedreamer on 7/25/14.
 */
public class LetterManager {
    private final static List<String> sufix;
    private final static List<String> allLetters = new ArrayList<String>();
    public final static String MISSING_DOTS = "__";
    static {
        sufix = Arrays.asList(new String[] {"","إ","ا","أ","و","ر","ز","د","ذ","ة"});
        allLetters.add("أ");
        allLetters.add("ب");
        allLetters.add("ت");
        allLetters.add("ث");
        allLetters.add("ج");
        allLetters.add("ح");
        allLetters.add("خ");
        allLetters.add("د");
        allLetters.add("ذ");
        allLetters.add("ر");
        allLetters.add("ز");
        allLetters.add("س");
        allLetters.add("ش");
        allLetters.add("ص");
        allLetters.add("ض");
        allLetters.add("ط");
        allLetters.add("ظ");
        allLetters.add("ع");
        allLetters.add("غ");
        allLetters.add("ف");
        allLetters.add("ق");
        allLetters.add("ك");
        allLetters.add("ل");
        allLetters.add("م");
        allLetters.add("ن");
        allLetters.add("ه");
        allLetters.add("و");
        allLetters.add("ي");
        allLetters.add("ة");
    }

    public static List<String> spread(String word, int missing){
        List<String> result = new ArrayList<String>();
        char[] letters = word.toCharArray();
        for (int i = letters.length -1; i >= 0; i--){
            String c;
            boolean isLast = ( i == letters.length - 1 );
            if(i == missing)
                c = MISSING_DOTS;
            else if(i == 0)
                c = correct("",letters[i],isLast);
            else
                c = correct(letters[i-1]+"",letters[i],isLast);
            result.add(c);
        }
        return result;
    }

    public static String correct(String before, char letter, boolean isLast){
        StringBuilder result = new StringBuilder();
        if(!sufix.contains(""+before)){
            result.append("ـ");
        }
        result.append(letter);
        if(!isLast && !sufix.contains(""+letter)){
            result.append("ـ");
        }
        return result.toString();
    }

    public static List<String> randomLetters(int size, String letter){
        List<String> result = new ArrayList<String>();
        result.add(letter);
        result.addAll(Random.getRandomSubList(allLetters, size - 1));
        Collections.shuffle(result);
        return result;
    }

}
