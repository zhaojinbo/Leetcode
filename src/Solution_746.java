import java.util.Arrays;

public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] newCost = Arrays.copyOf(cost, cost.length + 1);
        int[] minCost = new int[newCost.length];
        minCost[0] = newCost[0];
        minCost[1] = newCost[1];
        for (int i = 2; i < newCost.length; i++) {
            minCost[i] = Math.min(minCost[i - 2], minCost[i - 1]) + newCost[i];
        }
        return minCost[cost.length];
    }
}
