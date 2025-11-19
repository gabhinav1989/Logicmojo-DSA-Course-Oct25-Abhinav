package classWork.class20251109;



public class LinkedListCycleStart {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node findCycleStart(Node head) {
        if (head == null || head.next == null) {
            return null; // No cycle possible
        }

        Node slow = head;
        Node fast = head;

        // Step 1: Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected, break to find the start
                break;
            }
        }

        // If the loop terminated because fast became null, there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2 & 3: Find the starting node
        slow = head; // Reset slow to the head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Both pointers meet at the start of the cycle
    }
}
