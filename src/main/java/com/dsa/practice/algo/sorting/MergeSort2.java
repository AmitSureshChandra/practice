package com.dsa.practice.algo.sorting;

public class MergeSort2 {
    static void print(int[] a){
        for (int i :
                a) {
            System.out.print(i + " ");
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,2,1,6,10,11,45,23,43,23,21};
        new MergeSort2().sort(a, 0, a.length-1);
        print(a);
    }

    private void sort(int[] a, int l, int r) {

        if(l >= r){
            return;
        }

        int mid = (l + r) / 2;
        sort(a, l, mid);
        sort(a, mid+1, r);
        merge(a, l, r, mid+1);
    }

    private void merge(int[] a, int l, int r, int mid) {
        int i = l;
        int j = mid;

        int[] arr = new int[r-l+1];
        int cnt = 0;

        while(i <= mid-1 && j <= r){
            if(a[i] < a[j]){
                arr[cnt++] = a[i++];
            }else{
                arr[cnt++] = a[j++];
            }
        }

        while(i <= mid-1){
            arr[cnt++] = a[i++];
        }

        while(j <= r){
            arr[cnt++] = a[j++];
        }

        for (i = l; i <= r ; i++) {
            a[i] = arr[i - l];
        }
    }
}
