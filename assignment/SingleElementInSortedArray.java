package dsa2025.assignment;
/**
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
 */
public class SingleElementInSortedArray {
    public static void main(String[] args){
        int[] test1 = {1,1,2,3,3,4,4,8,8};
        int[] test2 = {3,3,7,7,10,11,11};
        
        System.out.println("Binary Search O(log n):");
        System.out.println("Test 1: " + findSingle(test1)); // Should be 2
        System.out.println("Test 2: " + findSingle(test2)); // Should be 10
        
        // System.out.println(3^3^5^7^7); // prints 5 // this is the concept.
        System.out.println("\nXOR O(n):");
        System.out.println("Test 1: " + findSingleXOR(test1)); // Should be 2
        System.out.println("Test 2: " + findSingleXOR(test2)); // Should be 10
    }

    // TC: O(log n); SC: O(1) - Binary Search approach (Two pointer approach)
    private static int findSingle(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid is even, check if nums[mid] == nums[mid+1]
            // If mid is odd, check if nums[mid] == nums[mid-1]
            if (mid % 2 == 1) {
                mid--; // Make mid even
            }
            
            if (nums[mid] == nums[mid + 1]) {
                // Single element is on the right side
                left = mid + 2;
            } else {
                // Single element is on the left side (including mid)
                right = mid;
            }
        }
        
        return nums[left];
    }

    // TC: O(n); SC: O(1) - XOR approach (doesn't meet O(log n) requirement,
    // but is nice to know and good especially if the array is not sorted.)
    private static int findSingleXOR(int[] nums) {
        int num = nums[0];
        if (nums.length % 2 == 0) {
            return -1;
        }
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
