package class20251031;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /** Snake pattern */
    public static List<Integer> snakeOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int n = matrix[i].length;
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    result.add(matrix[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;

    }

    /** Spiral pattern - More efficient: processes all 4 edges in one iteration */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int direction = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                // go from left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                direction = (direction + 1) % 4;
            } else if (direction == 1) {
                // go from top to bottom
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                direction = (direction + 1) % 4;
            } else if (direction == 2) {
                // go from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                direction = (direction + 1) % 4;
            } else if (direction == 3) {
                // go from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                direction = (direction + 1) % 4;
            }
        }

        return result;
    }
}
