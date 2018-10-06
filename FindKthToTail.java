import org.testng.annotations.Test;

public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 输入一个链表，输出该链表中倒数第k个结点。
    /*public ListNode FindKthToTail(ListNode head, int k) {
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
    }*/
    // 备注：要求只遍历一次就完成操作
    public ListNode FindKthToTail(ListNode head, int k) {
        // 双指针做法，第一个指针先走 k - 1 步
        // 然后，第二个指针和第一个指针开始同步走
        // 当，第一个指针走到结束的时候，第二个指针恰好在倒数第 k 个结点处
        if (head == null) return head;
        ListNode iNode = head;
        ListNode jNode = head;
        if (k - 1 < 0) return null;
        // i 指针向前走 k -1 步
        for (int i = 0; i < k - 1; i++) {
            iNode = iNode.next;
        }
        if (iNode == null) return iNode;
        for (; iNode.next != null; ) {
            iNode = iNode.next;
            jNode = jNode.next;
        }
        return jNode;
    }

    @Test
    public void test() {

    }

}
