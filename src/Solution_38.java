public class Solution_38 {
    /**
     * 报数
     * 其前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * @param n 第几项
     * @return 表示报数结果的字符串
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String lastSequence = countAndSay(n - 1);
        char[] charArray = lastSequence.toCharArray();
        StringBuilder resultString = new StringBuilder("");
        //current_char用来表示当前统计的字符
        char current_char = charArray[0];
        //current_count用来表示当前统计的字符个数
        int current_count = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] != current_char) {
                //当遇到字符发生变化，将结果进行追加，重置current_char和current_count
                resultString = resultString.append(current_count).append(current_char);
                current_char = charArray[i];
                current_count = 1;
            } else {
                current_count++;
            }
        }
        //将最后的字符及其个数追加到结果
        resultString = resultString.append(current_count).append(current_char);
        return resultString.toString();
    }
}
