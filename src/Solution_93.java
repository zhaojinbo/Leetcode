import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 时间复杂度4ms，91.56%
 */
public class Solution_93 {
    /*
    用来保存从任意一位置至任意一位置的子串是否是有效的，类似于动态规划中保存之前的状态来减小时间复杂度
    不同之处在于这里的状态并没有发生转移，所以不算是动态规划与回溯算法的结合
    这一步是优化时间复杂度的关键
     */
    int[][] dp;

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (null == s) {
            return res;
        }
        int length = s.length();
        if (length < 4 || length > 12) {
            return res;
        }
         /*
        它是一个二维矩阵，有三种状态值：
        0表示之前还没有判断过
        1表示从下表i到j的子串是有效的
        2表示不是有效的
        我们只用到了右上半部分，当然这里也可以使用char数组，空间复杂度更低
         */
        dp = new int[length][length];
        //初始化，单个字符的肯定是有效的
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        LinkedList<String> templist = new LinkedList<>();
        dfs(res, templist, s, length, -1, 3);
        return res;
    }

    /**
     * 回溯算法，每添加一个点，算是解空间路径中的一层
     *
     * @param res      结果集
     * @param templist 用来存放中间结果的list，需要在每一步路径回退的时候移除最后添加进去的string
     * @param prePos   前一个点放置的位置，初始值为-1
     * @param dotnum   当前需要方式的点的个数
     */
    private void dfs(ArrayList<String> res, LinkedList<String> templist, String s, int length, int prePos, int dotnum) {
        //界定当前点能够放置的位置的上下界
        int minPos = Math.min(length - 1 - dotnum, prePos + 3);
        int maxPos = Math.max(prePos + 1, length - 1 - 3 * dotnum);
        for (int curPos = maxPos; curPos <= minPos; curPos++) {
            String substr = s.substring(prePos + 1, curPos + 1);
            if (isValid(substr, prePos + 1, curPos)) {
                templist.add(substr);
                if (dotnum == 1) {//当放置完最后一个点的时候，还需要将最后一段添加进去
                    substr = s.substring(curPos + 1, length);
                    if (isValid(substr, curPos + 1, length - 1)) {
                        templist.add(substr);
                        res.add(String.join(".", templist));
                        templist.removeLast();//回溯算法中回退需要的步骤
                    }
                } else {
                    dfs(res, templist, s, length, curPos, dotnum - 1);
                }
                templist.removeLast();//回溯算法中回退需要的步骤
            }
        }
    }

    //判断是否是有效的，这里首先需要到保存的状态中查看是否之前已经有了，优化时间复杂度
    private boolean isValid(String substr, int from, int to) {
        if (to - from > 2) {
            return false;
        }
        if (dp[from][to] == 1) {
            return true;
        } else if (dp[from][to] == 2) {
            return false;
        } else {
            if (substr.charAt(0) != '0' && Integer.valueOf(substr) <= 255) {//值在0-255之间，且如果是两位以上，开头不能是0
                dp[from][to] = 1;
                return true;
            } else {
                dp[from][to] = 2;
                return false;
            }
        }
    }

/*    public static void main(String[] args) {
        List<String> strings = new Solution_93().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }*/
}