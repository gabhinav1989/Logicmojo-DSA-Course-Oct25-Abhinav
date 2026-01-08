import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 5, 4, 7, 8, 2, 9, 1, 6, 3 };
        System.out.println(mergeSort(arr.length, Arrays.asList(arr)));
    }

    private static List<Integer> mergeSort(int n, List<Integer> arr) {
        return helper(0, n - 1, arr);
    }

    private static List<Integer> helper(int start, int end, List<Integer> arr) {
        if (start >= end) {
            return new ArrayList<>(Collections.singleton(arr.get(start)));
        }
        int mid = start + (end - start) / 2;
        List<Integer> left = helper(start, mid, arr);
        List<Integer> right = helper(mid + 1, end, arr);
        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) {
            result.add(left.get(i++));
        }
        while (j < right.size()) {
            result.add(right.get(j++));
        }
        return result;
    }
}
