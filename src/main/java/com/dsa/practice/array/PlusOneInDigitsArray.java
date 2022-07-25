package com.dsa.practice.array;

/**
 * https://leetcode.com/problems/plus-one/
 */

public class PlusOneInDigitsArray {

    public static void main(String[] args) {
        for (int i :
                new PlusOneInDigitsArray().plusOne(new int[]{9})) {
            System.out.print(i + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int l = digits.length - 1;

        boolean carry = true;

        while(carry){

            digits[l] = ( digits[l] + 1 ) % 10;
            if(digits[l] != 0){
                break;
            }

            if(l == 0){
                digits = appendZero(digits);
                break;
            }
            l--;
        }

        return digits;

    }

    int[] appendZero(int[] nums){
        int[] res = new int[nums.length + 1];

        res[0] = 1;

        for(int i=0; i< nums.length; i++){
            res[i+1] = nums[i];
        }

        return res;
    }
}
