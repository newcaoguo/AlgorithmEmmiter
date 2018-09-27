import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseLinkedListToArrayList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> mIntegerStack = new Stack<>();
        while (listNode != null) {
            mIntegerStack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> mList = new ArrayList<>();

        for (; !mIntegerStack.isEmpty(); ) {
            mList.add(mIntegerStack.pop());
        }
        return mList;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        second.next = new ListNode(3);
        ArrayList<Integer> mIntegers = printListFromTailToHead(head);
        for (Integer a : mIntegers) {
            System.out.print(a + " ");
        }
    }
}
