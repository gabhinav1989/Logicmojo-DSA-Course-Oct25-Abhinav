

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array of size N containing only 0s, 1s, and 2s;
 * sort the array in ascending order.
 * 
 * Input Format
 * Integer N.
 * Integer Array of size N.
 * 
 * Constraints
 * 1 <= N <= 10^6
 * 0 <= A[i] <= 2
 * 
 * Output Format
 * Integer Array of size N.
 * 
 * Sample Input 1
 * 
 * 5
 * 0 1 2 1 2
 * 
 * Sample Output 1
 * 
 * 0 1 1 2 2
 * Explanation 1
 * 
 * 0s 1s and 2s are segregated into ascending order.
 */
public class Sort012 {

    public static void main(String[] args) {
        System.out.println(
                sort_an_array(5, new ArrayList<Integer>(Arrays.asList(0, 1, 2, 1, 2))));
    }

    public static List<Integer> sort_an_array(int n, List<Integer> arr) {
        int i = 0;
        int j = 0;
        int k = arr.size() - 1;
        while (j <= k) {
            if (arr.get(j) == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr.get(j) == 1) {
                j++;
            } else if (arr.get(j) == 2) {
                swap(arr, j, k);
                k--;
            }
        }
        return arr;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
