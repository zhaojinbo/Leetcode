import java.util.HashSet;

public class Solution_136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!integerSet.add(nums[i])) {
                integerSet.remove(nums[i]);
            }
        }
        Integer result = 0;
        for (Integer item : integerSet) {
            result = item;
        }
        return result;
    }
}
