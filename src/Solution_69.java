public class Solution_69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while (low < high) {
            int mid = (low + high) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                if (x/(mid+1)<(mid+1)) {
                    return mid;
                } else {
                    low = mid;
                }
            } else {
                high = mid;
            }
        }
        return low;
    }
}
