package class20251101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {9,8,9,8}, 3)));
    }
    
    private static int[] maxSlidingWindow(int[] nums, int k) {
        int[] subArray = new int[k];
        for(int i = 0;i<k;i++){
            subArray[i] = nums[i];
        }
        int firstWindowMax = findMax(subArray);
        System.out.println(firstWindowMax);
        List<Integer> result = new ArrayList<>();

        int max = firstWindowMax;
        // Window slides from [0...k-1] to [1...k], [2...k+1], etc.
        // For each window, element leaving is nums[i-1], element entering is nums[i+k-1]
        int readPointer = k; // Points to the element entering the new window
        result.add(firstWindowMax);
        
        while(readPointer < nums.length) {
            int elementLeaving = nums[readPointer - k]; // Element leaving the window
            int elementEntering = nums[readPointer]; // Element entering the window
            
            // If the element leaving was the max, recalculate max in new window
            if(elementLeaving == max) {
                // Recalculate max in current window [readPointer-k+1 ... readPointer]
                max = nums[readPointer - k + 1];
                for(int i = readPointer - k + 2; i <= readPointer; i++) {
                    max = Math.max(max, nums[i]);
                }
            } else {
                // Just compare new element with current max
                max = Math.max(max, elementEntering);
            }
            
            result.add(max);
            readPointer++;
        }

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(i -> i).toArray();
    }


    static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
