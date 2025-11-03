package dsa2025.assignment;

public class RainWaterTrap {
    public static void main(String[] args) {
        System.out.println(trappedWater(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    public static int trappedWater(int[] height) {
        int n = height.length - 1;
        int left = 0;
        int right = n;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;
        // pointers should not cross each other. hence a while loop.
        while (left <= right) {
            // increase left if:
            if (height[left] <= height[right]) { // to determine which side of the wall is of lesser height;
                // calculate water at that point before moving the left pointer.
                if (height[left] < leftMax) {
                    // add water.
                    totalWater += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;

            } else { // decrease right. but before decreasing, add water.
                if (height[right] < rightMax) {
                    // add water.
                    totalWater += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }

                right--;
            }
        }
        return totalWater;
    }
}
