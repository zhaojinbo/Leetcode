import java.util.Arrays;

public class Solution_67 {
    public String addBinary(String a, String b) {
        // 首先将两个字符串长度补齐
        if (a.length() > b.length()) {
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < a.length() - b.length(); i++) {
                prefix.append('0');
            }
            prefix.append(b);
            b = prefix.toString();
        } else if (a.length() < b.length()) {
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < b.length() - a.length(); i++) {
                prefix.append('0');
            }
            prefix.append(a);
            a = prefix.toString();
        }
        //转换为字符数组
        char[] a_chars = a.toCharArray();
        char[] b_chars = b.toCharArray();
        char carry = '0';//表示进位
        char[] sum = addBinary(a_chars, b_chars, carry);
        StringBuilder sumResult = new StringBuilder();
        for (int i=0;i<sum.length;i++){
            sumResult.append(sum[i]);
        }
        return sumResult.toString();
    }

    //利用递归解决问题，两个二进制相加就相当于除最后一位的子数组相加结果再合并上最后一位的相加结果
    private char[] addBinary(char[] a_chars, char[] b_chars, char carry) {
        int length = a_chars.length;
        char last;//表示最后一位相加的结果
        int count = count_of_1(a_chars[length - 1], b_chars[length - 1], carry);
        switch (count) {
            case 0:
                carry = '0';
                last = '0';
                break;
            case 1:
                carry = '0';
                last = '1';
                break;
            case 2:
                carry = '1';
                last = '0';
                break;
            default:
                carry = '1';
                last = '1';
        }
        char[] finalresult;
        //递归的终止条件为：数组长度为1，不能再分出子数组
        if (length == 1) {
            if (carry == '1') {
                finalresult = new char[]{'1', last};
            } else {
                finalresult = new char[]{last};
            }
        } else {
            char[] result = addBinary(Arrays.copyOf(a_chars, length - 1), Arrays.copyOf(b_chars, length - 1), carry);
            finalresult = Arrays.copyOf(result, result.length + 1);
            finalresult[finalresult.length - 1] = last;
        }
        return finalresult;
    }

    private int count_of_1(char a_char, char b_char, char carry) {
        int count = 0;
        if (a_char == '1') {
            count++;
        }
        if (b_char == '1') {
            count++;
        }
        if (carry == '1') {
            count++;
        }
        return count;
    }
}
