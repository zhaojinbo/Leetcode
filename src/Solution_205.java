import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> characterHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterHashMap.put(s.charAt(i), t.charAt(i));
        }

        Collection<Character> values = characterHashMap.values();
        HashSet<Character> characterSet = new HashSet<>(values);
        if (characterSet.size()<values.size()){
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            chars[i] = characterHashMap.get(chars[i]);
        }
        String s1 = new String(chars);
        return s1.equals(t);
    }
}
