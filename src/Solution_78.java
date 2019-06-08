import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    /**
     * 时间复杂度：1ms, 99.86%
     * 空间复杂度：35.2MB, 96.23%
     * 为了不产生重复的集合，还是只与后面的数字组合
     * 以[1,2,3,4]为例，以1开头的集合，是将所有以2，3，4开头的集合全都加上1
     * 以2开头的集合，是将所有以3，4开头的集合全都加上2
     * 所以我们倒着产生，先生成以4开头的所有集合，只有一个
     * 然后在产生以3，2，1开头的集合，所有的这些集合的总和再加上一个空集合就是最后的结果
     */
    @SuppressWarnings("unchecked")
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;

        //先产生以最后一个元素开头的所有集合，只有一个
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[length - 1]);
        lists.add(list);
        res.add(list);

        //该数组用来存放以每一个元素开头的所有集合，也就是List<List<Integer>>
        Object[] listsArr = new Object[length];
        //先将以最后一个元素开头的所有集合放到数组的最后一个位置
        listsArr[length - 1] = lists;

        //倒序产生所有集合
        for (int i = length - 2; i >= 0; i--) {
            lists = new ArrayList<>();
            for (int j = i + 1; j < length; j++) {
                for (List<Integer> list1 : (List<List<Integer>>) listsArr[j]) {
                    list = new ArrayList<>(list1);
                    list.add(nums[i]);
                    lists.add(list);
                    res.add(list);
                }
            }
            //除了在后面所有集合中加上元素本身生成的集合，还有单独自己生成的集合
            list = new ArrayList<>();
            list.add(nums[i]);
            lists.add(list);
            res.add(list);
            listsArr[i] = lists;
        }
        //最后再加上一个空集合就是最后的结果
        res.add(new ArrayList<>());
        return res;
    }

/*    public static void main(String[] args) {
        List<List<Integer>> res = new Solution_78().subsets(new int[]{1, 2, 3, 4});
        System.out.println(res);
    }*/
}
