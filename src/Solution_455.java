import java.util.Arrays;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = i; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j < s.length)
                count++;
        }
        return count;
    }
}
