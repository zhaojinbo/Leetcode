public class Solution_264 {
    /**
     * 三指针法，利用丑数来生成下一个丑数，而不是逐个自然数判断是不是丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] index = new int[3];
        int[] uglys = new int[n];
        uglys[0] = 1;
        for (int i = 1; i < n; i++) {
            int fir = uglys[index[0]] * 2;
            int sec = uglys[index[1]] * 3;
            int thir = uglys[index[2]] * 5;
            int min = Math.min(fir, Math.min(sec, thir));
            // 这个地方不能用else，因为有可能存在fir、sec、thir相等的情况，此时他们对应的下标都要向后移动一位
            if (fir == min)
                index[0]++;
            if (sec == min)
                index[1]++;
            if (thir == min)
                index[2]++;
            uglys[i] = min;
        }
        return uglys[n-1];
    }
}
