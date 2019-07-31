package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class H23MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ValueAndIndex> heap = new PriorityQueue<>(new Comparator<ValueAndIndex>(){
            @Override
            public int compare (ValueAndIndex a, ValueAndIndex b) {
                return a.value - b.value;
            }
        });

        // initialize
        for (int i = 0 ; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(new ValueAndIndex(lists[i].val, i));
            }
        }

        ListNode tail = new ListNode(-1); // dummy
        ListNode dummy = tail;
        while (!heap.isEmpty()) {
            ValueAndIndex head = heap.poll();
            tail.next = lists[head.index];
            lists[head.index] = lists[head.index].next;
            tail = tail.next;
            tail.next = null;
            if (lists[head.index] != null) heap.add(new ValueAndIndex(lists[head.index].val, head.index));
        }

        return dummy.next;
    }

    public class ValueAndIndex {
        int value;
        int index;
        ValueAndIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
