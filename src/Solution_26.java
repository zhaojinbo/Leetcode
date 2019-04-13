public class Solution_26 {
    /**
     * 原地删除排序数组中的重复项
     *
     * @param nums 待去重的数组
     * @return 去重后数组的新实际长度（不需要考虑数组中超出新长度后面的元素）
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int vernier = 0;//游标专门用来记录有效元素的存放位置
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[vernier]) {
                //每当遍历到不重复的元素，就将该元素的值复制过来，到游标的下一个位置
                vernier++;
                nums[vernier] = nums[i];
            }
        }
        return vernier + 1;
    }
}
