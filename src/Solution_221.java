public class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) {
            return 0;
        }
        int l = matrix[0].length;
        int[][] dp = new int[h][l];//状态矩阵，dp[i][j]表示以下标为i和j的点作为正方形的右下角，只包含1的正方形的边长
        int max = 1;//用来表示最大的只包含1的正方形边长，初始化为1
        boolean flag = true;//用来判断初始化边界状态值之后，需不需要将max设为0；只有全部为0的时候才需要这么做
        //下面两个for循环用来初始化边界状态值
        for (int i = 0; i < h; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                flag = false;
            }
        }
        for (int i = 1; i < l; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                flag = false;
            }
        }
        if (flag) {
            max = 0;
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < l; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    // 以当前点为右下角的只包含1的正方形，取决于其左边、上边和左上方三个点；以这些点为右下角的只包含1的正方形边长的最小值+1就是当前边长
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = dp[i][j] > max ? dp[i][j] : max;
                }
            }
        }
        return max * max;
    }
}
