public class Solution_14 {
    /**
     * 最长公共前缀
     *
     * @param strs 字符串数组
     * @return 最长前缀
     */
    public String longestCommonPrefix(String[] strs) {
        int strsLen = strs.length;
        if (strsLen == 0) {
            return "";
        }
        if (strsLen == 1) {
            return strs[0];
        }
        int minLen_index = 0;//最短字符串在字符串数组中的位置
        for (int i = 1; i < strsLen; i++) {
            if (strs[i].length() < strs[minLen_index].length()) {
                minLen_index = i;
            }
        }
        char[] chars = strs[minLen_index].toCharArray();
        for (int j = 0; j < chars.length; j++) {
            for (String str : strs) {
                if (str.charAt(j) != chars[j]) {
                    return strs[minLen_index].substring(0, j);
                }
            }
        }
        return strs[minLen_index];
    }
}
