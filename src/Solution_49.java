import java.util.ArrayList;
import java.util.List;

public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int length = strs.length;
        boolean[] visited = new boolean[length];

        //二维数组用来保存每一个字符串的内容
        int[][] ints = new int[length][26];
        for (int i = 0; i < length; i++) {
            char[] chars = strs[i].toCharArray();
            for (char aChar : chars) {
                ints[i][aChar - 'a']++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                ArrayList<String> templist = new ArrayList<>();
                templist.add(strs[i]);
                for (int j = i + 1; j < length; j++) {
                    if (!visited[j] && isAnagram(strs, ints, i, j)) {
                        templist.add(strs[j]);
                        visited[j] = true;
                    }
                }
                res.add(templist);
            }
        }
        return res;
    }

    private boolean isAnagram(String[] strs, int[][] ints, int i, int j) {
        int length1 = strs[i].length();
        int length2 = strs[j].length();
        if (length1 != length2) {
            return false;
        }
        if (length1 < 26) {
            char[] chars = strs[i].toCharArray();
            for (int k = 0; k < strs[i].length(); k++) {
                int index = chars[k] - 'a';
                if (ints[i][index] != ints[j][index]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int k = 0; k < 26; k++) {
                if (ints[i][k] != ints[j][k]) {
                    return false;
                }
            }
            return true;
        }
    }

}
