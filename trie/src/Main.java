public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("aaaa");
        trie.add("aabb");
        trie.add("bba");
        trie.add("aaba");
        trie.remove("aaba");
        trie.remove("aabb");
        System.out.println(trie.getPrefixNum("aab"));
    }
}