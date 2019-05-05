package Medium;

public class M086PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = dummy;
        ListNode anotherChainDummy = new ListNode(-1);
        ListNode anotherChainTail = anotherChainDummy;
        while (iter.next != null) {
            if (iter.next.val >= x) {
               // delete to another tail
                ListNode cur = iter.next;
                iter.next = cur.next;
                anotherChainTail.next = cur;
                cur.next = null;
                anotherChainTail = cur;
            } else {
                iter = iter.next;
            }
        }
        iter.next = anotherChainDummy.next;
        return dummy.next;

    }

}
