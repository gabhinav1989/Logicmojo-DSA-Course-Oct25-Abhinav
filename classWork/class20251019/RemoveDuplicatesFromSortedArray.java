package classWork.class20251019;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println("number of unique elements = "+ removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
        System.out.println("number of unique elements = "+ removeDuplicatesFromList(Arrays.asList(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)));
    }

    // This is a two pointer problem. And both the pointers start from the beginning
    // of the array.

    public static int removeDuplicates(int[] arr) {
        int i = 0;
        int j = 1;
        int n = arr.length - 1;
        while (j <= n) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }

        }
        return i + 1;
    }

    public static int removeDuplicatesFromList(List<Integer> arr) {
            int i = 0;
            int j = 1;
            while( j<=arr.size() - 1 ){
                if(arr.get(i) == arr.get(j)){
                    j++;
                } else {
                    i++;
                    arr.set(i, arr.get(j));
                    j++;
                }
            }
            return i+1;
    
         
    }
}
