package com.dsa.practice.sorting;

import java.util.ArrayList;
import java.util.List;

// Not complete
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] ans = merge(new int[][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
//                {1,4},
//                {4,5}
        });

        for (int[] arr :
                ans) {
            System.out.println(arr[0]+ ", " + arr[1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        for (int[] arr :
                intervals) {
            if (ans.size() != 0){

                int[] last = ans.get(ans.size()-1);

                if(last[1] >= arr[0] && last[1] < arr[1]){
                    last[1] = arr[1];
                }else {
                    // add if can't merge
                    ans.add(arr);
                }
                continue;
            }

            // add if list is empty
            ans.add(arr);
        }

        return ans.toArray(new int[ans.size()][]);
    }


}
