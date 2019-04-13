public class Solution_125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        s = s.toLowerCase();
        int len = s.length();
        int low = 0;
        int high = len - 1;
        while (low < high) {
            char left = s.charAt(low);
            char right = s.charAt(high);
            while ((left < '0' || left > '9') && (left < 'a' || left > 'z')) {
                low++;
                if (low>=high)
                    return true;
                left = s.charAt(low);
            }
            while ((right < '0' || right > '9') && (right < 'a' || right > 'z')) {
                high--;
                if (high<=low)
                    return true;
                right = s.charAt(high);
            }
            if (left != right)
                return false;
            else {
                low++;
                high--;
            }
        }

        return true;
    }
}
