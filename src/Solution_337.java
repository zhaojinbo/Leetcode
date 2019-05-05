import java.util.HashMap;

public class Solution_337 {
    /**
     * 直接递归的方式，这种方式不好，因为在递归robOne(root.left)时，照样需要对robOne(root.left.left)等孙子节点进行递归
     * 这样就导致了重复计算，用时630ms
     *
     * @param root
     * @return
     */
    public int robOne(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.right == null) {
            return Math.max(robOne(root.left), root.val + robOne(root.left.left) + robOne(root.left.right));
        }
        if (root.left == null) {
            return Math.max(robOne(root.right), root.val + robOne(root.right.left) + robOne(root.right.right));
        }
        return Math.max(robOne(root.left) + robOne(root.right), root.val + robOne(root.left.left) + robOne(root.left.right) + robOne(root.right.left) + robOne(root.right.right));
    }

    /**
     * 动态规划+递归，7ms
     * 为了不重复计算，我们利用hashmap来存储已经计算过的node
     * 下一次计算父节点或者爷爷节点的时候就能够重复利用，而无需重复计算
     * hashmap存储的key为每一个节点，value为以该节点为根的最大可盗窃财物数
     */
    private HashMap<TreeNode, Integer> hashMap = new HashMap<>();

    public int robTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return hashMap.get(root);
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        traversal(root.right);
        int max = comp(root);
        hashMap.put(root, max);
    }

    private int comp(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.right == null) {
            int res = root.val;
            if (root.left.left != null) {
                res += hashMap.get(root.left.left);
            }
            if (root.left.right != null) {
                res += hashMap.get(root.left.right);
            }
            return Math.max(hashMap.get(root.left), res);
        }
        if (root.left == null) {
            int res = root.val;
            if (root.right.left != null) {
                res += hashMap.get(root.right.left);
            }
            if (root.right.right != null) {
                res += hashMap.get(root.right.right);
            }
            return Math.max(hashMap.get(root.right), res);
        }
        int res = root.val;
        if (root.left.left != null) {
            res += hashMap.get(root.left.left);
        }
        if (root.left.right != null) {
            res += hashMap.get(root.left.right);
        }
        if (root.right.left != null) {
            res += hashMap.get(root.right.left);
        }
        if (root.right.right != null) {
            res += hashMap.get(root.right.right);
        }
        return Math.max(hashMap.get(root.left) + hashMap.get(root.right), res);
    }


    /**
     * 动态规划+递归，2ms
     * 每个元素都有两种情况下的最大值，带上自己本身的最大值和不带自己的最大值
     * rob[0]就是加上自己val的情况下的最大值
     * rob[1]是不加自己val情况下的最大值
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] rob = helper(root);
        return Math.max(rob[0], rob[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] rob = new int[2];
        int[] robLeft = helper(root.left);
        int[] robRight = helper(root.right);

        // 每个元素都有两种情况下的最大值，带上自己本身的最大值和不带自己的最大值

        rob[0] = robLeft[1] + robRight[1] + root.val;
        rob[1] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        return rob;
    }
}
