package com.dsa.practice.hackerank.ten_days_of_statistics.day_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class StdDeviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        StdDeviation.stdDev(vals);

        bufferedReader.close();
    }


    public static void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function

        int sum = 0;

        for(int i=0; i< arr.size(); i++){
            sum += arr.get(i);
        }

        double mean = sum / arr.size();
        System.out.println(mean);

        double dev2 = 0;

        for(int i=0; i< arr.size(); i++){
            dev2 += Math.pow(arr.get(i) - mean, 2);
        }


        System.out.println(Math.sqrt(dev2/ arr.size()));

    }
}
