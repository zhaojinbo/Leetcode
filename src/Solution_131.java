import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 * 时间复杂度：3ms，100%
 * 空间复杂度：38.6MB，97.10%
 */
public class Solution_131 {
    /*
    用来保存从任意一位置至任意一位置的子串是否是回文串，类似于动态规划中保存之前的状态来减小时间复杂度
    不同之处在于这里的状态并没有发生转移，所以不算是动态规划与回溯算法的结合
    这一步是优化时间复杂度的关键
     */
    int[][] dp;

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (null == s || s.length() == 0) {
            return res;
        }
        int length = s.length();
        /*
        它是一个二维矩阵，有三种状态值：
        0表示之前还没有计算过
        1表示从下表i到j的子串是回文串
        2表示不是回文串
        我们只用到了右上半部分，当然这里也可以使用char数组，空间复杂度更低
         */
        dp = new int[length][length];
        //初始化，单个字符的肯定是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        ArrayList<String> templist = new ArrayList<>();
        helper(res, templist, s, length, 0);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param res      结果集
     * @param templist 中间list
     * @param s        字符串
     * @param length   字符串长度
     * @param index    从当前位置向后组合判断
     */
    private void helper(List<List<String>> res, ArrayList<String> templist, String s, int length, int index) {
        if (index == length) {
            res.add(new ArrayList<>(templist));//一定要重新new一个对象，templist可以得到重用
        }
        for (int i = index; i < length; i++) {
            if (isPalindrome(s, index, i)) {
                templist.add(s.substring(index, i + 1));
                helper(res, templist, s, length, i + 1);
                templist.remove(templist.size() - 1);//回溯算法中回退一定要记得这一步
            }
        }
    }

    //判断是否是回文串，这里首先需要到保存的状态中查看是否之前已经有了，优化时间复杂度
    private boolean isPalindrome(String s, int from, int to) {
        if (dp[from][to] == 1) {
            return true;
        } else if (dp[from][to] == 2) {
            return false;
        } else {
            for (int i = from, j = to; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[from][to] = 2;
                    return false;
                }
            }
            dp[from][to] = 1;
            return true;
        }
    }

/*    public static void main(String[] args) {
        List<List<String>> res = new Solution_131().partition("aab");
        System.out.println(res);
    }*/
}
