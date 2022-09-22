// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1

class IPL2021MatchDay2 {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k-1; i++) {
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]){
                deque.removeLast();
            }
            deque.add(i);
        }

        for (int i = k-1; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]){
                deque.removeLast();
            }
            
            while(!deque.isEmpty() && deque.getFirst() < i-k+1){
                deque.removeFirst();
            }
            
            deque.add(i);
            ans.add(arr[deque.getFirst()]);
            if(deque.size() == k){
                deque.removeFirst();
            }
        }
        return ans;
    }
}
