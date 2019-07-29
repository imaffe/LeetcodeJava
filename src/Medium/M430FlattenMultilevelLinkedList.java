package Medium;


public class M430FlattenMultilevelLinkedList {
    public Node flatten(Node head) {
        Node start = head;
        while(start != null) {
            mergeToRight(start);
        }

        // TODO , whether on both sides
        return null;
    }

    public void mergeToRight(Node cur) {
        if (cur.child == null) return;
        else {
            Node lowerHead = flatten(cur.child);
            Node upperHead = cur;
            while (lowerHead != null && upperHead != null) {
            }

        }
    }
}
