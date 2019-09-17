/**
 * 4ms，99.57%
 * 递归解法，当第二个字符是*时，可以以两种姿态进行递归，正则表达式指针向后移动两位，直接忽略正则式中的前两位；
 * 如果第一个字符匹配，也可以字符串指针向后移动一位，正则式指针不动。
 * 当第二个字符不是*，或者没有第二个字符的时候，只能以一种方式递归，那就是两个指针都向后移动一位。
 */
public class Solution_10 {

    //使用动态规划的方式将前面的结果保存下来，以供后面使用，这样能够优化时间复杂度
    private int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        return isMatchCore(0, 0, s, p);
    }

    /**
     * @param i 字符串指针
     * @param j 正则式指针
     * @param t 字符串
     * @param p 正则式
     * @return 结果
     */
    private boolean isMatchCore(int i, int j, String t, String p) {
        if (j == p.length())
            return i == t.length();
        if (dp[i][j] == 1)
            return false;

        boolean firstmatch = i < t.length() && (t.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;
        if ((j + 1 < p.length() && p.charAt(j + 1) == '*'))
            ans = isMatchCore(i, j + 2, t, p) || (firstmatch && isMatchCore(i + 1, j, t, p));
        else
            ans = firstmatch && isMatchCore(i + 1, j + 1, t, p);

        if (!ans)
            dp[i][j] = 1;

        return ans;
    }


/*    public static void main(String[] args) {
        boolean res = new Solution_10().isMatch("a", "ab*");
        System.out.println(res);
    }*/
}
