import java.util.ArrayList;

/**
 * 时间复杂度：5 ms，80.29%
 */
public class Solution_151 {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; ) {
            if (chars[i] != ' ') {
                int j = i + 1;
                while (j < chars.length && chars[j] != ' ') {
                    j++;
                }
                list.add(new String(chars, i, j - i));
                i = j + 1;
            } else {
                i++;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

/*    public static void main(String[] args) {
        String s = new Solution_151().reverseWords("example");
        System.out.println(s);
    }*/
}