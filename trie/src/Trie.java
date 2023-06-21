/**
 * 实现前缀树
 *
 * @author dingqinglei
 */
public class Trie {
    /**
     * 前缀树的根节点，用于记录一些全局的统计信息，比如当前前缀树中
     * 一共包含多少个字符串
     */
    private final Node root = new Node(0, 0);

    /**
     * 向前缀树中添加新的字符串
     *
     * @param str
     */
    public void add(String str) {
        // 表示当前新增一个新的字符串
        root.pass++;
        Node cur = root;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (cur.paths[index] == null) {
                // 说明当前节点还不存在
                cur.paths[index] = new Node(0, 0);
            }
            cur.paths[index].pass++;
            cur = cur.paths[index];
        }
        // 当前字符串以cur节点作为结尾
        cur.end++;
    }

    /**
     * 返回前缀树中是否包含指定的字符串
     *
     * @param str
     * @return
     */
    public boolean contains(String str) {
        char[] chars = str.toCharArray();
        Node cur = root;
        for (char c : chars) {
            int index = c - 'a';
            if (cur.paths[index] == null) {
                // 说明根本不存在
                return false;
            }
            cur = cur.paths[index];
        }
        // 如果走到了一个节点的结尾，但是发现当前节点的end是0，那么说明不包含
        // 这个字符串
        return cur.end != 0;
    }

    /**
     * 返回以str为前缀的字符串的数目
     *
     * @param str
     * @return
     */
    public int search(String str) {
        char[] chars = str.toCharArray();
        Node cur = root;
        for (char c : chars) {
            int index = c - 'a';
            if (cur.paths[index] == null) {
                return 0;
            }
            cur = cur.paths[index];
        }
        return cur.end;
    }

    public int getPrefixNum(String prefix) {
        char[] chars = prefix.toCharArray();
        Node cur = root;
        for (char c : chars) {
            int index = c - 'a';
            if (cur.paths[index] == null) {
                return 0;
            }
            cur = cur.paths[index];
        }
        return cur.pass;
    }

    /**
     * 从前缀树中删除当前字符串
     *
     * @param str
     */
    public void remove(String str) {
        if (!contains(str)) {
            return;
        }

        char[] chars = str.toCharArray();
        root.pass--;
        Node cur = root;
        for (char c : chars) {
            int index = c - 'a';
            if (--cur.paths[index].pass == 0) {
                cur.paths[index] = null;
                return;
            }
            cur = cur.paths[index];
        }
        cur.end--;
    }

    private static class Node {
        private int pass;
        private int end;
        private final Node[] paths = new Node[26];

        public Node(int pass, int end) {
            this.pass = pass;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getPass() {
            return pass;
        }

        public void setPass(int pass) {
            this.pass = pass;
        }

        public Node[] getPaths() {
            return paths;
        }
    }
}
