import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {
    public static void main(String[] args) {
        SinglyLinkedList singleLL = new SinglyLinkedList();
        singleLL.addAll(new int[]{1, 2, 3, 4, 5});
        singleLL.head = reverseKGroup(singleLL.head, 2);
        System.out.println(singleLL.toString());
    }

    public static SinglyLinkedListNode reverseKGroup(SinglyLinkedListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        dummy.next = head;
        SinglyLinkedListNode prevGroupEnd = dummy; 
        SinglyLinkedListNode curr = head;
        
        while (curr != null) {
            List<SinglyLinkedListNode> group = new ArrayList<>(k);
            SinglyLinkedListNode groupStart = curr;
            
            for (int i = 0; i < k && curr != null; i++) {
                group.add(curr);
                curr = curr.next;
            }
            
            if (group.size() == k) {
                SinglyLinkedListNode nextAfterGroup = curr;
                for (int i = k - 1; i > 0; i--) {
                    group.get(i).next = group.get(i - 1);
                }
                
                group.get(0).next = nextAfterGroup;
                prevGroupEnd.next = group.get(k - 1);
                
                // Update prevGroupEnd to point to the new end (first node of original group)
                prevGroupEnd = group.get(0);
            } else {
                // Less than k nodes remaining, don't reverse, just connect
                prevGroupEnd.next = groupStart;
                break;
            }
        }
        
        return dummy.next;
    }
}

class SinglyLinkedList{
    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

    void addAll(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        
        SinglyLinkedListNode curr;
        int startIndex;
        
        // If head is null, create head from first element
        if(head == null){
            this.head = new SinglyLinkedListNode(nums[0]);
            curr = head;
            startIndex = 1; // Start from index 1 since we used nums[0] for head
        } else {
            // If head exists, find the tail to append to
            curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            startIndex = 0; // Add all elements starting from index 0
        }
        
        // Add remaining elements
        for(int i = startIndex; i < nums.length; i++){
            curr.next = new SinglyLinkedListNode(nums[i]);
            curr = curr.next;
        }
    }

    public String toString(){
        if(head == null){
            return "[ ]";
        }
        SinglyLinkedListNode curr = this.head;
        StringBuilder sb = new StringBuilder("[ ");
        while(curr.next != null){
            sb.append(curr.val + ", ");
            curr = curr.next;
        }
        sb.append(curr.val + " ]");

        return sb.toString();
    }

}
class SinglyLinkedListNode {
    int val;
    SinglyLinkedListNode next;

    SinglyLinkedListNode() {}

    SinglyLinkedListNode(int val) {
        this.val = val;
    }

    SinglyLinkedListNode(int val, SinglyLinkedListNode next) {
        this.val = val;
        this.next = next;
    }

}

