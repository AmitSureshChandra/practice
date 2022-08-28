package com.dsa.practice.array;

/**
 * https://practice.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1/
 */
public class TewoRepeatedElement {
    public static void main(String[] args) {
        int[] a = new TewoRepeatedElement().twoRepeated(new int[]{1,2,2,1}, 2);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public int[] twoRepeated(int arr[], int N)
    {
        int[] ans = new int[2];
        int cnt = 0;

        for(int i=0; i< arr.length; i++){
            arr[(arr[i] - 1) % arr.length] = (arr[(arr[i] - 1) % arr.length]) + arr.length;

            if(arr[(arr[i] - 1) % arr.length] / arr.length >= 2){
                ans[cnt++] = (arr[i] - 1) % arr.length + 1;
            }
        }
        return ans;
    }
}
