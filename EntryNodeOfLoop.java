package com.company;

import org.junit.Test;

public class EntryNodeOfLoop {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead.next == null || pHead.next.next == null)
            return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast != null) {
            if (fast == slow) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    @Test
    public void test() {

    }
}
