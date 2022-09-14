package com.dsa.practice.dp;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingPath {

    public static void main(String[] args) {
//        int[][]matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int[][]matrix = {{9,9,4},{6,6,8},{2,1,1}};
//        assertEquals(4, new LongestIncreasingPath().longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] store = new int[row][];
        for(int i=0; i< row; i++){
            store[i] = new int[col];
        }

        int max = 0;

        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                store[i][j] = -1;
            }
        }

        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                if(store[i][j] == -1){
                    store[i][j] = getLongestPath(matrix, i, j, row, col, store);
                    max = Math.max(max, store[i][j]);
                }
            }
        }

        for (int[] arr: store){
            System.out.println(Arrays.toString(arr));
        }

        return max;
    }

    int getLongestPath(int[][] matrix, int x, int y, int r, int c, int[][] store){
        if(x >= r || y >= c){
            return 0;
        }

        int right = 0;
        int left = 0;
        int top = 0;
        int bottom = 0;

        if(x+1 < r && matrix[x][y] < matrix[x+1][y]){

            int temp = store[x+1][y];
            if(temp == -1){
                temp = getLongestPath(matrix, x+1, y, r, c ,store);
                store[x+1][y] = temp;
            }
            right = ++temp;
        }

        if(x > 0 && matrix[x][y] < matrix[x-1][y]){
            int temp = store[x-1][y];
            if(temp == -1){
                temp = getLongestPath(matrix, x-1, y, r, c, store);
                store[x-1][y] = temp;
            }
            left = ++temp;
        }

        if(y+1 < c && matrix[x][y] < matrix[x][y+1]){
            int temp = store[x][y+1];
            if(temp == -1){
                temp = getLongestPath(matrix, x, y+1, r, c, store);
                store[x][y+1] = temp;
            }
            bottom = ++temp;
        }

        if(y > 0 && matrix[x][y] < matrix[x][y-1]){
            int temp = store[x][y-1];
            if(temp == -1){
                temp = getLongestPath(matrix, x, y-1, r, c, store);
                store[x][y-1] = temp;
            }
            top = ++temp;
        }

        return (int)Math.max(1, Math.max(top, Math.max(bottom, Math.max(left, right))));
    }
}
