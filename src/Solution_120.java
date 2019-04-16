import java.util.List;

public class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        List<Integer> list = triangle.get(size - 1);
        for (int i = 0; i < size; i++) {
            dp[i] = list.get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                // 某一行每个元素到最后一行的最小路径和等于，该元素的值加上下一行相邻两个元素，它们到最后一行的最小路径和其中较小的一个
                dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
