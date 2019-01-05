package com.company;

import org.junit.Test;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode copyHead = head;
        int len = 1;
        while (head != null) {
            len++;
            copyHead = copyHead.next;
        }
        for (int i = len - k % len; i > 1; i--) {
            head = head.next;
        }
        copyHead = head.next;
        head.next = null;
        return copyHead;
    }

    @Test
    public void test() {

    }
}
