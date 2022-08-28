package com.dsa.practice.MAY222C;

import java.util.Scanner;

public class HIGHSCORE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();

            int arr[] = new int[4];

            int max = 0;

            for (int i = 0; i < 4; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }

            System.out.println(max);
        }
    }
}
