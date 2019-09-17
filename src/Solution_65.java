/**
 * 3ms，99.36%
 * 由于返回结果是布尔类型，所以可以直接判断所有不正确的情况，手段是通过设置几个布尔类型的值。
 */
public class Solution_65 {
    public boolean isNumber(String s) {

        s = s.trim();

        boolean pointSeen = false;//是否出现过小数点
        boolean eSeen = false;//是否出现过e
        boolean numberSeen = false;//是否出现过数字
        boolean numberAfterE = false;//是否在e之后出现过数字
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;//第一次出现数字的时候应该将其设置为true，因为后面可能没有e了
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;//出现e的时候应该将其设置为false
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}
