import java.util.ArrayList;

public class Solution_91 {
    public int numDecodings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] count = new int[length];
        if (s.charAt(0) == '0') {
            return 0;
        }
        count[0] = 1;
        if (length == 1) {
            return count[0];
        }
        //length大于1的时候
        if (chars[0] == '1') {
            if (chars[1] == '0') {
                count[1] = 1;
            } else {
                count[1] = 2;
            }
        } else if (chars[0] == '2') {
            if (chars[1] < '7' && chars[1] != '0') {
                count[1] = 2;
            } else {
                count[1] = 1;
            }
        } else {
            if (chars[1] != '0') {
                count[1] = 1;
            } else {
                return 0;
            }
        }
        for (int i = 2; i < length; i++) {
            if (chars[i - 1] == '1') {
                if (chars[i] == '0') {
                    count[i] = count[i - 2];
                } else {
                    count[i] = count[i - 1] + count[i - 2];
                }
            } else if (chars[i - 1] == '2') {
                if (chars[i] < '7' && chars[i] != '0') {
                    count[i] = count[i - 1] + count[i - 2];
                } else if (chars[i] == '0') {
                    count[i] = count[i - 2];
                } else {
                    count[i] = count[i - 1];
                }
            } else {
                if (chars[i] != '0') {
                    count[i] = count[i - 1];
                } else {
                    return 0;
                }
            }
        }
        return count[length - 1];
    }

    /**
     * 下面是对上面题目的延伸，上面是求出解码的个数，下面是求出解码的所有情况
     * 所以上面是动态规划，下面是回溯算法
     *
     * @param num 解码前的数字组成的字符串
     */
    public void detailDecoding(String num) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        decode(num, 0, stringBuilder, list);
        for (StringBuilder str : list) {
            System.out.println(str.toString());
        }
        System.out.println(list.size());
    }

    /**
     * @param num           解码前的数字组成的字符串
     * @param start         从start下标位置开始向后1或者2个字符
     * @param stringBuilder 进入递归的初始str
     * @param list          结果集
     */
    private static void decode(String num, int start, StringBuilder stringBuilder, ArrayList<StringBuilder> list) {
        int length = num.length();
        if (start >= length) {
            list.add(stringBuilder);
            return;
        }
        char c = num.charAt(start);
        if (c == '0') {
            return;
        }
        stringBuilder.append((char) ('A' + Integer.parseInt(num.substring(start, start + 1)) - 1));
        decode(num, start + 1, new StringBuilder(stringBuilder), list);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        if (start + 1 < length && (c == '1' || (c == '2' && num.charAt(start + 1) < '7'))) {
            stringBuilder.append((char) ('A' + Integer.parseInt(num.substring(start, start + 2)) - 1));
            decode(num, start + 2, new StringBuilder(stringBuilder), list);
        }
    }
}
