public class Solution_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length==1)
            return nums[0];
        boolean flag = true;//用以排除全为负数的情况
        int[] sumArray = new int[nums.length+1];
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0)
                flag = false;
            sum+=nums[i];
            sumArray[i+1] = sum;
        }
        //当全部为负数发生时
        if (flag){
            int maxValue = nums[0];
            for (int i = 1;i<nums.length;i++){
                if (nums[i]>maxValue)
                    maxValue = nums[i];
            }
            return maxValue;
        }
        //当不是全为负数时，按照买卖股票最佳时机的思路
        int minValue_index = 0;
        int maxSum = 0;
        for (int i=1;i<sumArray.length;i++){
            if (sumArray[i]<sumArray[minValue_index])
                minValue_index = i;
            else{
                int difference = sumArray[i]-sumArray[minValue_index];
                if (difference>maxSum)
                    maxSum = difference;
            }
        }
        return maxSum;
    }
}
