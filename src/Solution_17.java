import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_17 {
    /**
     * 2ms
     */
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        String[][] stringArr = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        char[] chars = digits.toCharArray();
        return combination(chars, chars.length - 1, stringArr);
    }

    /**
     * 利用递归来计算所有的组合情况
     * [0-end]的所有字符的组合结果，等于[0-(end-1)]的所有字符的组合结果与stringArr[chars[end] - '2']所表示的字符串数组中的每个字符串的组合
     */
    private List<String> combination(char[] chars, int end, String[][] stringArr) {
        if (end == 0) {
            return new ArrayList<>(Arrays.asList(stringArr[chars[0] - '2']));
        }
        List<String> list = combination(chars, end - 1, stringArr);
        List<String> res = new ArrayList<>();
        for (String string : list) {
            for (String str : stringArr[chars[end] - '2']) {
                res.add(string + str);
            }
        }
        return res;
    }

/*    public static void main(String[] args) {
        List<String> strings = new Solution_17().letterCombinations("234");
        for (String string:strings){
            System.out.println(string);
        }
    }*/
}
