package class20251015;

public class BinarySearch {
    // public static void main(String[] args) {
    // System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
    // 6));
    // }

    // static int binarySearch(int[] nums, int search) {
    // int start = 0;
    // int end = nums.length - 1;

    // while(start<=end)
    // {
    //     int mid = start + (end - start) / 2;

    //     if (nums[mid] == search) {
    //         return mid;
    //     } else if (nums[mid] > search) {
    //         end = mid - 1;
    //     } else {
    //         start = mid + 1;
    //     }
    // }

    // return-1;
    // }

    public static void main(String[] args){
		System.out.println(binarySearch(new int[] {2,3,5,6,8,9}, 7));
	}

    public static int binarySearch(int[] arr, int search){
		int start = 0;
		int end = arr.length-1;
		
		
		while(start<=end){
			int mid = start+ (end-start)/2;
			if(arr[mid]==search){
				return mid;
			} else if(arr[mid]>search){
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
        return -1;
	}
}
