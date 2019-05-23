public class Solution_338 {
    /**
     * 动态规划，3ms
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) {
            return dp;
        }
        dp[1] = 1;
        if (num == 1) {
            return dp;
        }
        dp[2] = 1;
        if (num == 2) {
            return dp;
        }
        int temp1 = 4;
        int temp2 = 2;
        for (int i = 3; i <= num; i++) {
            if (i == temp1) {//每到2的整数次方的时候，dp的值就为1
                temp2 = temp1;
                temp1 *= 2;
                dp[i] = 1;
            } else {
                dp[i] = dp[i - temp2] + 1;
            }
        }
        return dp;
    }

/*    public static void main(String[] args) {
        int[] res = new Solution_338().countBits(10);
        System.out.println(Arrays.toString(res));
    }*/
}
