public class Solution_12 {
    /**
     * 执行时间 17ms，99.44%
     * 内存消耗 36.2MB，100%
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        appendStr(num / 1000, 1000, stringBuilder);
        num %= 1000;
        appendStr(num / 100, 100, stringBuilder);
        num %= 100;
        appendStr(num / 10, 10, stringBuilder);
        num %= 10;
        appendStr(num, 1, stringBuilder);
        return stringBuilder.toString();
    }

    private void appendStr(int n, int level, StringBuilder stringBuilder) {
        if (n == 0) {
            return;
        }
        if (n <= 3) {
            char ch;
            switch (level) {
                case 1000:
                    ch = 'M';
                    break;
                case 100:
                    ch = 'C';
                    break;
                case 10:
                    ch = 'X';
                    break;
                default:
                    ch = 'I';
            }
            for (int i = 0; i < n; i++) {
                stringBuilder.append(ch);
            }
        } else if (n == 4) {
            String str;
            switch (level) {
                case 100:
                    str = "CD";
                    break;
                case 10:
                    str = "XL";
                    break;
                default:
                    str = "IV";
            }
            stringBuilder.append(str);
        } else if (n == 5) {
            char ch;
            switch (level) {
                case 100:
                    ch = 'D';
                    break;
                case 10:
                    ch = 'L';
                    break;
                default:
                    ch = 'V';
            }
            stringBuilder.append(ch);
        } else if (n < 9) {
            appendStr(5, level, stringBuilder);
            appendStr(n - 5, level, stringBuilder);

        } else if (n == 9) {
            String str;
            switch (level) {
                case 100:
                    str = "CM";
                    break;
                case 10:
                    str = "XC";
                    break;
                default:
                    str = "IX";
            }
            stringBuilder.append(str);
        }
    }

/*    public static void main(String[] args) {
        String s = new Solution_12().intToRoman(2876);
        System.out.println(s);
    }*/
}
