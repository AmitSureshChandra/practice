package com.dsa.practice.hackerank.ten_days_of_statistics.day_0;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BinomialDistribution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        double boy = 1.09;
        double girl = 1.0;

        double pBoy = boy / (boy + girl);

        double p = 0;

        int n = 6;

        for(int i=3; i<= n; i++){
            p += ( nCx(n, i) * Math.pow(pBoy, i) * Math.pow(1-pBoy, (double)(n-i)));
        }

        System.out.println(round(p, 3));
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    static double nCx(int n, int x){
        return ((double)fact(n))/ ( fact(x) * fact(n-x) );
    }

    static long fact(long n){

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}
