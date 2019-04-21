import java.util.HashMap;

public class Solution_3 {
    /**
     * 这种方法耗时较长，47ms，主要是因为在窗口中查找重复元素时，耗时较长
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOne(String s) {
        if (s.length() == 0)
            return 0;
        int max = 1;
        int len = 1;
        int i = 0;//i代表窗口的左边，j代表滑动窗口的右边
        for (int j = 1; j < s.length(); j++) {
            int k;
            if ((k = isRepeat(s, i, j - 1, s.charAt(j))) != -1) {
                i = k + 1;
                len = j - i + 1;
            } else {
                len++;
                if (len > max) {
                    max = len;
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

    /**
     * 采用hashMap，以字符为键，以下标为值，查找[i,j)区间内是否有重复，耗时16ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwo(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (hashMap.containsKey(chars[j])) {
                i = Math.max(i, hashMap.get(chars[j]) + 1);
            }
            max = Math.max(max, j - i + 1);
            hashMap.put(chars[j], j);
        }
        return max;
    }

    /**
     * 将hashMap替换为128长度的数组（ASCII码表长度），以字符所表示的数字为下标，以字符在字符串中的位置为值
     * 这样的数组查找速度也跟hash表一样是O(1)，耗时9ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        int[] ints = new int[128];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(i, ints[chars[j]]);
            max = Math.max(max, j - i + 1);
            ints[chars[j]] = j + 1;
        }
        return max;
    }
}
