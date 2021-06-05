package Medium;

public class E21MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while( l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }

        return dummy.next;
    }
}
