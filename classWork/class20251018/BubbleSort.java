package classWork.class20251018;

import java.util.Arrays;

public class BubbleSort{

	public static void main(String[] args){
	
		System.out.println(Arrays.toString(bubbleSort(new int[] {29,10,14,37,14})));
	}
	
	public static int[] bubbleSort(int[] arr){
		int n = arr.length-1;
		boolean swapped;
		for(int i=0; i<n;i++){
			swapped = false;
			for (int j=0; j<n-i; j++){
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
        return arr;
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
