import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) { // Check to avoid duplicate row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top
            if (left <= right) { // Check to avoid duplicate column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix1)); // Output: [1,2,3,6,9,8,7,4,5]

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix2)); // Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
