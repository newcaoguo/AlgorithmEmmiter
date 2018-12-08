package com.company;

import org.junit.Test;

public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode first = start;
        for (int i = 0; i < n + 1 && first != null; i++) {
            first = first.next;
        }
        ListNode second = start;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return start.next;
    }

    @Test
    public void test() {
        ListNode listNode = removeNthFromEnd(new ListNode(1), 1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
