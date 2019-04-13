public class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if (n<1){
            return false;
        }
        if (n==1){
            return true;
        }
        if (n%2==1){
            return false;
        }
        while (n!=1){
            if (n%2==1){
                return false;
            }
            n/=2;
        }
        return true;
    }
}
