public class Solution_5 {
    /**
     * 动态代理方法来做，时间复杂度为O(n^2)，103ms
     *
     * @param s
     * @return
     */
    public String longestPalindromeOne(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[][] record = new int[len][len];//用来记录下标从i到j的子字符串是否为回文串，0代表不是
        int start = 0;
        int end = 1;
        //动态规划的边界条件，当字符串长度为1时一定是回文串，当长度为2时，通过判断也能够得出
        for (int i = 0; i < len; i++) {
            record[i][i] = 1;
            if (i < len - 1) {
                if (chars[i] == chars[i + 1]) {
                    record[i][i + 1] = 1;
                    start = i;
                    end = i + 2;
                }
            }
        }
        //从长度为3的子串开始判断，如果是回文串，记录进record数组当中，以便后来判断更长的子串是否为回文串
        for (int leng = 3; leng <= len; leng++) {
            for (int i = 0; i <= len - leng; i++) {
                if (chars[i] == chars[i + leng - 1] && record[i + 1][i + leng - 2] == 1) {
                    record[i][i + leng - 1] = 1;
                    start = i;
                    end = i + leng;
                }
            }
        }
        return s.substring(start, end);
    }

    /**
     * 中心扩展法，速度飞起，最快5ms
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int[] range = new int[2];
        char[] chars = s.toCharArray();
        int low;
        int high;
        for (int i = 0; i < chars.length; i++) {
            low = i;
            high = low;
            while (high < chars.length - 1 && chars[high + 1] == chars[low]) {
                high++;
            }
            // 中间一个细节，以供优化，当中将连续几个字符相等时，直接跳到这段连续相等字符的最后
            i = high;
            while (low > 0 && high < chars.length - 1 && chars[low - 1] == chars[high + 1]) {
                low--;
                high++;
            }
            if (high - low > range[1] - range[0]) {
                range[0] = low;
                range[1] = high;
            }
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static void main(String[] args) {
        String res = longestPalindrome("babad");
        System.out.println(res);
    }
}
