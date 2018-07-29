package com.newcaoguo.main.rxjavademo;

import java.util.Scanner;

/**
 * 判断一个单链表是否存在环
 */
public class LinkedListLoop {
    static class Node {
        int val;
        Node next;

        public Node() {

        }
    }

    private static final Node createLinkedListNode(Scanner scanner) {
        Node node = new Node();
        Node p = node;
        int val = scanner.nextInt();
        while (val != -1) {
            p.val = val;
            p.next = new Node();
            p = p.next;
            val = scanner.nextInt();
        }
        return node;
    }

    private static final void printLinkedListNode(Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    /**
     * 判断单链表是否存在环
     *
     * @param node
     * @return
     */
    private static final boolean isExitLoop(Node node) {
        Node p = node; // p 指向 单链表的第一个
        Node q = node.next;// q 指向 单链表的第二个
        // 如果 p 与 q 不相等 ，并且 p 不为空、q 不为空
        while (p != q && p != null && q != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node firstNode = new Node();
        firstNode.val = 1;
        Node secondNode = new Node();
        secondNode.val = 2;
        firstNode.next = secondNode;
        Node thirdNode = new Node();
        thirdNode.val = 3;
        secondNode.next = thirdNode;
        Node forthNode = new Node();
        forthNode.val = 4;
        thirdNode.next = forthNode;
        Node fifthNode = new Node();
        fifthNode.val = 5;
        forthNode.next = fifthNode;
//        fifthNode.next = thirdNode; // 形成闭环
        fifthNode.next = null; // 不形成闭环
//        printLinkedListNode(firstNode); // 输出单链表信息
        System.out.println("isExitLoop: " + isExitLoop(firstNode)); // 输出是否存在闭环
    }
}
