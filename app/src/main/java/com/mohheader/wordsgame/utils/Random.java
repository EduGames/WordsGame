package com.mohheader.wordsgame.utils;

import java.util.List;

/**
 * Created by thedreamer on 7/4/14.
 */
public class Random {

    public static <T> List<T> getRandomSubList(List<T> input, int subsetSize)
    {
        java.util.Random r = new java.util.Random();
        int inputSize = input.size();
        for (int i = 0; i < subsetSize; i++)
        {
            int indexToSwap = i + r.nextInt(inputSize - i);
            T temp = input.get(i);
            input.set(i, input.get(indexToSwap));
            input.set(indexToSwap, temp);
        }
        return input.subList(0, subsetSize);
    }
}
