public class Solution_60 {
    /**
     * 时间复杂度：2ms, 99.84%
     * 空间复杂度：33.4MB, 98.45%
     */
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        int[] used = new int[n + 1];//用来标记哪一个数字已经被添加到结果字符串中
        int[] factorial = new int[n + 1];//阶乘，用来表示不包括当前位，后面所有位总共有多少排列情况
        factorial[2] = 1;
        //初始化阶乘数组
        for (int i = 3; i <= n; i++) {
            factorial[i] = factorial[i - 1] * (i - 1);
        }
        StringBuilder res = new StringBuilder();
        //每一次循环，确定一位的值，从最高位开始
        while (n > 1) {
            int quotient = k / factorial[n];//商
            int remainder = k % factorial[n];//余数
            //分余数等于0和不等于0处理quotient和k的值
            if (remainder == 0) {
                quotient--;
                k = factorial[n];
            } else {
                k = remainder;
            }
            quotient++;
            //找到没有被使用过的数字第quotient个，就是要添加进去的数字
            int cou = 0;
            int i = 1;
            for (; i < used.length; i++) {
                if (used[i] == 0) {
                    cou++;
                    if (cou == quotient) {
                        break;
                    }
                }
            }
            res.append(i);
            used[i] = 1;
            n--;
        }
        //经过上面的循环还少一个数字，因为n==1的时候没有进入，最后再将没有使用的那个数字添加进去
        for (int i = 1; i < used.length; i++) {
            if (used[i] == 0) {
                res.append(i);
                break;
            }
        }
        return res.toString();
    }

/*    public static void main(String[] args) {
        String res = new Solution_60().getPermutation(4, 2);
        System.out.println(res);
    }*/
}
