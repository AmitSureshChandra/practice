package com.dsa.practice.algo.sorting;

public class MergeSort {

    static void print(int[] a){
        for (int i :
                a) {
            System.out.print(i + " ");
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,2,1,6,10,11,45,23,43,23,21};
        print(new MergeSort().sort(a));
//        print(new MergeSort().merge(new int[]{1,3,5,7}, new int[]{2,4,6}));
    }
    public int[] sort(int[] arr){

        // base condition

        if(arr.length == 1){
            return new int[]{arr[0]};
        }

        if(arr.length == 2){
            return arr[0] < arr[1] ? new int[]{arr[0], arr[1]} : new int[] {arr[1], arr[0]};
        }

        // recur

        int mid = arr.length / 2;

        int[] p1 = new int[mid];

        for (int i = 0; i < p1.length; i++) {
            p1[i] = arr[i];
        }

        int[] p2 = new int[arr.length - mid];

        for (int i = p1.length; i < arr.length; i++) {
            p2[i - p1.length] = arr[i];
        }

        return merge(sort(p1), sort(p2));
    }

    private int[] merge(int[] ar1, int[] ar2) {


        // merge

        int[] ans = new int[ar1.length + ar2.length];
        int index = 0;

        int i = 0;
        int j = 0;

        while(i < ar1.length && j < ar2.length){
            if(ar1[i] < ar2[j]){
                ans[index] = ar1[i++];
            }else{
                ans[index] = ar2[j++];
            }
            index++;
        }

        // ar1 is fully used

        while (i < ar1.length){
            ans[index++] = ar1[i++];

        }

        // ar2 is fully used

        while (j < ar2.length){
            ans[index++] = ar2[j++];
        }

        // both fully used

        return  ans;
    }
}
