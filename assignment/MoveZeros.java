package dsa2025.assignment;

/**
 * 
Given an integer array nums, move all 0's to the end of it while maintaining the 
relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeros(new int[] { 0, 1, 2, 0, 3, 0 })));
    }

    private static int[] moveZeros(int[] arr) {
        int readPointer = 0; 
        int writePointer = 0; // stays where it is until it is swapped with a non-zero element.
        while (readPointer < arr.length) {
            if (arr[readPointer] != 0) {
                swap(arr, readPointer, writePointer);
                writePointer++;
            }
            readPointer++;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
