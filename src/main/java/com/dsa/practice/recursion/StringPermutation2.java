package com.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(new StringPermutation().find_permutation(sc.next()));
	}

	List<String> permute(String str) {
		List<String> list = new ArrayList<String>();

		if (str.length() == 1) {
			list.add(str);
			return list;
		}

		for (int i = 0; i < str.length(); i++) {
			list = permute(str.replace(str.charAt(i) + "", ""));

			for (String s : list) {
				list.add(s + str.charAt(i));
			}
		}

		return list;
	}
}
