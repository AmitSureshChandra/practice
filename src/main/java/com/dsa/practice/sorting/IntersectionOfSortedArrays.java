package com.dsa.practice.sorting;

import java.util.Arrays;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,4,7,9,9}, new int[]{2,4,7,9,9,11})));
    }

    static int[] intersection(int[]a, int[] b){
        int[] ans = new int[a.length + b.length];

        int a1 = 0;
        int b1 = 0;
        int ans1 = 0;

        while(a1 < a.length && b1 < b.length){
            if(a[a1] < b[b1]){
                if(ans1 == 0 || ans[ans1-1] != a[a1]){
                    ans[ans1++] = a[a1];
                }
                a1++;
            }else {
                if(ans1 == 0 || ans[ans1-1] != b[b1]){
                    ans[ans1++] = b[b1];
                }
                b1++;
            }
        }

        while(a1 < a.length){
            if(ans[ans1] != a[a1]){
                ans[ans1++] = a[a1++];
            }
        }

        while(b1 < b.length){
            if(ans[ans1] != b[b1]){
                ans[ans1++] = b[b1++];
            }
        }

        return ans;
    }
}
