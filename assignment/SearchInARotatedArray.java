package dsa2025.assignment;

import java.util.List;

/**
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * Prior to being passed to your function, nums is possibly left rotated at an
 * unknown index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices
 * and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * 
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class SearchInARotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)); // -1
        System.out.println(searchBruteForce(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
    }

    // Bruteforce is easy, but it is O(n). But the ask was O(log n)
    private static int searchBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // O(log n) required solution
    private static int search(int[] arr, int target) {

        int n = arr.length;
        int pivot = findPivotIndex(arr);

        // If array not rotated (pivot at 0), search entire array
        if (pivot == 0) {
            return binarySearch(arr, 0, n - 1, target);
        }

        // Decide which half to search
        if (target >= arr[0] && target <= arr[pivot - 1]) {
            return binarySearch(arr, 0, pivot - 1, target);
        } else {
            return binarySearch(arr, pivot, n - 1, target);
        }
    }

    // Finds index of minimum element (rotation pivot)
    private static int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // If already sorted, pivot is 0
        if (arr[start] <= arr[end]) return 0;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                // Pivot is to the right of mid
                start = mid + 1;
            } else {
                // Pivot is at mid or to the left of mid
                end = mid;
            }
        }
        return start; // start == end == pivot
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int search_element(List<Integer> arr, int target) {
        int start = 0;
        int end = arr.size()-1;
        
        if(arr.get(start) <= arr.get(end)){
            return binarySearch(arr, start, end, target);
        } else {
            int pivot = findPivot(arr);
            if (pivot == 0) {
                return binarySearch(arr, 0, end, target);
            }
            if(target >= arr.get(0) && target <= arr.get(pivot-1)){
                return binarySearch(arr, 0, pivot-1, target);
            } else {
                return binarySearch(arr, pivot, end, target);
            }
        }
    }
    
    public static int findPivot(List<Integer> arr){
        int start = 0;
        int end = arr.size()-1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr.get(mid) > arr.get(end)){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    public static int binarySearch(List<Integer> arr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr.get(mid) == target){
                return mid;
            } else if(arr.get(mid) > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }




}
