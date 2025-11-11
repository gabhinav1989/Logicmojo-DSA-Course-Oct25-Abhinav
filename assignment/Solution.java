public class Solution {
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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /*
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     * 1. INTEGER_SINGLY_LINKED_LIST llist
     * 2. INTEGER data
     * 3. INTEGER position
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     * int data;
     * SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        int size = 0;
        SinglyLinkedListNode head = llist;
        SinglyLinkedListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
            size++;
        }
        SinglyLinkedListNode tail = curr.next;
        size++;

        if (position < 0 || position > size) {
            return null;
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        // o o o
        // 1 2 3
        if (position == 0) {
            head = newNode;
            newNode.next = curr.next;
            size++;
        } else if (position == size) {
            tail.next = newNode;
            newNode.next = null;
            size++;
        } else {
            int currIndex = 0;
            while (currIndex < position - 1) {
                currIndex++;
                curr = curr.next;
            }
            SinglyLinkedListNode temp = curr;
            curr.next = newNode;
            newNode.next = temp;
            size++;
        }

        return llist;

    }
}
