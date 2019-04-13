public class Solution_27 {
    /**
     * 原地移除元素
     *
     * @param nums 待移除元素的数组
     * @param val  待移除元素的值
     * @return 移除之后数组的新长度（不需要考虑数组中超出新长度后面的元素）
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int vernier = 0;//游标专门用来记录有效元素的存放位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                //每当遍历到符合条件的元素，就将元素的值复制过来，到游标所在的位置
                nums[vernier] = nums[i];
                vernier++;
            }
        }
        return vernier;
    }
}
