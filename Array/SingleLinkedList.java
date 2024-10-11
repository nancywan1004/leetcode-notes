import java.util.*;
public class SingleLinkedList {

    private ListNode head;
    private ListNode tail;
    
    public SingleLinkedList() {
        head = new ListNode(-1); // dummy node, easier for removal from head
        tail = head;
    }

    public int get(int index) {
        ListNode curr = head.next;
        int i = 0;
        while (curr != null) {
            if (index == i) {
                return curr.value;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode curr = head.next;
        ListNode node = new ListNode(val);
        head.next = node;
        node.next = curr;
        if (node.next == null) {
            tail = node;
        }
    }

    public void insertTail(int val) {
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode curr = head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        // Remove the node ahead of curr
        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ListNode curr = head.next;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (curr != null) {
            res.add(curr.value);
            curr = curr.next;
        }
        return res;
    }

    public class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
