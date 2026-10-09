class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length * matrix[0].length;

        int lo = 0, hi = len - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int val = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (val == target) {
                return true;
            } 
            else if (val < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;

    }
}
