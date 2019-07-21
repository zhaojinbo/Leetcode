import java.util.ArrayList;

/**
 * 时间复杂度：7 ms，97.69%
 * 空间复杂度：37.5 MB，91.57%
 */
public class Solution_71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0 || path.charAt(0) != '/') {
            return "";
        }
        char[] chars = path.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; ) {
            /*
            思路是找到两个"/"之间的字符串，然后判断是不是".", ".."，
            如果都不是，就是路径字符串，加进list
            如果是"."，不理会
            如果是".."，在list中有元素的情况下删除最后一个
            最后将list中的所有字符串拼接起来
             */
            if (chars[i] != '/') {
                int j = i + 1;
                while (j < chars.length && chars[j] != '/') {
                    j++;
                }
                String s = new String(chars, i, j - i);
                if (!s.equals(".")) {
                    if (s.equals("..")) {
                        if (list.size() > 0) {
                            list.remove(list.size() - 1);
                        }
                    } else {
                        list.add(s);
                    }
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        if (list.size() == 0) {
            stringBuilder.append("/");
        } else {
            for (String str : list) {
                stringBuilder.append("/").append(str);
            }
        }
        return stringBuilder.toString();
    }

/*    public static void main(String[] args) {
        String s = new Solution_71().simplifyPath("/../");
        System.out.println(s);
    }*/
}
