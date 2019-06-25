import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_93 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (null == s) {
            return res;
        }
        int length = s.length();
        if (length < 4 || length > 12) {
            return res;
        }
        LinkedList<String> templist = new LinkedList<>();
        dfs(res, templist, s, length, -1, 3);
        return res;
    }

    /**
     * 回溯算法，每添加一个点，算是解空间路径中的一层
     * @param res 结果集
     * @param templist 用来存放中间结果的list，需要在每一步路径回退的时候移除最后添加进去的string
     * @param prePosition 前一个点放置的位置，初始值为-1
     * @param dotnum 当前需要方式的点的个数
     */
    private void dfs(ArrayList<String> res, LinkedList<String> templist, String s, int length, int prePosition, int dotnum) {
        int minPosition = Math.min(length - 2, prePosition + 3);
        for (int curPosition = prePosition + 1; curPosition <= minPosition; curPosition++) {
            String substring = s.substring(prePosition + 1, curPosition + 1);
            if (valid(substring)) {
                templist.add(substring);
                if (dotnum == 1) {//当放置完最后一个点的时候，还需要将最后一段添加进去
                    String substring1 = s.substring(curPosition + 1, length);
                    if (valid(substring1)) {
                        templist.add(substring1);
                        res.add(String.join(".", templist));
                        templist.removeLast();//回溯算法中回退需要的步骤
                    }
                } else {
                    dfs(res, templist, s, length, curPosition, dotnum - 1);
                }
                templist.removeLast();//回溯算法中回退需要的步骤
            }
        }
    }

    private boolean valid(String substring) {
        int length = substring.length();
        if (length > 3) {
            return false;
        }
        return substring.charAt(0) == '0' ? length == 1 : Integer.valueOf(substring) <= 255;
    }

/*    public static void main(String[] args) {
        List<String> strings = new Solution_93().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }*/
}