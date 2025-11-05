package dsa2025.classWork.class20251018;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args){
            System.out.println(Arrays.toString(selectionSort(new int[]{29,10,14,37,14})));
        }

    public static int[] selectionSort(int[] arr) {

        for (int j = 0; j < arr.length - 1; j++) {
            int smallestIndex = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }

        return arr;
    }
}
