package Medium;

public class M147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        //NextAction
        if (head == null) return null;
        ListNode dummy = new ListNode(-10000000);
        dummy.next = head;
        ListNode tailOfSorted = head;

        while (tailOfSorted.next != null) {
            int nextValue = tailOfSorted.next.val;
            ListNode cursor = dummy;
            while(cursor != tailOfSorted && cursor.next != null && cursor.next.val <= nextValue) cursor = cursor.next;
            // find the next largest possible
            if (cursor.next == null || cursor.next.val == nextValue) {
                // just go to next and change tail
                tailOfSorted = tailOfSorted.next;
                continue;
            }

            // change pointers
            ListNode toInsert = tailOfSorted.next;
            ListNode toInsertNext = toInsert.next;
            ListNode cursorNext = cursor.next;
            cursor.next = toInsert;
            toInsert.next = cursorNext;
            tailOfSorted.next = toInsertNext;

        }

        return dummy.next;
    }

}
