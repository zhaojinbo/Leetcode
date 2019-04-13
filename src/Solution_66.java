import java.util.Arrays;

public class Solution_66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        if (digits[digits.length - 1] == 10) {
            if (digits.length > 1) {
                int[] temp = plusOne(Arrays.copyOfRange(digits, 0, digits.length - 1));
                digits = Arrays.copyOf(temp, temp.length+1);
            } else {
                digits = new int[]{1, 0};
            }
        }
        return digits;
    }
}
