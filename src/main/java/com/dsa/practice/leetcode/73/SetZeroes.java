// https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;

        // to hold whether first row is not all zeroes
        boolean r0 = true;

        for(int i: matrix[0]){
            if(i == 0) {
                r0 = false;
                break;
            }
        }

        // to hold whether first column is not all zeroes
        boolean c0 = true;

        for(int i=0; i< r; i++){
            if(matrix[i][0] == 0) {
                c0 = false;
                break;
            }
        }

        // store (1,1) to (r-1, c-1) in 1st row & column 
        for(int i=0; i< r; i++){
            for(int j=1; j< c; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        // apply zero's according to first row & column

        for(int i=1; i< c; i++){
            if(matrix[0][i] == 0) {
                for(int j=1; j< r; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i=1; i< r; i++){
            if(matrix[i][0] == 0) {
                for(int j=1; j< c; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // fill zeroes in first rows
        if(!r0) {
            Arrays.fill(matrix[0], 0);
        }

        // fill 1st columns
        if(!c0)
        for(int i=0; i< r; i++){
            matrix[i][0] = 0;
        }
    }
}
