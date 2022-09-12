package LinkedList_CN;

public class Solution {
    ListNode head;
    static  class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val  = val;
            ListNode next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode tail = head;

        for (int i = 0; i < k; ++i) {
            if (tail == null) // less than k nodes, do nothing
                return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    // reverse [head, tail)
    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

//        [1,2,3,4,5]
        int k = 3;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseKGroup(head,k);




    }
}

