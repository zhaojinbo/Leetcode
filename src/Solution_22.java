import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        generate("", 0, 0, n, list);

        return list;
    }

    /**
     * 回溯算法，通过深度优先遍历，当碰到符合条件的解或者不符合条件的解，就return，重新进入别的路径
     * @param s 当前深度优先遍历的位置，字符串s的值
     * @param left s中左括号的个数
     * @param right s中右括号的个数
     * @param n 左括号最多应该不超过n个
     * @param list 用来存储结果的list
     */
    private void generate(String s, int left, int right, int n, List<String> list) {
        if (left + right == 2 * n) {
            list.add(s);
            return;
        }
        if (left < n) {
            generate(s + "(", left + 1, right, n, list);
        }else {
            StringBuilder sBuilder = new StringBuilder(s);
            for (int i = 0; i < n - right; i++) {
                sBuilder.append(")");
            }
            list.add(sBuilder.toString());
            return;
        }
        if (right < left) {
            generate(s + ")", left, right + 1, n, list);
        }
    }
}
