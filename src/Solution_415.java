public class Solution_415 {
    /**
     * 时间复杂度：4ms，97.49%
     */
    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();

        char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int len = Math.max(length1, length2);
        char[] res = new char[len];
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int a = i >= length1 ? 0 : chars1[i] - '0';//a,b分别表示第一个数字和第二个数字，当超出长度范围时，为0
            int b = i >= length2 ? 0 : chars2[i] - '0';
            int sum = a + b + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            res[i] = (char) ('0' + sum);
        }
        StringBuilder stringBuilder = new StringBuilder(new String(res));
        if (carry == 1) {
            stringBuilder.append('1');
        }
        return stringBuilder.reverse().toString();
    }

/*    public static void main(String[] args) {
        String s = new Solution_415().addStrings("9", "999999");
        System.out.println(s);
    }*/
}
