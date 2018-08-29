public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * [-9,3]
         * [5,7]
         */
        ListNode result = new ListNode(0);
        ListNode headResult = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                result.next = new ListNode(l2.val); // -9 3
                l2 = l2.next;
            } else {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            result = result.next;
        }
        while (l1 != null) {
            result.next = new ListNode(l1.val);
            l1 = l1.next;
            result = result.next;
        }
        while (l2 != null) {
            result.next = new ListNode(l2.val);
            l2 = l2.next;
            result = result.next;
        }
        headResult = headResult.next;
        return headResult;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-9);
        node1.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(7);
        ListNode listNode = mergeTwoLists(node1, node2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
