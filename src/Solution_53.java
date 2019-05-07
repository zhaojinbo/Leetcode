public class Solution_53 {
    /**
     * 非递归做法，9ms
     * 对前面所有数字求和，按照买卖股票的思路找到最大的差值就是最大子序和
     *
     * @param nums
     * @return
     */
    public int maxSubArrayOne(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        boolean flag = true;//用以排除全为负数的情况
        int[] sumArray = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                flag = false;
            sum += nums[i];
            sumArray[i + 1] = sum;
        }
        //当全部为负数发生时
        if (flag) {
            int maxValue = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > maxValue)
                    maxValue = nums[i];
            }
            return maxValue;
        }
        //当不是全为负数时，按照买卖股票最佳时机的思路
        int minValue_index = 0;
        int maxSum = 0;
        for (int i = 1; i < sumArray.length; i++) {
            if (sumArray[i] < sumArray[minValue_index])
                minValue_index = i;
            else {
                int difference = sumArray[i] - sumArray[minValue_index];
                if (difference > maxSum)
                    maxSum = difference;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划，2ms
     * 设sum[i]为以第i个元素结尾且和最大的连续子数组和。
     * 假设对于第i个元素，所有以它前面的元素结尾的最大连续子数组和都已经求得，
     * 那么以第i个元素结尾的最大连续子数组和，要么是以第i-1个元素结尾的最大连续子数组和加上这个元素，要么是只包含第i个元素，
     * 即sum[i] = max(sum[i-1] + a[i], a[i])。可以通过判断sum[i-1] + a[i]是否大于a[i]来做选择，而这实际上等价于判断sum[i-1]是否大于0。
     *
     * @param nums
     * @return
     */
    public int maxSubArrayTwo(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (sum[i - 1] > 0) {
                sum[i] = sum[i - 1] + nums[i];
            } else {
                sum[i] = nums[i];
            }
            if (sum[i] > max) {
                max = sum[i];
            }
        }
        return max;
    }

    /**
     * 对上面动态规划算法的进一步优化，减小空间复杂度
     * 由于每次运算只需要前一次的结果，因此并不需要像普通的动态规划那样保留之前所有的计算结果，只需要保留上一次的即可，因此算法的时间和空间复杂度都很小
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
