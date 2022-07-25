package com.dsa.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

	public static void main(String[] args) {
//		System.out.println(new EditDistance().editDistance("ecfbefdcfca", "badfcbebbf"));
		System.out.println(new EditDistance().editDistance2("ecfbefdcfca", "badfcbebbf"));
	}

	private int editDistance2(String s, String t) {

		// bottom-up

		int[][] arr = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = i;
		}

		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = i;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1];
					continue;
				}

				int insert = arr[i][j - 1];
				int delete = arr[i - 1][j];
				int replace = arr[i - 1][j - 1];
				arr[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
			}
		}

//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println("");
//
//		}

		return arr[arr.length - 1][arr[0].length - 1];
	}

	public int editDistance(String s, String t) {
		Map<String, Integer> map = new HashMap<>();
		return edit(s, t, map, s.length(), t.length());
	}

	private int edit(String s, String t, Map<String, Integer> map, int slen, int tlen) {

		if (tlen == 0) {
			return slen;
		}

		if (slen == 0) {
			return tlen;
		}

		// check last digit equality
		if (s.charAt(slen - 1) == t.charAt(tlen - 1)) {

			if (!map.containsKey((slen - 1) + "_" + (tlen - 1))) {
				map.put((slen - 1) + "_" + (tlen - 1), edit(s, t, map, slen - 1, tlen - 1));
			}

			return map.get((slen - 1) + "_" + (tlen - 1));
		}

		// insert

		if (!map.containsKey((slen) + "_" + (tlen - 1))) {
			map.put((slen) + "_" + (tlen - 1), edit(s, t, map, slen, tlen - 1) + 1);
		}

		int insert = map.get((slen) + "_" + (tlen - 1));

		// remove

		if (!map.containsKey((slen - 1) + "_" + (tlen))) {
			map.put((slen - 1) + "_" + (tlen), edit(s, t, map, slen - 1, tlen) + 1);
		}

		int remove = map.get((slen - 1) + "_" + (tlen));

		// replace

		if (!map.containsKey((slen - 1) + "_" + (tlen - 1))) {
			map.put((slen - 1) + "_" + (tlen - 1), edit(s, t, map, slen - 1, tlen - 1) + 1);
		}

		int replace = map.get((slen - 1) + "_" + (tlen - 1));

		System.out.println(map);

		return Math.min(replace, Math.min(insert, remove));
	}
}
