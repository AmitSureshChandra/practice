package com.dsa.practice.recursion;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1,
                    new ListNode(2,
                                new ListNode(3,
                                            new ListNode(4,
                                                        new ListNode(5)
                                                    )
                                        )
                            )
                );

        ListNode head = new ReverseLinkList().reverseList(node);

        while (head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        return reverse(null, head, null);
    }

    ListNode reverse(ListNode prev, ListNode current, ListNode next){
        if(current == null){
            return prev;
        }

        next = current.next;
        current.next = prev;
        prev = current;
        current = next;

        return reverse(prev, current, next);
    }
}
