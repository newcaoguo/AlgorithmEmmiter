package com.company;

import org.junit.Test;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode(-1);
        ListNode p = listNode;
        if (lists == null || lists.length == 0) return listNode.next;
        while (true) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            int count = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
                if (lists[i] == null) count++;
            }
            if (count == lists.length) break;
            p.next = lists[index];
            lists[index] = lists[index].next;
            p = p.next;
        }
        return listNode.next;
    }

    /**
     * Input:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */
    @Test
    public void test() {
        ListNode firstNode = new ListNode(1);
        ListNode firstSecNode = new ListNode(4);
        ListNode firstThirdNode = new ListNode(5);
        firstNode.next = firstSecNode;
        firstSecNode.next = firstThirdNode;

        ListNode firstNode2 = new ListNode(1);
        ListNode firstSecNode2 = new ListNode(3);
        ListNode firstThirdNode2 = new ListNode(4);
        firstNode2.next = firstSecNode2;
        firstSecNode2.next = firstThirdNode2;

        ListNode firstNode3 = new ListNode(2);
        ListNode firstSecNode3 = new ListNode(6);
        firstNode3.next = firstSecNode3;

        ListNode listNode = mergeKLists(new ListNode[]{firstNode, firstNode2, firstNode3});
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
