package Medium;

public class M148SortList {
    public ListNode sortList(ListNode head) {
        // using merge sort
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // get the listLength;
        int listLength = 0;
        ListNode iter = dummy.next;
        while (iter != null) {
            listLength ++;
            iter = iter.next;
        }
        // run the merge
        ListNode start = dummy;
        int batchLength = 1;
        while(batchLength < listLength) {
            start = dummy;
            while (start != null) {
                mergeFromDummy(start, batchLength);
                for (int i = 0 ; i < batchLength * 2 ; i++) {
                    if (start != null) start = start.next;
                    else break;
                }
            }
            batchLength *= 2;
        }
        return dummy.next;
    }

    public ListNode mergeFromDummy(ListNode dummy, int batchLength) {

        // if dummy is null, just return
        if (dummy.next == null) return null;

        // find the node after batch
        ListNode nodeAfterTail = dummy;
        for(int i = 0 ; i <= 2*batchLength; i++) {
            if (nodeAfterTail != null) nodeAfterTail = nodeAfterTail.next;
            else break;
        }



        ListNode left = dummy.next;
        ListNode leftHead = dummy.next;
        ListNode right = dummy.next;
        for (int i = 0 ; i < batchLength; i++) {
            right = right.next;
            if (right == null) return nodeAfterTail;
        }

        // right must exist
        ListNode rightHead = right;
        ListNode tail = dummy;


        // set leftTail value
        ListNode leftTail = left;
        for (int i = 0 ; i < batchLength -1 ; i ++) leftTail = leftTail.next;

        // set rightTail value
        ListNode rightTail = right;
        for (int i = 0 ; i < batchLength - 1; i++) {
            if (rightTail.next == null) break;
            else rightTail = rightTail.next;
        }

        // merge
        while (tail.next != nodeAfterTail) {
            if (left.val < right.val) {
                tail.next = left;
                tail = tail.next;
                if (left.next != rightHead) left = left.next;
                else {
                    // give all to
                    tail.next = right;
                    tail = rightTail;
                }
            } else {
                tail.next = right;
                tail = tail.next;
                if (right.next != nodeAfterTail) right = right.next;
                else {
                    tail.next = left;
                    tail = leftTail;
                    leftTail.next = nodeAfterTail;
                }
            }
        }
        return nodeAfterTail;
    }
}
