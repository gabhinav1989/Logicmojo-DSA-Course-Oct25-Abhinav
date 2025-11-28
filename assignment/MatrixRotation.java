public class MatrixRotation {
    public static void main(String[] args) {
        // print2DArray(rotateMatrix(new int[][] { new int[] { 1,2 }, new int[] { 3, 4 }
        // }, 1));
        print2DArray(rotateMatrix(new int[][] {
                new int[] { 1, 2, 3, 4 },
                new int[] { 5, 6, 7, 8 },
                new int[] { 9, 10, 11, 12 },
                new int[] { 13, 14, 15, 16 } },
                2));

    }

    private static int[][] rotateMatrix(int[][] mat, int index) {
        for (int k = 0; k < index; k++) {
        // Indices.. not lengths...
            int top = 0; // 0
            int left = 0; // 0
            int bottom = mat.length - 1; // 3
            int right = mat[0].length - 1; // 3
            while (top < bottom && left < right) {
                int temp = mat[top][left];
                boolean rotate = false;
                for (int i = left; i < right; i++) {
                    mat[top][i] = mat[top][i + 1];
                    rotate = true;
                }
                for (int i = top; i < bottom; i++) {
                    mat[i][right] = mat[i + 1][right];
                    rotate = true;
                }
                for (int i = right; i > left; i--) {
                    mat[bottom][i] = mat[bottom][i - 1];
                    rotate = true;
                }
                for (int i = bottom; i > top + 1; i--) {
                    mat[i][left] = mat[i - 1][left];
                    rotate = true;
                }
                mat[top + 1][left] = temp;

                top++;
                left++;
                bottom--;
                right--;
            }

        }

        return mat;
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            int j = 0;
            for (; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println(arr[i][j] + "]");
        }
    }

}