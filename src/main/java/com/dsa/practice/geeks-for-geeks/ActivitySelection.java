// https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1

class ActivitySelection
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        List<Temp> l = new ArrayList<Temp>();
        
        for(int i=0; i< start.length; i++){
            l.add(new Temp(start[i], end[i]));
        }
        
        Collections.sort(l, (i,j) -> i.end - j.end);
        
        int i=0, j= 1;
        int cnt = 1;
        
        while(i < j && j< n){
            if(l.get(i).end < l.get(j).start){
                cnt++;
                i = j;
                j = i+1;
            }else{
                j++;
            }
        }

        return cnt;
    }
}
