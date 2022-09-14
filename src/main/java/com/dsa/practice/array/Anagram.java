package com.dsa.practice.array;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(Anagram.isAnagram("geeksforgeeks", "forgeeksgeeks"));
    }

    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {

        Map<Character, Integer> map = new HashMap<>();

        if(a.length() != b.length()) {
            return false;
        }

        for(int i=0; i< a.length(); i++){
            if(map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), map.get(a.charAt( i )) + 1);
            }else{
                map.put(a.charAt(i), 1);
            }
        }

        for(int i=0; i< b.length(); i++){
            if(map.containsKey(b.charAt(i))){
                if(map.get(b.charAt( i )) == 1){
                    map.remove(b.charAt(i));
                }else
                    map.put(b.charAt(i), map.get(b.charAt( i )) - 1);
            }else{
                return false;
            }
        }

        if(map.size() == 0){
            return true;
        }

        return false;

    }
}
