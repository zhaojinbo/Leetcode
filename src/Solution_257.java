import java.util.ArrayList;
import java.util.List;

public class Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        List<String> leftList = binaryTreePaths(root.left);
        if (!leftList.isEmpty()) {
            appendString(root, list, leftList);
        }
        List<String> rightList = binaryTreePaths(root.right);
        if (!rightList.isEmpty()) {
            appendString(root, list, rightList);
        }
        if (leftList.isEmpty() && rightList.isEmpty()) {
            list.add(""+root.val);
        }
        return list;
    }

    private void appendString(TreeNode root, List<String> list, List<String> leftOrRightList) {
        for (String item : leftOrRightList) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(root.val).append("->").append(item);
            list.add(stringBuffer.toString());
        }
    }
}
