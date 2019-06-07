import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    /**
     * 时间复杂度：5ms, 96.94%
     * 空间复杂度：50.4MB, 50.00%
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helpCombine(n, k, lists, list, 1);
        return lists;
    }

    /**
     * 回溯算法
     * @param n 最大数字是n
     * @param k 需要选取k个数字
     * @param form 需要从from的位置向后选取，这种只向后不向前的组合方式能够防止重复
     */
    private void helpCombine(int n, int k, List<List<Integer>> lists, ArrayList<Integer> list, int form) {
        //递归退出条件，当不需要再选择任何元素的时候
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        /*
         * 用for循环将所有路径都考虑进去，路径就是指回溯算法中的路径
         * 这里的for循环退出条件尤其重要，原来我是直接让i<=n
         * 但是这样的话就会走很多无效的路径，优化成i <= n - k + 1后时间减小到原来的1/10
         * 处于这样的考虑：当后面的所有数字已经不够再选取时，就是无效的路径了
         */
        for (int i = form; i <= n - k + 1; i++) {
            list.add(i);
            helpCombine(n, k - 1, lists, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

/*    public static void main(String[] args) {
        List<List<Integer>> res = new Solution_77().combine(4, 2);
        System.out.println(res);
    }*/
}
