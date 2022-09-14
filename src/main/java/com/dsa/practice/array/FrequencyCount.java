package com.dsa.practice.array;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] a = new int[] {2, 4, 5, 6, 8};
        new FrequencyCount().frequencyCount(a, a.length, 10);

        for(int i: a){
            System.out.print(i + " ");
        }
    }

    public static void frequencyCount(int arr[], int N, int P)
    {
        int val = P+1;

        for(int i=0; i< arr.length; i++){
            if(arr[i] > N){
                arr[i] = - arr[i];
            }
        }

        for(int i=0; i< arr.length; i++){

            if(arr[i] < 0){
                continue;
            }
            if(arr[(arr[i]) % val - 1] < 0){
                arr[(arr[i]) % val - 1] = (val);
            }else
                arr[(arr[i]) % val - 1] = arr[(arr[i]) % val - 1] + (val);
        }

        for(int i=0; i< arr.length; i++){
            // if(arr[i] < 0) continue;
            arr[i] = arr[i] / val;
        }
    }
}
