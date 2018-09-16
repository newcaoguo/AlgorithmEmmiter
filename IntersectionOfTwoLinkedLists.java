public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmpHeadA = headA;
        ListNode tmpHeadB = headB;
        while (tmpHeadA != tmpHeadB) {
            tmpHeadA = tmpHeadA.next;
            tmpHeadB = tmpHeadB.next;
            if (tmpHeadA == tmpHeadB) return tmpHeadA;
            if (tmpHeadA == null) tmpHeadA = headB;
            if (tmpHeadB == null) tmpHeadB = headA;
        }
        return tmpHeadA;
    }

    public static void main(String[] args) {

    }
}
