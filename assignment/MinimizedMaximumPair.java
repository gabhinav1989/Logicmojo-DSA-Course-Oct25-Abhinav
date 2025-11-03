package dsa2025.assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the
 * largest pair sum in a list of pairs.
 * 
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum
 * would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2
 * pairs such that:
 * 
 * Each element of nums is in exactly one pair, and
 * The maximum pair sum is minimized.
 * Return the minimized maximum pair sum after optimally pairing up the
 * elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,5,2,3]
 * Output: 7
 * Explanation: The elements can be paired up into pairs (3,3) and (5,2).
 * The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
 * Example 2:
 * 
 * Input: nums = [3,5,4,2,4,6]
 * Output: 8
 * Explanation: The elements can be paired up into pairs (3,5), (4,4), and
 * (6,2).
 * The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 2 <= n <= 105
 * n is even.
 * 1 <= nums[i] <= 105
 */
public class MinimizedMaximumPair {
    public static void main(String[] args) {
        System.out.println(findMinimizedMaxSum(new int[] { 11, 4, 1, 5, 1, 2, 5, 1, 5, 5, 4 }));
        System.out.println(minPairSum(10, Arrays.asList(11, 4, 1, 5, 1, 2, 5, 1, 5, 5, 4)));
    }

    private static int findMinimizedMaxSum(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        Arrays.sort(arr);
        int sum = 0;
        while (i < j) {
            sum = Math.max(sum, arr[i++] + arr[j--]);
        }
        return sum;

    }

    public static int minPairSum(int n, List<Integer> arr) {
        int start = 0;
        int end = n - 1;
        Collections.sort(arr, (a, b) -> b - a); // here comparator is needed because this is sorted by natural ordering by default.
        int sum = 0;
        while (start < end) {
            sum = Math.max(sum, arr.get(start++) + arr.get(end--));
        }
        return sum;

    }
}
