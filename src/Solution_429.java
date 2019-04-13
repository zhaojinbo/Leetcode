import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> intList = new ArrayList<>();
        if (root == null) {
            return intList;
        }
        LinkedList<Node> linkedList = new LinkedList<>();

        linkedList.offer(root);
        int count = 1;
        while (!linkedList.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>();
            int count2 = 0;
            for (int i = 0; i < count; i++) {
                Node pop = linkedList.pop();
                integers.add(pop.val);
                if (pop.children!=null){
                    for (Node node : pop.children) {
                        linkedList.offer(node);
                        count2++;
                    }
                }
            }
            count = count2;
            intList.add(integers);
        }
        return intList;
    }
}
