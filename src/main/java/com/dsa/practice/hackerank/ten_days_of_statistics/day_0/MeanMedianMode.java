package com.dsa.practice.hackerank.ten_days_of_statistics.day_0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-basic-statistics/problem?isFullScreen=true
 */
public class MeanMedianMode {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i< n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        double mean = (double)sum / n;
        System.out.println(mean);

        Arrays.sort(arr);
        double median = 0.0;

        if(n%2==0) {
            median = (double) (arr[n/2]+arr[n/2-1])/2;
        } else {
            median = (double) arr[n/2];
        }

        System.out.println(median);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }

        int mode = arr[0];

        for(int i=1; i< n; i++){
            if(map.get(mode) < map.get(arr[i]))
                mode = arr[i];
        }

        System.out.println(mode);

    }
}
