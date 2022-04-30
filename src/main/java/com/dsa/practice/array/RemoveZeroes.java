package com.dsa.practice.array;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveZeroes {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] ar = new int[] { 0, 0, 0, 3, 12 };

		for (int a : ar) {
			System.out.print(a);
		}

		System.out.println("");
		new RemoveZeroes().moveZeroes(ar);

		for (int a : ar) {
			System.out.print(a);
		}
	}

	public void moveZeroes(int[] nums) {

		int ptr1 = -1;

		for(int i=0;i< nums.length; i++){
			if(nums[i] == 0 && ptr1 == -1){
				ptr1 = i;
				continue;
			}

			if((nums[i] != 0 && ptr1 == -1) || (nums[i] == 0) && ptr1 != -1){
				continue;
			}

			if(nums[i] != 0 && ptr1 != -1){
				swap(i, ptr1, nums);

				while(ptr1 <= i){
					if(nums[ptr1] == 0){
						break;
					}
					ptr1++;
				}
			}
		}

	}

	private void swap(int i, int ptr1, int[] nums) {
		int temp = nums[ptr1];
		nums[ptr1] = nums[i];
		nums[i] = temp;
	}
}
