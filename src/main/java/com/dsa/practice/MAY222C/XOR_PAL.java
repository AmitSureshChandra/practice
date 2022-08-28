package com.dsa.practice.MAY222C;

import java.util.Arrays;
import java.util.Scanner;

public class XOR_PAL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            String str = sc.next();

            int[] arr = new int[str.length()];

            for (int i = 0; i < str.length(); i++) {
                arr[i] = Integer.parseInt(str.charAt(i)+"");
            }

            int i = 0;
            int j = arr.length-1;

            int opt = 0;

            while(i < j){
                if(arr[i] != arr[j]){
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i];
                    opt++;
                }
                i++;
                j--;
            }

            System.out.println((opt+1)/2);
        }
    }
}
