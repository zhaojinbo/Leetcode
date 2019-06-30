public class Solution_211 {
    /**
     * 字典树或者叫前缀树，通常用来表示字符串，每个节点表示一个字符，但不没有真的存储字符
     * 每一个节点有两个属性，isWord表示从根节点出发到这里构成的字符串是不是我们要存储的关键字
     * children数组用来表示与它相邻的下一个字符都有哪些，
     * 如果children[i]!=null，那么表示与其相邻的下一个字符中有('a'+i)所表示的字符，当然这就限制了字典树不能够存储相同的两个字符串，与set类似
     * 经过上面的解释，我们能够看出，字典树有一个很明显的特点，那就是存储具有相同前缀的字符串，相同部分只需要存储一份
     */
    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            this.isWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Solution_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word, word.length(), 0);
    }

    private boolean search(TrieNode root, String word, int length, int index) {
        //当到达字符串的末尾时，我们还需要判断，此处节点所表示的字符串是否是我们当初存放的字符串
        if (index == length) {
            return root.isWord;
        }
        if (word.charAt(index) == '.') {
            //当当前字符为'.'时，我们需要使用回溯算法来遍历所有的解空间
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    boolean result = search(root.children[i], word, length, index + 1);
                    if (result) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            //当当前字符不是'.'时，我们使用普通的递归方法
            int i = word.charAt(index) - 'a';
            if (root.children[i] != null) {
                return search(root.children[i], word, length, index + 1);
            } else {
                return false;
            }
        }
    }

/*    public static void main(String[] args) {
        Solution_211 wordDictionary = new Solution_211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean res1 = wordDictionary.search("pad");
        boolean res2 = wordDictionary.search("bad");
        boolean res3 = wordDictionary.search(".ad");
        boolean res4 = wordDictionary.search("m.a");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }*/
}
