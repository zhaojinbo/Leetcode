public class Solution_746 {
    public static int minCostClimbingStairs(int[] cost) {
        // minCost[i]表示到达下标为i的台阶处时，需要的最小花费；需要注意的是，到达某个台阶时，该层台阶所需要的花费并没有计算进来
        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i < minCost.length; i++) {
            minCost[i] = Math.min(minCost[i - 2] + cost[i - 2], minCost[i - 1] + cost[i - 1]);
        }
        return minCost[cost.length];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
