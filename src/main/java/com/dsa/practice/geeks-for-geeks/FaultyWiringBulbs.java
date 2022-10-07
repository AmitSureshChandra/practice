// https://practice.geeksforgeeks.org/problems/faulty-wiring-and-bulbs2939/1

class FaultyWiringBulbs
{
    public static int countFlips(int a[], int n)
    {
        int ans = 0;
        for(int i=0; i< a.length; i++){
            if(isEven(ans) && a[i] == 1 || !isEven(ans) && a[i] == 0){
                continue;
            }
            ans++;
        }
        return ans;
    }
    
    static boolean isEven(int n){
        return ((n&1) == 0);
    }
}
