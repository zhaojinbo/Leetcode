public class Solution_58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(' ')+1).length();
    }
}
