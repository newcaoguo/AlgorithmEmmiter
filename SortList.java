package com.company;

import org.junit.Test;

public class SortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // step 1. cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // step 2. sort each half
        ListNode listNode1 = sortList(head);
        ListNode listNode2 = sortList(slow);

        // step 3. merge listNode1 and listNode2
        return merge(listNode1, listNode2);
    }

    ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = new ListNode(0);
        ListNode p = listNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                p.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                p.next = listNode2;
                listNode2 = listNode2.next;
            }
            p = p.next;
        }

        if (listNode1 != null) p.next = listNode1;
        if (listNode2 != null) p.next = listNode2;
        return listNode.next;
    }

    @Test
    public void test() {

    }
}
