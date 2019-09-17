/**
 * 4ms，99.57%
 */
public class Solution_10 {

    private int[][] back;

    public boolean isMatch(String s, String p) {
        back = new int[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String t, String p) {
        if (j == p.length())
            return i == t.length();
        if (back[i][j] == 1)
            return false;

        boolean firstmatch = i < t.length() && (t.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;
        if ((j + 1 < p.length() && p.charAt(j + 1) == '*'))
            ans = dp(i, j + 2, t, p) || (firstmatch && dp(i + 1, j, t, p));
        else
            ans = firstmatch && dp(i + 1, j + 1, t, p);

        if (!ans)
            back[i][j] = 1;

        return ans;
    }


/*    public static void main(String[] args) {
        boolean res = new Solution_10().isMatch("a", "ab*");
        System.out.println(res);
    }*/
}
