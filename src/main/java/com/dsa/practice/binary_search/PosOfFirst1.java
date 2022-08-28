package com.dsa.practice.binary_search;

public class PosOfFirst1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(firstIndex(new long[]{0, 0, 0}, 3));
    }
    public static long firstIndex(long arr[], long n) throws InterruptedException {
        long low = 0;
        long high = n-1;

        long pos = Long.MAX_VALUE;

        while(low <= high){

            long mid = low + (high - low) /2;

            if(low == high -1){

                if (arr[(int) low] == 1){
                    pos = low;
                }

                if (arr[(int) high] == 1){
                    pos = high;
                }
            }

            if(low == high){
                if(arr[(int) low] == 1){
                    pos = Math.min(pos, mid);
                    break;
                }
            }

            if(arr[(int) mid] == 0){
                low = mid + 1l;
            }else{
                pos = Math.min(pos, mid);
                high = mid;
            }
        }

        if(pos == Long.MAX_VALUE){
            return -1;
        }

        return pos;
    }
}
