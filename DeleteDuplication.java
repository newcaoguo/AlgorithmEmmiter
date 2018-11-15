package com.company;

import org.junit.Test;

public class DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 指向当前结点前最晚访问过的不重复结点
        ListNode pPre = null;
        // 指向当前处理的结点
        ListNode pCur = pHead;
        // 指向当前结点后面的结点
        ListNode pNext = null;
        while (pCur != null) {
            // 如果当前结点与下一个结点相同
            if (pCur.next != null && pCur.val == pCur.next.val) {
                pNext = pCur.next;
                // 找到不重复的最后一个结点位置
                while (pNext.next != null &&
                        pNext.next.val == pCur.val) {
                    pNext = pNext.next;
                }
                // 如果pCur指向链表中第一个元素，pCur -> ... -> pNext ->...
                // 要删除pCur到pNext, 将指向链表第一个元素的指针pHead指向pNext->next。
                if (pCur == pHead) {
                    pHead = pNext.next;
                } else {
                    // 如果pCur不指向链表中第一个元素，pPre -> pCur ->...->pNext ->...
                    // 要删除pCur到pNext，即pPre->next = pNext->next
                    pPre.next = pNext.next;
                }
                // 向前移动
                pCur = pNext.next;
            } else {// 如果当前结点与下一个结点不相同
                pPre = pCur;
                pCur = pCur.next;
            }
        }
        return pHead;

    }

    @Test
    public void test() {

    }
}
