// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

class MinimumCostOfRopes
{
    long minCost(long arr[], int n) 
    {
        if(n == 1){
            return 0;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long l: arr){
            pq.add(l);
        }
        
        long sum = 0;
        
        while(!pq.isEmpty()){
            long t = pq.poll();
            
            if(!pq.isEmpty()){
                t+= pq.poll();
            }
            
            sum += t;
            
            if(!pq.isEmpty()){
                pq.add(t);
            }
        }
        
        return sum;
    }
}
