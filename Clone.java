package com.company;

import java.util.HashMap;

public class Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 输入一个复杂链表
     * （每个节点中有节点值，以及两个指针，
     * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的 head
     * （注意，输出结果中请不要返回参数中的节点引用，
     * 否则判题程序会直接返回空）
     */
    HashMap<RandomListNode, RandomListNode> hash = new HashMap<>();

    // hashmap + 递归
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode node = new RandomListNode(pHead.label);
        hash.put(pHead, node);
        node.next = Clone(pHead.next);
        node.random = hash.get(pHead.random);
        return node;
    }

    /**
     * 第一轮遍历：
     * 依次复制节点，并将复制后的节点以此放到被复制的节点的后面，
     * 重新组成一个链表
     * A->B->C ------>> A->A'->B->B'->C->C'
     * 此时只赋值next的指针
     * <p>
     * 第二轮遍历
     * 更新每一个复制节点的random指针，
     * 由于每个节点都是成对出现的，
     * 所以复制节点的random在被复制节点的 random 的 next
     * <p>
     * 第三轮遍历
     * 将链表拆开，并返回头结点。
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode curr = pHead;
        while (curr != null) {
            RandomListNode node = new RandomListNode(curr.label);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }
        curr = pHead;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = pHead.next;
        RandomListNode head = curr;
        while (pHead != null) {
            pHead.next = curr.next;
            pHead = pHead.next;
            if (pHead != null) {
                curr.next = pHead.next;
                curr = curr.next;
            }
        }
        return head;
    }

}
