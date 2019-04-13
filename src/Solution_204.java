public class Solution_204 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrimes[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrimes[i])//例如前面i=2时已将i=4的所有倍数设置完成，直接跳过
                continue;
            for (int j = i * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }
}
