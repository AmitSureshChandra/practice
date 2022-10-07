// https://practice.geeksforgeeks.org/problems/max-and-min-products3347/1

class MaxMinProducts 
{
    
    int negatives = 0;
    int zeroes = 0;
    long mul = 1l;
    long min;
    long negativeLarge = Integer.MIN_VALUE;
       
    long[] ans = new long[2];
        
    long[] getMaxandMinProduct(int arr[], int n)  
    {
        
        if(n == 1){
            return new long[]{arr[0], arr[0]};
        }

        min = arr[0];
        
        for(int i: arr){
            min = Math.min(min, i);
            
            if(i < 0 && i > negativeLarge){
                negativeLarge = i;
            }
            
            if(i == 0) zeroes++;
            else if (i < 0){
                 negatives++;
                 mul *= i;
            }
            else mul *= i;
        }
        
        // max 
        ans[1] = getMaxProd(arr, n);
        
        // min
        ans[0] = getMinProd(arr, n);
        
        return ans;  
    }
    
    long getMinProd(int arr[], int n){
        if(negatives == 0 && zeroes > 0){
            return  0;
        }
        if(negatives == 0 && zeroes == 0){
            return min;
        }
        else if((negatives & 1) > 0){
            return mul;
        }else{
            return mul / negativeLarge;
        }
    }
    
    long getMaxProd(int[] arr, int n){
         if(negatives == 0 || (negatives & 1) == 0){
            return mul;
        }
        if(negatives == 1 && zeroes ==  n-1){
            return 0;
        }
        else{
            return mul / negativeLarge;
        }
    }
}
