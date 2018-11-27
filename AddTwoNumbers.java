package com.company;

import org.junit.Test;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(5);
        /*ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node1.next = node12;
        node12.next = node13;*/
        ListNode node2 = new ListNode(5);
        /*ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(7);
        node2.next = node22;
        node22.next = node23;*/

        ListNode listNode = addTwoNumbers(node1, node2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
