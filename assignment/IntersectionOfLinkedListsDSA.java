import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given pointers to the head nodes of linked lists that merge together at some
 * point, find the node where the two lists merge. The merge point is where both
 * lists point to the same node, i.e. they reference the same memory location.
 * It is guaranteed that the two head nodes will be different, and neither will
 * be NULL. If the lists share a common node, return that node's value.
 * 
 * Note: After the merge point, both lists will share the same node pointers.
 * 
 * Example
 * 
 * In the diagram below, the two lists converge at Node x:
 * 
 * [List #1] a--->b--->c
 * \
 * x--->y--->z--->NULL
 * /
 * [List #2] p--->q
 * Function Description
 * 
 * Complete the findMergeNode function in the editor below.
 * 
 * findMergeNode has the following parameters:
 * 
 * SinglyLinkedListNode pointer head1: a reference to the head of the first list
 * SinglyLinkedListNode pointer head2: a reference to the head of the second
 * list
 * Returns
 * 
 * int: the value of the node where the lists merge
 * Input Format
 * 
 * Do not read any input from stdin/console.
 * 
 * The first line contains an integer , the number of test cases.
 * 
 * Each of the test cases is in the following format:
 * The first line contains an integer, , the node number where the merge will
 * occur.
 * The next line contains an integer, that is the number of nodes in the first
 * list.
 * Each of the following lines contains a value for a node. The next line
 * contains an integer, that is the number of nodes in the second list.
 * Each of the following lines contains a value for a node.
 * 
 * Constraints
 * 
 * The lists will merge.
 * .
 * .
 * 
 * Sample Input
 * 
 * The diagrams below are graphical representations of the lists that input
 * nodes and are connected to.
 * 
 * Test Case 0
 * 
 * 1
 * \
 * 2--->3--->NULL
 * /
 * 1
 * Test Case 1
 * 
 * 1--->2
 * \
 * 3--->Null
 * /
 * 1
 * Sample Output
 * 
 * 2
 * 3
 * Explanation
 * 
 * Test Case 0: As demonstrated in the diagram above, the merge node's data
 * field contains the integer .
 * Test Case 1: As demonstrated in the diagram above, the merge node's data
 * field contains the integer .
 */
public class IntersectionOfLinkedListsDSA {

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
    
        // Helper method for printing (not used in current implementation)
        // public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, 
        // BufferedWriter bufferedWriter) throws IOException {
        //     while (node != null) {
        //         bufferedWriter.write(String.valueOf(node.data));
        //         node = node.next;
        //         if (node != null) {
        //             bufferedWriter.write(sep);
        //         }
        //     }
        // }

        private static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2){

            Map<SinglyLinkedListNode, SinglyLinkedListNode> map = new HashMap<>();
            SinglyLinkedListNode curr = head1;
            while(curr != null){
                map.put(curr, curr.next);
                curr = curr.next;
            }

            SinglyLinkedListNode curr2 = head2;
            while(curr2 != null){
                if(map.containsKey(curr2)){
                    return curr2.data;
                }
                curr2 = curr2.next;
            }

            return -1;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            // Modified for local testing - output to console instead of file
            int tests = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
            for (int testsItr = 0; testsItr < tests; testsItr++) {
                int index = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                SinglyLinkedList llist1 = new SinglyLinkedList();
    
                int llist1Count = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                for (int i = 0; i < llist1Count; i++) {
                    int llist1Item = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                    llist1.insertNode(llist1Item);
                }
              
                  SinglyLinkedList llist2 = new SinglyLinkedList();
    
                int llist2Count = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                for (int i = 0; i < llist2Count; i++) {
                    int llist2Item = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                    llist2.insertNode(llist2Item);
                }
              
                  SinglyLinkedListNode ptr1 = llist1.head;
                SinglyLinkedListNode ptr2 = llist2.head;
    
                for (int i = 0; i < llist1Count; i++) {
                    if (i < index) {
                        ptr1 = ptr1.next;
                    }
                }
    
                for (int i = 0; i < llist2Count; i++) {
                    if (i != llist2Count-1) {
                        ptr2 = ptr2.next;
                    }
                }
    
                ptr2.next = ptr1;
    
                int result = findMergeNode(llist1.head, llist2.head);
    
                System.out.println(result);
            }
    
            scanner.close();
        }
    }

/*
Command to run this program.
cd "e:\dev\Programs\Java learning again"; Get-Content src/personal/leetCode/test_input.txt | java -cp bin IntersectionOfLinkedLists  */