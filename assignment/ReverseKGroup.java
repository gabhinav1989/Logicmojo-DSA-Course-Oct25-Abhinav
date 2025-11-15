import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {
    public static void main(String[] args) {
        SinglyLinkedList singleLL = new SinglyLinkedList();
        singleLL.addAll(new int[]{1, 2, 3, 4, 5});
        singleLL.head = reverseKGroup(singleLL.head, 2);
        System.out.println(singleLL.toString());
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy; // Points to the end of the previous reversed group
        ListNode curr = head;
        
        while (curr != null) {
            List<ListNode> group = new ArrayList<>(k);
            ListNode groupStart = curr;
            
            // Collect k nodes (or remaining nodes if less than k)
            for (int i = 0; i < k && curr != null; i++) {
                group.add(curr);
                curr = curr.next;
            }
            
            // If we have exactly k nodes, reverse them
            if (group.size() == k) {
                ListNode nextAfterGroup = curr; // Save what comes after the group
                
                // Reverse the internal links: each node points to the previous one
                // Start from the last node and work backwards
                for (int i = k - 1; i > 0; i--) {
                    group.get(i).next = group.get(i - 1);
                }
                
                // The first node (now last in reversed group) should point to what comes after
                group.get(0).next = nextAfterGroup;
                
                // Connect the previous group's end to the new head of reversed group
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
    ListNode head;
    ListNode tail;

    void addAll(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        
        ListNode curr;
        int startIndex;
        
        // If head is null, create head from first element
        if(head == null){
            this.head = new ListNode(nums[0]);
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
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    public String toString(){
        if(head == null){
            return "[ ]";
        }
        ListNode curr = this.head;
        StringBuilder sb = new StringBuilder("[ ");
        while(curr.next != null){
            sb.append(curr.val + ", ");
            curr = curr.next;
        }
        sb.append(curr.val + " ]");

        return sb.toString();
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

