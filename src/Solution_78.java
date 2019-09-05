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

    /**
     * 第二种方法，回溯算法
     * 2ms，90.28%
     */
    public List<List<Integer>> subsetsTwo(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(nums, 0, res);
        res.add(new ArrayList<>());
        return res;
    }

    /**
     * @param nums 数组
     * @param index 生成从index到最后一位的子集
     * @param res 最终结果集
     */
    private void generate(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length-1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[index]);
            res.add(list);
            return;
        }
        /*
         * 生成从index+1到最后一位的子集
         * 然后从index到最后一位的子集，就是把当前位置的数字加到每一个集合中
         * 最后再加上单独这个数子组成的集合
         */
        generate(nums, index + 1,res);
        for (List<Integer> list : new ArrayList<>(res)) {
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(nums[index]);
            res.add(integers);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(nums[index]);
        res.add(integers);
    }

/*    public static void main(String[] args) {
        List<List<Integer>> res = new Solution_78().subsetsTwo(new int[]{1, 2, 3});
        System.out.println(res);
    }*/
}
