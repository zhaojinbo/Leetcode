public class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int l = obstacleGrid[0].length;
        int[][] pathNum = new int[h][l];
        for (int i=0;i<h;i++){
            if (obstacleGrid[i][0] == 0){
                pathNum[i][0] = 1;
            }else{
                break;
            }
        }
        for (int i=0;i<l;i++){
            if (obstacleGrid[0][i] == 0){
                pathNum[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i=1;i<h;i++){
            for (int j=1;j<l;j++){
                if (obstacleGrid[i][j]==0){
                    pathNum[i][j] = pathNum[i][j-1]+pathNum[i-1][j];//路径总数是由可到达其左边和上面的点的路径总数决定
                }
            }
        }
        return pathNum[h-1][l-1];

    }
}
