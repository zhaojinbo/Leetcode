public class Solution_171 {
    public int titleToNumber(String s) {
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            num = num * 26 + 1 + chars[i] - 'A';
        }
        return num;
    }
}
