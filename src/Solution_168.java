public class Solution_168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder("");
        while (n > 0) {
            int value = n % 26;
            if (value == 0) {
                result.append('Z');
                n /= 26;
                n--;
            } else {
                result.append((char) ('A' + value - 1));
                n /= 26;
            }
        }
        return result.reverse().toString();
    }
}
