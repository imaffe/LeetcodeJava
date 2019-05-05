package Medium;

public class M019RemoveLastNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0 ; i < n + 1; i++){
            second = second.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
