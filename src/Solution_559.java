import java.util.List;

public class Solution_559 {
    public int maxDepth(Node root) {
        if (root==null)
            return 0;
        int max = 0;
        List<Node> children = root.children;
        for (Node node:children){
            int depth = maxDepth(node);
            if (depth >max){
                max = depth;
            }
        }
        return max+1;
    }
}
