package com.dsa.practice.hackerank.ten_days_of_statistics.day_0;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InnerQuartileRange {

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i< values.size(); i++){
            for(int j=0; j< freqs.get(i); j++){
                arr.add(values.get(i));
            }
        }

        Collections.sort(arr);

        double q1 = 0;
        double q3 = 0;

        int n = arr.size();

        if(n % 2 == 0){
            if(n/2 % 2 == 0){
                q3 = (double)(arr.get(3*n/4) + arr.get(3*n/4 - 1)) / 2;
                q1 = (double)(arr.get(n/4) + arr.get(n/4 - 1)) / 2;
            }else{
                q1 = arr.get(n/4);
                q3 = arr.get(3*n/4);
            }
        }else{

            if(n/2 %2 == 0){
                q1 = (double)(arr.get(n/4) + arr.get(n/4 - 1))/2;
                q3 = (double)(arr.get(3*n/4) + arr.get(3*n/4 + 1)) / 2;
            }else{
                q1 = arr.get(n/4);
                q3 = arr.get(3*n/4);
            }
        }

        System.out.println(q3- q1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        InnerQuartileRange.interQuartile(val, freq);

        bufferedReader.close();
    }
}
