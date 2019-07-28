import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            for (int j = i + 1; j < nums.length - 1; ) {
                for (int k = j + 1; k < nums.length; ) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        list.add(tempList);
                    }
                    k++;
                    while (k < nums.length && nums[k] == nums[k - 1]) {
                        k++;
                    }
                }
                j++;
                while (j < nums.length - 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return list;
    }
}
