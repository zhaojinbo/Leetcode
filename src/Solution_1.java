import java.util.HashMap;

public class Solution_1 {
    /**
     * 时间复杂度有点高，执行时间40ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOne(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 这种方式利用了hash表，查找速度快了许多6ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(target-nums[i],i);
            }else {
                arr[0] = hashMap.get(nums[i]);
                arr[1] = i;
                break;
            }
        }
        return arr;
    }
}
