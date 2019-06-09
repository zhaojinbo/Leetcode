public class Solution_79 {
    /**
     * 时间复杂度：7ms, 96.91%
     * 空间复杂度：37.8MB, 97.46%
     * 回溯算法，分别以每个位置的字符作为起点
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0, word.length(), visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从下标index处开始word后面的字符能否在从[row,col]位置出发的board二维数组中找到
     *
     * @param row     当前字符所在行
     * @param col     当前字符所在列
     * @param index   当前已经匹配到了word的下标为index的字符
     * @param strLen  word字符串的长度
     * @param visited 用来标记board中的字符是否已经被访问过
     */
    private boolean exist(char[][] board, String word, int row, int col, int index, int strLen, boolean[][] visited) {
        if (index == strLen) {
            return true;
        }
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {//不能超过边界
            if (board[row][col] == word.charAt(index) && !visited[row][col]) {//当前字符要匹配，并且不能被访问过
                visited[row][col] = true;//访问标记
                boolean res = exist(board, word, row + 1, col, index + 1, strLen, visited)
                        || exist(board, word, row, col + 1, index + 1, strLen, visited)
                        || exist(board, word, row - 1, col, index + 1, strLen, visited)
                        || exist(board, word, row, col - 1, index + 1, strLen, visited);
                if (!res) {
                    visited[row][col] = false;//如果当前路径失败，需要将当前的标记清除
                }
                return res;
            }
        }
        return false;
    }

/*    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};

        boolean res = new Solution_79().exist(board, "ABCCC");
        System.out.println(res);
    }*/
}
