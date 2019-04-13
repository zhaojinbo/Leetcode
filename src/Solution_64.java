public class Solution_64 {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int l = grid[0].length;
        int[][] minSum = new int[h][l];//用来存储到达该节点需要走的最小路径长度
        minSum[0][0] = grid[0][0];
        for (int i = 1; i < h; i++) {
            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < l; i++) {
            minSum[0][i] = minSum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < h; i++)
            for (int j = 1; j < l; j++) {
                minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
            }
        return minSum[h - 1][l - 1];
    }
}
