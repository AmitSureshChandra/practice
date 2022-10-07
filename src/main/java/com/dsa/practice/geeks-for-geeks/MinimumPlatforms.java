// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

class MinimumPlatforms
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        PriorityQueue<Temp> pq = new PriorityQueue<>((i1, i2) -> {
            if(i1.val == i2.val)  return i1.c - i2.c;
            return i1.val - i2.val;
        });
        
        for(int i=0; i< arr.length; i++)  pq.add(new Temp(arr[i], 'a'));
        for(int i=0; i< dep.length; i++)  pq.add(new Temp(dep[i], 'd'));
        int max = 0, cnt = 0;
        while(!pq.isEmpty()){
            if(pq.poll().c == 'a')  cnt++;
            else cnt--;
            max = Math.max(cnt, max);
        }
        return max;
    }
}
