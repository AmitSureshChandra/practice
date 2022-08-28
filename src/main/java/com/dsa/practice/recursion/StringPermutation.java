package com.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(new StringPermutation().find_permutation(sc.next()));
	}

	public List<String> find_permutation(String S) {

		List<String> list = new ArrayList<>();

		strPermute(S, list, "");

		return list;
	}

	void strPermute(String S, List<String> list, String str) {

		if (S.length() == 0) {
			list.add(str);
			return;
		}

		for (int i = 0; i < S.length(); i++) {
			String temp = str + String.valueOf(S.charAt(i));
			strPermute(S.replace(S.charAt(i) + "", ""), list, temp);
		}
	}
}
