import java.util.Arrays;

public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==1){
            return new TreeNode(nums[0]);
        }
        if (nums.length==0){
            return null;
        }
        int len = nums.length / 2;
        TreeNode root = new TreeNode(nums[len]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,len));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,len+1,nums.length));
        return root;
    }
}
