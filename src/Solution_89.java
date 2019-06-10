import java.util.ArrayList;
import java.util.List;

public class Solution_89 {
    /**
     * 时间复杂度：2ms
     * 思路：n=N时候的list是n=N-1时候的list正序和倒序的组合
     * 只是倒序的时候需要加上一个2的整数次幂
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n < 0) {
            return list;
        }
        if (n == 0) {
            list.add(0);
            return list;
        }
        list.add(0);
        list.add(1);
        if (n == 1) {
            return list;
        }
        int value = 1;
        for (int i = 2; i <= n; i++) {
            value *= 2;
            //先正序来初始化curlist
            List<Integer> curlist = new ArrayList<>(list);
            //然后再倒序添加一遍，需要加上一个数value
            for (int j = list.size() - 1; j >= 0; j--) {
                curlist.add(list.get(j) + value);
            }
            list = curlist;
        }
        return list;
    }
}
