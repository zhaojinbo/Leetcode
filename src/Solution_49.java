import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_49 {
    /**
     * 时间复杂度：12ms，98.96%
     * 空间复杂度：41.6 MB，98.42%
     */
    public List<List<String>> groupAnagramsOne(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        //字母异位词都有一个共同的本质，我们以他们共同的本质为key以一个存放他们的容器list为value构建hashMap
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //在本方法中，我们以排序后的字符串作为字母异位词的“本质”
            Arrays.sort(chars);
            String strAfterSort = new String(chars);
            if (hashMap.get(strAfterSort) == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(strAfterSort, list);
                res.add(list);
            } else {
                hashMap.get(strAfterSort).add(str);
            }
        }
        return res;
    }

    /**
     * 时间复杂度：9ms，99.76%
     * 空间复杂度：41.8 MB，98.19%
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        //字母异位词都有一个共同的本质，我们以他们共同的本质为key以一个存放他们的容器list为value构建hashMap
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //在本方法中，我们以字符串中每个字符的代表的质数的乘积作为字母异位词的“本质”
            int key = 1;
            for (char ch : chars) {
                key *= prime[ch - 'a'];
            }
            if (hashMap.get(key) == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
                res.add(list);
            } else {
                hashMap.get(key).add(str);
            }
        }
        return res;
    }
}
