import java.util.ArrayList;
import java.util.List;

public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> curList = new ArrayList<>();

        if (rowIndex >= 0) {
            curList = new ArrayList<>();
            curList.add(1);
        }
        if (rowIndex >= 1) {
            curList = new ArrayList<>();
            curList.add(1);
            curList.add(1);
        }
        for (int i = 2; i <= rowIndex; i++) {
            ArrayList<Integer> preList = curList;
            curList = new ArrayList<>();
            curList.add(1);
            for (int j = 1; j < i; j++) {
                curList.add(preList.get(j - 1) + preList.get(j));
            }
            curList.add(1);
        }
        return curList;
    }
}
