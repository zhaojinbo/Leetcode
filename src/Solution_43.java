public class Solution_43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
            return null;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[][] arr;
        char[] chars1, chars2;
        if (len1 >= len2) {
            arr = new int[len2][len1 + len2];
            chars1 = num1.toCharArray();
            chars2 = num2.toCharArray();
        } else {
            arr = new int[len1][len1 + len2];
            chars2 = num1.toCharArray();
            chars1 = num2.toCharArray();
        }

        int charsLen1 = chars1.length;//较大的，相乘时放在上面的字符串的长度
        int charsLen2 = chars2.length;
        int[] ints1 = new int[charsLen1];
        int[] ints2 = new int[charsLen2];
        for (int i = 0; i < charsLen1; i++) {
            ints1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < charsLen2; i++) {
            ints2[i] = chars2[i] - '0';
        }

        for (int i = charsLen2 - 1; i >= 0; i--) {
            if (ints2[i] != 0) {
                int carryOver = 0;
                int index = charsLen2 - 1 - i;
                for (int j = charsLen1 - 1; j >= 0; j--) {
                    int res = ints1[j] * ints2[i] + carryOver;
                    arr[index][i + j + 1] = res % 10;
                    carryOver = res / 10;
                }
                arr[index][i] = carryOver;
            }
        }

        int column = arr[0].length;
        int[] result = new int[column];
        int carryOver = 0;
        for (int i = column - 1; i >= 0; i--) {
            int sum = carryOver;
            for (int j = 0; j < charsLen2; j++) {
                sum += arr[j][i];
            }
            result[i] = sum % 10;
            carryOver = sum / 10;
        }

        int index = 0;
        boolean flag = false;
        for (int i = 0; i < column; i++) {
            if (result[i] != 0) {
                index = i;
                flag = true;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = flag ? index : column - 1; i < column; i++) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String multiply = new Solution_43().multiply("0", "11");
        System.out.println(multiply);
    }
}
