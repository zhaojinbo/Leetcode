import java.util.ArrayList;
import java.util.List;

public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> outerList = new ArrayList<>();
        if (numRows == 0) {
            return outerList;
        }
        ArrayList<Integer> innerList;
        if (numRows >= 1) {
            innerList = new ArrayList<>();
            innerList.add(1);
            outerList.add(innerList);
        }
        if (numRows >= 2) {
            innerList = new ArrayList<>();
            innerList.add(1);
            innerList.add(1);
            outerList.add(innerList);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> preList = outerList.get(i - 1);
            innerList = new ArrayList<>();
            innerList.add(1);
            for (int j = 1; j < i; j++) {
                innerList.add(preList.get(j - 1) + preList.get(j));
            }
            innerList.add(1);
            outerList.add(innerList);
        }
        return outerList;
    }
}
