/**
**  https://leetcode.com/problems/partition-list/description/
*/

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        // find tail & last node
        ListNode tail = head;
        int cnt = 0;
        while(tail.next != null){
            tail = tail.next;
            cnt++;
        }

        ListNode last = tail;

        // all nodes from start which are >= x move then to at last 
        while(head.val >= x && cnt >= 0){
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = null;
            cnt--;
        }

        // move nodes at last if >= x
        ListNode n = head;
        while(n != null && n.next != null && cnt > 0){
            ListNode next = n.next;
            if(next.val < x){
                 n = n.next;
                 cnt--;
                 continue;  
            }
            tail.next = next;
            System.out.println(tail.val);
            n.next = next.next;
            tail = tail.next;
            tail.next = null;
            cnt--;
        }

        return head;
    }
}
