import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int h = matrix.length;
        if (h == 0) {
            return res;
        }
        int l = matrix[0].length;
        int j = 0;//横坐标
        int k = 0;//纵坐标
        char[] dir = {'0', '1', '2', '3'};//0,1,2,3分别表示4个方向
        int index = 0;//每次变换方向，只需要将index++，然后对4取模

        int[][] state = new int[h][l];//用来表示是否被访问过的状态

        for (int i = 0; i < h * l; i++) {
            char d = dir[index % 4];
            res.add(matrix[j][k]);
            state[j][k] = 1;
            switch (d) {
                case '0':
                    k++;
                    if (k == l || state[j][k] == 1) {
                        k--;
                        j++;
                        index++;
                    }
                    break;
                case '1':
                    j++;
                    if (j == h || state[j][k] == 1) {
                        j--;
                        k--;
                        index++;
                    }
                    break;
                case '2':
                    k--;
                    if (k == -1 || state[j][k] == 1) {
                        k++;
                        j--;
                        index++;
                    }
                    break;
                case '3':
                    j--;
                    if (j == -1 || state[j][k] == 1) {
                        j++;
                        k++;
                        index++;
                    }
            }
        }
        return res;
    }

/*    public static void main(String[] args) {
        List<Integer> list = new Solution_54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }*/
}
