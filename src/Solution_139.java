import java.util.Arrays;
import java.util.List;

public class Solution_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();

        // 找出长度的最大值能够优化算法
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = word.length() > maxLen ? word.length() : maxLen;
        }

        // dp[i]表示前i个字符串组成的子字符串是否能够被成功拆分
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        // i和j都表示所在位置时第几个字符，而非下标位置
        for (int i = 1; i <= size; i++) {
            for (int j = i - 1; j >= 0 && j >= i - maxLen; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        String[] wordDict = {"apple", "pen"};
        String s = "applepenapple";
        boolean res = wordBreak(s, Arrays.asList(wordDict));
        System.out.println(res);
    }

}
