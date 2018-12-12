package com.company;

public class ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        int num = 0;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode curNode = preHead;
        ListNode nextNode;
        ListNode preNode = preHead;
        while ((curNode = curNode.next) != null) num++;
        while (num >= k) {
            curNode = preNode.next;
            nextNode = curNode.next;
            for (int i = 1; i < k; ++i) {
                curNode.next = nextNode.next;
                nextNode.next = preNode.next;
                preNode.next = nextNode;
                nextNode = curNode.next;
            }
            preNode = curNode;
            num -= k;
        }
        return preHead.next;
    }
}
