package Medium;

public class M024SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = dummy;
        ListNode first = head;
        ListNode second = dummy;
        ListNode third = dummy;

        while (first != null) {
            if (first.next == null) {
                break;
            }
            second = first.next;
            third = second.next;
            // swap the two nodes
            last.next = second;
            second.next = first;
            first.next = third;

            // iterate to next
            last = first;
            first = third;

        }
        return dummy.next;
    }
}
