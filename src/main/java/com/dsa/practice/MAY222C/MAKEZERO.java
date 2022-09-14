package com.dsa.practice.MAY222C;

import java.util.Scanner;

public class MAKEZERO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){

            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int sum = 0;

            for (int i = 0; i < 32; i++) {

                int val = 0;
                abc:
                for (int j = 0; j < n; j++) {

                    if((arr[j] & (1l << i)) != 0){
                        val |= 1;
                        break abc;
                    }
                }
                sum += val;
            }

            System.out.println(sum);

        }

    }
}
