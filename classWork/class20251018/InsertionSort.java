package dsa2025.classWork.class20251018;

import java.util.Arrays;

public class InsertionSort {
    
	public static void main(String[] args){
	
		System.out.println(Arrays.toString(insertionSort(new int[] {29,10,14,37,14})));
	}
	
	public static int[] insertionSort(int[] arr){
		int n = arr.length-1;
		
		for(int i=1;i<n;i++){
			int curr = arr[i];
            int j=i-1;
			while(j>=0 && arr[j]> curr){
				arr[j+1] = arr[j];
                j--;
			}
            arr[j+1] = curr;
			
		}
		return arr;
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
