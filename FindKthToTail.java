import org.testng.annotations.Test;

import java.util.Stack;

public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        // 备注：要求只遍历一次就完成操作
        ListNode tmp = head;
        Stack<ListNode> mListNodeStack = new Stack<>();
        while (tmp != null) {
            mListNodeStack.push(tmp);
            tmp = tmp.next;
        }

        for (int i = 0; i < k; i++) {
            if (mListNodeStack.isEmpty()) return null;
            tmp = mListNodeStack.pop();
        }
        return tmp;
    }

    @Test
    public void test() {

    }

}
