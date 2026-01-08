import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortLinkedListUsingMergeSort {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep) {
            System.out.print("[");
            while (node.next != null) {
                System.out.print(String.valueOf(node.data) + sep);
                node = node.next;
            }
            System.out.print(node.data);
            System.out.println("]");
        }
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedListNode node = new SinglyLinkedListNode(5);
        node.next = new SinglyLinkedListNode(2);
        node.next.next = new SinglyLinkedListNode(7);
        node.next.next.next = new SinglyLinkedListNode(1);
        node.next.next.next.next = new SinglyLinkedListNode(6);
        node.next.next.next.next.next = new SinglyLinkedListNode(4);
        node = sort(node);
        SinglyLinkedListPrintHelper.printList(node, ",");
    }

    private static SortLinkedListUsingMergeSort.SinglyLinkedListNode sort(
            SortLinkedListUsingMergeSort.SinglyLinkedListNode node) {

        // Base case: if list is empty or has only one node, return it
        if (node == null || node.next == null) {
            return node;
        }

        SinglyLinkedListNode head = node;
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        SinglyLinkedListNode prev = null;
        
        // Find the middle of the list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list: break the link between first and second half
        if (prev != null) {
            prev.next = null;
        }
        
        // Recursively sort both halves
        SinglyLinkedListNode l1 = sort(head);
        SinglyLinkedListNode l2 = sort(slow);

        return merge(l1, l2);

    }

    private static SortLinkedListUsingMergeSort.SinglyLinkedListNode merge(
            SortLinkedListUsingMergeSort.SinglyLinkedListNode l1,
            SortLinkedListUsingMergeSort.SinglyLinkedListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        return dummy.next;
    }

}
