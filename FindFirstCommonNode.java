package com.company;

import org.junit.Test;

public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int getListNodeLength(ListNode pHead) {
        int count = 0;
        while (pHead != null) {
            count++;
            pHead = pHead.next;
        }
        return count;
    }

    //输入两个链表，找出它们的第一个公共结点。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int pHead1Length = getListNodeLength(pHead1);
        int pHead2Length = getListNodeLength(pHead2);
        if (pHead1Length == 0 || pHead2Length == 0) return null;
        if (pHead1Length < pHead2Length) {
            ListNode tmp = pHead1;
            pHead1 = pHead2;
            pHead2 = tmp;
        }
        for (int i = 0; i < Math.abs(pHead1Length - pHead2Length); i++) {
            pHead1 = pHead1.next;
        }
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    @Test
    public void test() {
        // 公共结点是第一个结点
        // 1 - 2 - 3 - 4 - 5
        // 两个链表完全重合
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(FindFirstCommonNode(n1, n1).val); // 1
    }
}
