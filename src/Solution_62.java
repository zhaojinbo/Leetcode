public class Solution_62 {
    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[n][m];//用来记录到达该点的路径总数
        for (int i =0;i<m;i++){
            pathNum[0][i] = 1;
        }
        for (int i=0;i<n;i++){
            pathNum[i][0] = 1;
        }

        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                pathNum[i][j] = pathNum[i][j-1]+pathNum[i-1][j];//路径总数是由可到达其左边和上面的点的路径总数决定
            }
        }
        return pathNum[n-1][m-1];
    }
}
