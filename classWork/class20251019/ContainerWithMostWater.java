package dsa2025.classWork.class20251019;

public class ContainerWithMostWater {
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = 0;

        while(i<j){
            maxArea = Math.max(
                maxArea, Math.min(height[i], height[j]) * (j-i));
            if(height[i]<height[j]){
                i++;
            } else if(height[i]>height[j]){
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxArea;
    }
}
