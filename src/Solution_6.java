public class Solution_6 {
    /**
     * 17ms，80%
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] chars = s.toCharArray();
        char[][] charArr = new char[numRows][s.length() / (numRows - 1) + 1];//用来Z字型存放字符
        int[] indexs = new int[numRows];//用来记录每一行下一次存放时该存放的位置
        boolean flag = true;
        int row = 0;
        for (char aChar : chars) {
            charArr[row][indexs[row]] = aChar;
            indexs[row]++;
            if (flag) {
                if (row < numRows - 1) {
                    row++;
                } else {
                    flag = false;
                    row--;
                }
            } else {
                if (row > 0) {
                    row--;
                } else {
                    flag = true;
                    row++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < indexs[i]; j++) {
                stringBuilder.append(charArr[i][j]);
            }
        }
        return stringBuilder.toString();
    }

/*    public static void main(String[] args) {
        String convert = new Solution_6().convert("LEETCODEISHIRING", 2);
        System.out.println(convert);
    }*/
}
