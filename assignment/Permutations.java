import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The set 1, 2, 3, ...., n contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Input Format
 * 
 * Integer n
 * Integer k
 * Constraints
 * 
 * 1 <= n <= 9
 * 1 <= k <= n!
 * Output Format
 * 
 * String s
 * Sample Input 0
 * 
 * 3
 * 3
 * Sample Output 0
 * 
 * 213
 * Sample Input 1
 * 
 * 4
 * 9
 * Sample Output 1
 * 
 * 2314
 */
public class Permutations {
    static List<String> stack = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(permutations2(4, 9));
    }

    private static String permutations2(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        helper(arr, result, used, new ArrayList<>());
        System.out.println(result);
        List<Integer> finalAnswer = result.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : finalAnswer) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static void helper(int[] arr, List<List<Integer>> result, boolean[] used, List<Integer> path) {
        // base condition => return result
        stack.add("result: " + result + ", used: " + Arrays.toString(used) + ", path" + path);
        if (path.size() == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                path.add(arr[i]);
                helper(arr, result, used, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
