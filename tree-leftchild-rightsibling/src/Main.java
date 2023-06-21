
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.create();
        System.out.println(tree.preorder());
        System.out.println(tree.inorder());
    }
}