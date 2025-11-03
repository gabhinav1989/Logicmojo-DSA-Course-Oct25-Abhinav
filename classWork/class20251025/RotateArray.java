package class20251025;

import java.util.Arrays;

/**
 * 
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * 
 */
public class RotateArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
        System.out.println(Arrays.toString(rotate(new int[] {-1,-100,3,99 }, 2)));
        System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 76)));
        System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 0)));
        System.out.println(Arrays.toString(rotate(new int[] { 1 }, 2)));
    }

    public static int[] rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }

        rotateArray(nums, 0, nums.length - 1);
        // Now rotate first part
        rotateArray(nums, 0, k - 1);

        // then rotate second part
        if (k != nums.length)
            rotateArray(nums, k, nums.length - 1);

        return nums;
    }

    static void rotateArray(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
