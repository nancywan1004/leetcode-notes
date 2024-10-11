public class DoubleEndedQueue {

    private Node dummyHead;
    private Node dummyTail;
    public DoubleEndedQueue() {
        dummyHead = new Node(0);
        dummyTail = new Node(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public boolean isEmpty() {
        return dummyHead.next == dummyTail;
    }

    public void append(int value) {
       Node node = new Node(value);
       node.prev = dummyTail.prev;
       node.next = dummyTail;
       dummyTail.prev.next = node;
       dummyTail.prev = node;
       
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    public int pop() {
        if (isEmpty()) return -1;
        Node nodeToPop = dummyTail.prev;
        dummyTail.prev = nodeToPop.prev;
        nodeToPop.prev.next = dummyTail;
        return nodeToPop.value;
    }

    public int popleft() {
        if (isEmpty()) return -1;
        Node nodeToPop = dummyHead.next;
        dummyHead.next = nodeToPop.next;
        nodeToPop.next.prev = dummyHead;
        return nodeToPop.value;
    }

    public class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }
}
