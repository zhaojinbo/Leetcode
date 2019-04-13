class Solution_13 {
    /**
     * 罗马数字转整数
     *
     * @param s 需要转化的字符串
     * @return 经过计算转变后的整数值
     */
    public int romanToInt(String s) {
        char[] chArray = s.toCharArray();
        int le = chArray.length;
        int sum = 0;
        int i = 0;
        while (i < le - 1) {
            if (getInteger(chArray[i]) < getInteger(chArray[i + 1])) {
                sum = sum + getInteger(chArray[i + 1]) - getInteger(chArray[i]);
                i += 2;
                if (i >= le) {//当最后两个字母组成了特殊情况时，已经计算了所有字母，可以将结果返回了
                    return sum;
                }
            } else {
                sum += getInteger(chArray[i]);
                i += 1;
            }
        }
        sum += getInteger(chArray[i]);
        return sum;
    }

    /**
     * 将字符转换为对应的数字
     *
     * @param c 需要转换的字符
     * @return 转换后的整数值
     */
    private int getInteger(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
