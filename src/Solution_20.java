import java.util.LinkedList;

public class Solution_20 {
    /**
     * 有效的括号
     *
     * @param s 待判断的字符串
     * @return 返回是否有效的结果
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        LinkedList<Character> lkList = new LinkedList<>();//用来存放左括号
        char[] chars = s.toCharArray();
        int num_of_left = 0;//用来记录左括号的个数，应该是总长度的一半才对

        //首先将判断第一个符号，以及空字符串，这样的特殊情况
        if (chars.length != 0) {
            if (chars[0] == ')' || chars[0] == '}' || chars[0] == ']') {
                return false;
            } else {
                lkList.add(chars[0]);
                num_of_left += 1;
            }
        } else {
            return true;
        }
        //判断剩余符号
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ')' && chars[i] != '}' && chars[i] != ']') {
                lkList.add(chars[i]);
                num_of_left += 1;
            } else if (chars[i] == ')') {
                Character character = lkList.removeLast();
                if (character != '(') {
                    return false;
                }
            } else if (chars[i] == '}') {
                Character character = lkList.removeLast();
                if (character != '{') {
                    return false;
                }
            } else if (chars[i] == ']') {
                Character character = lkList.removeLast();
                if (character != '[') {
                    return false;
                }
            }
        }
        return num_of_left == chars.length / 2;
    }
}
