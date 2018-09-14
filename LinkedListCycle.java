public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p = head;
        ListNode q = head.next;
        while (p != null && q != null) {
            if (p == q) return true;
            try {
                p = p.next;
                q = q.next.next;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode data1 = new ListNode(1);
        ListNode data2 = new ListNode(2);
        data1.next = data2;
        ListNode data3 = new ListNode(3);
        data2.next = data3;
        data3.next = null;
        System.out.println(hasCycle(data1));
    }
}
