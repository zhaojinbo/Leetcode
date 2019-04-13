public class Solution_35 {
    /**
     * 搜索插入位置
     *
     * @param nums   排序数组
     * @param target 要插入的值
     * @return 要插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
