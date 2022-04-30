package com.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new StringPermutation().find_permutation(sc.next(), 0);
		System.out.println(list);
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));

		System.out.println(list);
	}

	private List<String> find_permutation(String str, Integer pos) {
		List<String> list = new ArrayList<>();

		if (pos >= str.length() - 1) {
			list.add(str);
			return list;
		}

		for (int i = pos; i < str.length(); i++) {
			// DO
			str = swap(str, i, pos);

			// Recur
			list.addAll(find_permutation(str, pos + 1));

			// UNDO
			str = swap(str, pos, i); // O(n)
		}

		return list;
	}

	private String swap(String str, int i, Integer pos) {
		String[] ar = str.split("");

		String temp = ar[i];
		ar[i] = ar[pos];
		ar[pos] = temp;

		return String.join("", ar);
	}
}
