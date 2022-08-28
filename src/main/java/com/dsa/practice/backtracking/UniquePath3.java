package com.dsa.practice.backtracking;

class UniquePath3 {
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(new UniquePath3().uniquePathsIII(grid));
	}

	public int uniquePathsIII(int[][] grid) {

		// count zeroes
		// find start & end pos

		int zeroes = 1;
		int start_x = -1;
		int start_y = -1;
		int end_x = -1;
		int end_y = -1;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				switch (grid[i][j]) {
				case 1:
					start_x = i;
					start_y = j;
					break;
				case 2:
					end_x = i;
					end_y = j;
					break;
				case 0:
					zeroes++;
					break;
				case -1:
				default:
					break;
				}
			}
		}

		return traverse(grid, start_x, start_y, end_x, end_y, start_x, start_y, zeroes);
	}

	// traverse from start to end with zeroes count

	int traverse(int[][] grid, int start_x, int start_y, int end_x, int end_y, int x, int y, int zeroes) {

		// Base Case

		if ((x < 0) || (y < 0) || (x >= grid.length) || (y >= grid[0].length)) {
			return 0;
		}

		if (grid[x][y] == -1) {
			return 0;
		}

		if (x == end_x && y == end_y) {
			if (zeroes == 0) {
				return 1;
			}
			return 0;
		}

		// DO

		int ways = 0;
		int temp = grid[x][y];
		grid[x][y] = -1;
		zeroes--;

		// Recurr

		// left
		ways += traverse(grid, start_x, start_y, end_x, end_y, ++x, y, zeroes);
		x--;

		// right
		ways += traverse(grid, start_x, start_y, end_x, end_y, --x, y, zeroes);
		x++;

		// top
		ways += traverse(grid, start_x, start_y, end_x, end_y, x, --y, zeroes);
		y++;

		// bottom
		ways += traverse(grid, start_x, start_y, end_x, end_y, x, ++y, zeroes);
		y--;

		// UNDO
		grid[x][y] = temp;
		zeroes++;

		return ways;
	}
}