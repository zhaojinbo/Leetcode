import java.util.HashMap;

public class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        // HashMap的key为数组某一位置的值与target的差，value为这一位置的下标（不是从零开始）
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            Integer index = integerIntegerHashMap.get(numbers[i]);
            if(index!=null){
                ints[0] = index;
                ints[1] = i+1;
                break;
            }
            integerIntegerHashMap.put(target-numbers[i],i+1);
        }
        return ints;
    }
}
