import java.util.HashSet;

public class Solution_202 {
    public boolean isHappy(int n) {
        int sum;
        HashSet<Integer> integerHashSet = new HashSet<>();
        while (n != 1) {
            if (integerHashSet.contains(n)) {
                return false;
            } else {
                integerHashSet.add(n);
            }
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
}
