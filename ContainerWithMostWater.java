package dsa2025;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]). Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * 
 * Input Format
 * 
 * First line is the number of vertical lines.
 * Secound line is the array having height for each line.
 * 
 * Constraints
 * 
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * 
 * Output Format
 * 
 * Return the maximum amount of water a container can store.
 * 
 * 
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    static int maxArea(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int area = 0;
        while (left < right) {
            int newArea = Math.min(arr[left], arr[right]) * (right - left);
            area = Math.max(newArea, area);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}
