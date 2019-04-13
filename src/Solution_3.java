public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int max = 1;
        int temp = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            int k;
            if ((k = isRepeat(s, index, i - 1, s.charAt(i))) != -1) {
                index = k + 1;
                temp = i - index + 1;
            } else {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    private int isRepeat(String s, int from, int to, char cha) {
        for (int i = from; i <= to; i++) {
            if (cha == s.charAt(i)) {
                return i;//返回重复元素的坐标
            }
        }
        return -1;//表示没有重复元素
    }
}
