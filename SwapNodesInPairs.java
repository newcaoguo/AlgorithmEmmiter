package com.company;

import org.junit.Test;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //Given 1->2->3->4, you should return the list as 2->1->4->3.
    // -1 -> 1 -> 2 -> 3 -> 4
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode q = p;
        while (q != null) {
            ListNode tmpNode = q.next;
            if (tmpNode == null || tmpNode.next == null) return p.next;
            q.next = tmpNode.next;
            q = q.next;
            tmpNode.next = q.next;
            q.next = tmpNode;
            q = q.next;

        }
        return p.next;
    }

    @Test
    public void test() {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
//        firstNode.next = secondNode;
//        secondNode.next = thirdNode;
//        thirdNode.next = fourNode;
        ListNode listNode = swapPairs(firstNode);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
