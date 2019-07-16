public class Solution_239 {
    /**
     * 时间复杂度：5ms，93.54%
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int[] maxIndexArr = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            res[i] = findMax(nums, i, i + k - 1, maxIndexArr);
        }
        return res;
    }

    /**
     * 这里查找窗口内最大值的时候考虑了两种不同的情况，
     * 当前面一个窗口的最大值下标在当前窗口范围内的话，就直接比较新加入的一个元素与前面最大值的关系
     * 当前面一个窗口的最大值下标不在在当前窗口范围内的话，那就老老实实从头到尾遍历找到最大值
     *
     * @param nums        原始数组
     * @param from        窗口的开始
     * @param to          窗口的结束
     * @param maxIndexArr 每个窗口最大值的下标
     */
    private int findMax(int[] nums, int from, int to, int[] maxIndexArr) {
        if (from > 0 && maxIndexArr[from - 1] >= from) {
            if (nums[to] > nums[maxIndexArr[from - 1]]) {
                maxIndexArr[from] = to;
            } else {
                maxIndexArr[from] = maxIndexArr[from - 1];
            }
        } else {
            int max_index = from;
            for (int i = from + 1; i <= to; i++) {
                if (nums[i] > nums[max_index]) {
                    max_index = i;
                }
            }
            maxIndexArr[from] = max_index;
        }
        return nums[maxIndexArr[from]];
    }
}
