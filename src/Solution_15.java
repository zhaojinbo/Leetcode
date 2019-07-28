import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    /**
     * 时间复杂度：34ms，99.22%
     * 空间复杂度：45.3MB，98.56%
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return list;
    }

    /**
     * 时间复杂度O(n^3)
     */
    public List<List<Integer>> threeSumOne(int[] nums) {
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

/*    public static void main(String[] args) {
        List<List<Integer>> res = new Solution_15().threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(res);
    }*/
}
