public class Solution_28 {
    /**
     * 实现strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * @param haystack 在其中寻找needle
     * @param needle   待寻找的子字符串
     * @return 找寻到的子字符串的位置
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] hayArray = haystack.toCharArray();
        char[] needArray = needle.toCharArray();
        //注意下标的范围不是从零到最后
        for (int i = 0; i < hayArray.length - needArray.length + 1; i++) {
            //当首字母相同再去判断，之后的字符串与子字符串是否相同
            if (hayArray[i] == needArray[0]) {
                int flag = -1;//设置一个标记用来判断是否下面的for循环正常执行完毕
                for (int j = 1; j < needArray.length; j++) {
                    if (hayArray[i+j]!=needArray[j]){
                        flag = 1;
                        break;
                    }
                }
                //当flag没有发生变化时，说明找到了匹配的子串
                if (flag==-1){
                    return i;
                }
            }
        }
        return -1;
    }
}
