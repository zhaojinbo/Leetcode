public class Solution_91 {
    public int numDecodings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] count = new int[length];
        if (s.charAt(0) == '0') {
            return 0;
        }
        count[0] = 1;
        if (length == 1) {
            return count[0];
        }
        //length大于1的时候
        if (chars[0] == '1') {
            if (chars[1] == '0') {
                count[1] = 1;
            } else {
                count[1] = 2;
            }
        } else if (chars[0] == '2') {
            if (chars[1] < '7' && chars[1] != '0') {
                count[1] = 2;
            } else {
                count[1] = 1;
            }
        } else {
            if (chars[1] != '0') {
                count[1] = 1;
            } else {
                return 0;
            }
        }
        for (int i = 2; i < length; i++) {
            if (chars[i - 1] == '1') {
                if (chars[i] == '0') {
                    count[i] = count[i - 2];
                } else {
                    count[i] = count[i - 1] + count[i - 2];
                }
            } else if (chars[i - 1] == '2') {
                if (chars[i] < '7' && chars[i] != '0') {
                    count[i] = count[i - 1] + count[i - 2];
                } else if (chars[i] == '0') {
                    count[i] = count[i - 2];
                } else {
                    count[i] = count[i - 1];
                }
            } else {
                if (chars[i] != '0') {
                    count[i] = count[i - 1];
                } else {
                    return 0;
                }
            }
        }
        return count[length - 1];
    }
}
