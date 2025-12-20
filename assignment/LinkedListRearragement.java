import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LinkedListRearragement {

    static class SinglyLinkedListNode {
        public long data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(long nodeData) {
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

        public SinglyLinkedList(long data) {
            this.head = new SinglyLinkedListNode(data);
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

    public static void main(String[] args) throws IOException {

        SinglyLinkedList l = new SinglyLinkedList();
        l.head = new SinglyLinkedListNode(1L);
        l.head.next = new SinglyLinkedListNode(2L);
        l.head.next.next = new SinglyLinkedListNode(3L);
        l.head.next.next.next = new SinglyLinkedListNode(4L);
        l.head.next.next.next.next = new SinglyLinkedListNode(5L);
        l.head.next.next.next.next.next = new SinglyLinkedListNode(6L);

        printList(rearrangeList(l.head));

    }

    public static SinglyLinkedListNode rearrangeList(SinglyLinkedListNode head) {

        // Find Size of the list.
        SinglyLinkedListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int midPoint = (size) / 2;

        // Find the mid point.
        curr = head;
        int currIndex = 0;
        while (currIndex < midPoint) {
            curr = curr.next;
            currIndex++;
        }
        SinglyLinkedListNode secondHead = curr.next; // move anything after mid point to list2.
        curr.next = null;

        // Reverse list 2.
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode next = null;
        curr = secondHead;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHead = prev;

        SinglyLinkedListNode p1 = head;
        SinglyLinkedListNode p2 = secondHead;
        while (p1 != null && p2 != null) {
            SinglyLinkedListNode temp1 = p1.next;
            SinglyLinkedListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }

        return head;
    }

    public static void printList(SinglyLinkedListNode node) throws IOException {
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);

    }
}
