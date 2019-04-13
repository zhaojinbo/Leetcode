import java.util.ArrayList;
import java.util.List;

public class Solution_442 {
    /**
     * 由于数组中的数字都是处于下标范围内的，所以可以将数字对应下标处的数字变为负数
     * 比如当前位置的值为3，则将下标为2的位置处的值变为负数
     * 这样就能够标记出已经出现过的数字，下一次同样的数字会找到相同的位置
     * 发现当前位置的数字为负数，则表明找到了重复的数字
     * 下一次又出现了3，则会找到下标为2的位置处的数字，发现是负数，则3重复
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                list.add(index + 1);
            }
        }
        return list;
    }
}
