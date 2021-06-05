package Medium;

import java.util.HashMap;
import java.util.Map;

public class AmzHighFreq007CopyListWithRandomPointer {
    // use 1
    public Node copyRandom1(Node head) {
        Node dummyHead = new Node();
        Node curOld = head;
        Node tail = dummyHead;
        Map<Node, Node> map = new HashMap<>();
        while (curOld != null) {
            Node curNew = new Node();
            curNew.val = curOld.val;
            tail.next = curNew;
            map.put(curOld, curNew);
            tail = curNew;
        }

        curOld = head;
        Node curNew = dummyHead.next;
        while (curOld != null) {
            Node randomNext = map.get(curOld.random);
            curNew.random = randomNext;
        }

        return dummyHead.next;
    }

    public Node copyRandom(Node head) {
        // A* -> A -> B* -> B -> C* -> C
        // A -> A* -> B -> B* -> C -> C*
        // deal with normal pointers first
        Node dummyHead = new Node();
        dummyHead.next = head;
        Node curOld = head;
        if(head == null) return null;
        while(curOld != null) {
            Node newNode = new Node();
            newNode.val = curOld.val;

            newNode.next = curOld.next;
            curOld.next = newNode;

            curOld = curOld.next.next;
        }

        curOld = dummyHead.next;
        while(curOld != null){
            curOld.next.random = curOld.random == null ? null :  curOld.random.next;
            curOld = curOld.next.next;
        }


        Node curNew = dummyHead.next.next;
        curOld = dummyHead.next;

        Node start = curNew;
        while(curNew.next != null) {
            curOld.next = curNew.next;
            curNew.next = curNew.next.next;
            curOld = curOld.next;
            curNew = curNew.next;
        }
        curOld.next = null;
        return start;
    }
}
