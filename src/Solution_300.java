public class Solution_300 {
    /**
     * 动态规划
     * 时间复杂度为O(n^2), 32ms
     *
     * @param nums
     * @return
     */
    public int lengthOfLISOne(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] maxLength = new int[length];
        int max = 1;
        maxLength[0] = 1;
        for (int i = 1; i < length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, maxLength[j] + 1);
                }
            }
            maxLength[i] = temp;
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    /**
     * 另外一种思路的动态规划
     * 时间复杂度为O(n*log(n)),1ms
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 先考虑极端输入
        if (len <= 1)
            return len;
        // tail[i]长度为i+1的上升子序列的末尾最小值
        // tail数组中最终存储的就是最长上升子序列
        int[] tail = new int[len];
        // 遍历一遍整个数组，使用二分查找算法
        tail[0] = nums[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            // 比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[res]) {
                // 直接添加在那个元素的后面
                tail[++res] = nums[i];
            } else {
                // 二分查找到第 1 个比 nums[i] 还大的元素，更新到那个位置
                int l = 0;
                int r = res;
                while (l < r) { //当
                    int mid = l + (r - l) / 2;
                    // 找到相等的就退出循环
                    if (tail[mid] == nums[i]) {
                        l = mid;
                        break;
                    } else if (tail[mid] > nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return ++res;
    }
}
