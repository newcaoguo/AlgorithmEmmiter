package com.company;

public class MergeSortedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //运行时间：20ms
    //占用内存：9492k
    // 输入两个单调递增的链表，
    // 输出两个链表合成后的链表，
    // 当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tmp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        while (list1 != null) {
            tmp.next = new ListNode(list1.val);
            list1 = list1.next;
            tmp = tmp.next;
        }
        while (list2 != null) {
            tmp.next = new ListNode(list2.val);
            list2 = list2.next;
            tmp = tmp.next;
        }
        return node.next;
    }

}
