package Medium;

public class M328OddEvenLinkedLists {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddLast = head;
        ListNode evenLast = head.next;
        ListNode even = head.next;
        while (evenLast != null && evenLast.next != null) {
            oddLast.next = oddLast.next.next;
            evenLast.next = evenLast.next.next;
            oddLast = oddLast.next;
            evenLast = evenLast.next;
        }
        oddLast.next = even;
        return head;
    }
}
