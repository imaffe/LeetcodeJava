package Medium;

public class SF006DeleteNodesGreaterThanx {
    public ListNode deleteNode(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null && cur.next != null){
            if(cur.next.val > x) {
                ListNode next= cur.next.next;
                cur.next = next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
