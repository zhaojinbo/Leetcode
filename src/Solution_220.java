import java.util.SortedSet;
import java.util.TreeSet;

public class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums.length <= 1) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subSet = treeSet.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!subSet.isEmpty()) {
                return true;
            }
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
            treeSet.add((long) nums[i]);
        }
        return false;
    }
}
