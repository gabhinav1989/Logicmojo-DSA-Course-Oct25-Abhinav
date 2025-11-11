import java.util.Arrays;

/**
 * 556. Next Greater Element III - Medium
 * 
 * Given a positive integer n, find the smallest integer which has exactly
 * the same digits existing in the integer n and is greater in value than n.
 * If no such positive integer exists, return -1.
 * 
 * Note that the returned integer should fit in 32-bit integer,
 * if there is a valid answer but it does not fit in 32-bit integer, return -1.
 * 
 * 
 * Example 1:
 * Input: n = 12
 * Output: 21
 * 
 * Example 2:
 * Input: n = 21
 * Output: -1
 * 
 * Example 3:
 * Input: n = 44342
 * Output: 44423
 * 
 * Example 4:
 * Input: n = 765
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= (2^31) - 1
 * 
 */
public class NextGreatestElement {
    public static void main(String[] args) {
        System.out.println("Test 12: Expected 21, Got: " + findNextGreaterElement(12));
        System.out.println("Test 21: Expected -1, Got: " + findNextGreaterElement(21));
        System.out.println("Test 44342: Expected 44423, Got: " + findNextGreaterElement(44342));
        System.out.println("Test 765: Expected -1, Got: " + findNextGreaterElement(765));
        System.out.println("Test 1: Expected -1, Got: " + findNextGreaterElement(2147483476));
       
    }
    public static int findNextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        
        // Find the rightmost pivot where digit is smaller than the next
        int pivot = digits.length - 1;
        while (pivot > 0 && digits[pivot - 1] >= digits[pivot]) {
            pivot--;
        }
        
        if (pivot == 0) {
            return -1; // Digits are in descending order
        }
        
        // Find the smallest digit to the right of pivot-1 that's greater than digits[pivot-1]
        int pivotDigit = digits[pivot - 1];
        int swapIndex = pivot;
        for (int i = pivot + 1; i < digits.length; i++) {
            if (digits[i] > pivotDigit && digits[i] <= digits[swapIndex]) {
                swapIndex = i;
            }
        }
        
        // Swap and sort remaining digits
        swap(digits, pivot - 1, swapIndex);
        Arrays.sort(digits, pivot, digits.length);
        
        // Convert to long to check for overflow, then return as int
        long result = Long.parseLong(new String(digits));
        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
