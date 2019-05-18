public class Solution_304 {
    // 左上角所有元素的值的和
    private int[][] sum;

    // 运用动态规划来求每个元素其左上角所有元素的和
    public Solution_304(int[][] matrix) {
        int length = matrix.length;
        if (length != 0) {
            int length1 = matrix[0].length;
            this.sum = new int[length + 1][length1 + 1];
            for (int i = 1; i <= length; i++) {
                for (int j = 1; j <= length1; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }

/*    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Solution_304 obj = new Solution_304(matrix);
        int param_1 = obj.sumRegion(2,1,4,3);
        System.out.println(param_1);
    }*/
}
