package com.company;

import org.junit.Test;

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 翻转链表
    /*public ListNode ReverseList(ListNode head) {
        Stack<ListNode> mStack = new Stack<>();
        while (head != null) {
            mStack.push(head);
            head = head.next;
        }
        ListNode mListNode = new ListNode(-1);
        ListNode tmp = mListNode;
        while (!mStack.isEmpty()) {
            ListNode tmpNode = mStack.pop();
            mListNode.next = tmpNode;
            mListNode = mListNode.next;
        }
        mListNode.next = null;
        while (tmp != null) {
            System.out.println(tmp.next.val);
            tmp = tmp.next;
        }
        return tmp;
    }*/

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode r;
        head.next = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(10);
        ListNode b = new ListNode(8);
        a.next = b;
        ListNode c = new ListNode(13);
        b.next = c;
        c.next = null;
        ListNode mListNode = ReverseList(a);
        while (mListNode != null) {
            System.out.print(mListNode.val + " ");
        }
    }

}
