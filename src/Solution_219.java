import java.util.HashMap;

public class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerHashMap.containsKey(nums[i])) {
                if (i - integerHashMap.get(nums[i]) > k) {
                    integerHashMap.put(nums[i], i);
                } else
                    return true;
            } else {
                integerHashMap.put(nums[i], i);
            }
        }
        return false;
    }
}
