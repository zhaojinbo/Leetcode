public class Solution_43 {
    /**
     * 时间复杂度：6ms，97.82%
     * 空间复杂度：36.1MB，91.41%
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
            return "";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        //将字符串先转为字符数组，然后转为整数数组，以便后面计算使用，避免重复计算增加时间复杂度
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] ints1 = new int[len1];
        int[] ints2 = new int[len2];
        for (int i = 0; i < len1; i++) {
            ints1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < len2; i++) {
            ints2[i] = chars2[i] - '0';
        }
        //按照乘法的规则，依次拿ints2中的每一个数字和ints1中的每一个数字相乘，将乘积存入结果数组arr相应位置，暂时不考虑进位
        int len = len1 + len2;
        int[] arr = new int[len];
        for (int i = len2 - 1; i >= 0; i--) {
            if (ints2[i] != 0) {//这里可以优化时间复杂度
                for (int j = len1 - 1; j >= 0; j--) {
                    arr[i + j + 1] += ints1[j] * ints2[i];
                }
            }
        }

        //处理进位，因为最后的结果中每一位都应该是小于10的数字，大于部分向上进位
        int carryOver = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum = arr[i] + carryOver;
            carryOver = sum / 10;
            arr[i] = sum % 10;
        }
        //为了使最终的结果不以0开头，需要标记开始的位置
        int index = 0;
        boolean flag = false;//标记结果是否存在非零数字
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                index = i;
                flag = true;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = flag ? index : len - 1; i < len; i++) {
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }

/*    public static void main(String[] args) {
        String multiply = new Solution_43().multiply("123", "456");
        System.out.println(multiply);
    }*/
}
