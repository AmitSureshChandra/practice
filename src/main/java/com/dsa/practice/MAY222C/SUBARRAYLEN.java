package com.dsa.practice.MAY222C;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SUBARRAYLEN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] =sc.nextInt();
            }

            int sum =0 ;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int si = 0;
                if(map.containsKey(arr[i])){
                    si = map.get(arr[i]) + 1;
                }
                int left = Math.min(arr[i] - 1, i - si);
                int right = (arr.length -1) >= (i + arr[i] - 1) ?  arr[i] - 1 : 0;
                sum += (left + right + (arr[i] == 1 ? 1: 0));

//
                System.out.println("l : " + left);
                System.out.println("r : " + right);
                System.out.println("~~~~~~~~~~~~~~~~~");
                map.put(arr[i], i);
            }
            System.out.println(sum);
        }
    }
}
