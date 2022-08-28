package com.dsa.practice.hackerank.ten_days_of_statistics.day_0;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/s10-weighted-mean/problem?isFullScreen=true
 */
public class WeightedMean {
    /*
     * Complete the 'weightedMean' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY X
     *  2. INTEGER_ARRAY W
     */

    public static void weightedMean(List<Integer> X, List<Integer> W) {
        // Write your code here

        double sumXW = 0;
        double sumW = 0;

        for(int i=0; i< X.size(); i++){
            sumXW += (X.get(i) * W.get(i));
            sumW += W.get(i);
        }

        System.out.println(round(sumXW / sumW, 1));

    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

}
