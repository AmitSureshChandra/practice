package com.dsa.practice.array;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicate {

    public static void main(String[] args) {
        System.out.println(new FirstDuplicate().solution(new int[] {2, 1, 3, 5, 3, 2}));
    }
    int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< a.length; i++){
            if(!map.containsKey(a[i])){
                map.put(a[i], 1);
            }else{
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        
        int pos = Integer.MAX_VALUE;
        int ans = -1;

        for(int i: map.keySet()){
            if(map.get(i) > 1){

                int temp_pos = searchDuplicate(a, i);
                if(pos > temp_pos){
                    pos = temp_pos;
                    ans = i;
                }
            }
        }

        return ans;
    }

    private int searchDuplicate(int[] a, Integer integer) {
        boolean firstSearched = false;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == integer){
                if(firstSearched){
                    return i;
                }

                firstSearched = true;
            }
        }

        return -1;
    }
}
