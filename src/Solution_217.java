import java.util.Arrays;

public class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return false;
        Arrays.sort(nums);
        for (int i = 1; i < length; i++) {
            if (nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
