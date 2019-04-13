public class Solution_941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }
        if (maxIndex == 0 || maxIndex == A.length - 1)
            return false;
        for (int i = 1; i <= maxIndex; i++) {
            if (A[i] <= A[i - 1]) {
                return false;
            }
        }
        for (int i = maxIndex + 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }
        return true;

    }
}
