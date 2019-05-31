import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        // Using char[] and filling it by ')'
        char[] chars = new char[n * 2];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ')';
        }

        generate(list, chars, 0, 0, n);
        return list;
    }

    private void generate(List<String> list, char[] chars, int index, int opening, int depth) {
        // when chars is "((((", index must be 4 and opening must be 4
        // the largest index for new parenthesis is 8 when chars reaches "((((" + "))))"

        // when chars is "(()(", index must be 4 and opening must be 2
        // the largest index for new parenthesis is 6 when chars reaches "(()(" + "))"

        // reduce maximum recursion depth to N with this opening count
        for (int end = index + opening; index <= end; index++) {
            // new open parenthesis
            chars[index] = '(';

            if (depth == 1) {
                // maximum recursion depth is N - 1

                // this op will cost amost all of runing time when increasing N
                // replacing it by a counter will reveal real optimizing effect.
                list.add(new String(chars));
            } else {
                // chars[index] must be '('
                generate(list, chars, index + 1, opening + 1, depth - 1);
            }

            //  close a previous opening '('
            chars[index] = ')';
            opening--;
        }
    }
}
