public class Solution_69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int k = x / mid;
            if (k == mid) {
                return mid;
            } else if (k > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low-1;
    }

/*    public static void main(String[] args) {
        int i = new Solution_69().mySqrt(14);
        System.out.println(i);
    }*/
}
