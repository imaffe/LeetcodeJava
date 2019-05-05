package Medium;

public class M143ReorderList {
    public void reorderList(ListNode head) {
        ListNode alwaysHead = head;
        ListNode first = head;
        ListNode second, third, fourth;
        while (first != null) {
            if (first.next == null || first.next.next == null) break;
            second = first.next;
            third = findTail(first);
            fourth = third.next;
            first.next = fourth;
            fourth.next = second;
            third.next = null;

            // iterate to another;
            first = second;
        }

    }
    public ListNode findTail(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode tail = head;
        while (tail.next.next != null) tail = tail.next;
        return tail;
    }
}
