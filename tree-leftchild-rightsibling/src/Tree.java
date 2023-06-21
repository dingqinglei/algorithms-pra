import java.util.*;

/**
 * 使用左孩子右兄弟表示一棵树
 *
 * @author dingqinglei
 */
public class Tree {
    private TreeNode root;

    public void create() {
        Queue<TreeNode> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入根节点的值:");
        int val = sc.nextInt();
        root = new TreeNode(val);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println("请输入" + front.val + "的孩子列表:");
            TreeNode sibling = front;
            while (true) {
                int child = sc.nextInt();
                if (child == -1) {
                    break;
                }
                TreeNode childNode = new TreeNode(child);
                queue.add(childNode);
                if (front.getLeftChild() == null) {
                    // 第一个孩子设置为左孩子
                    front.setLeftChild(childNode);
                } else {
                    // 之后就开始
                    sibling.setRightSibling(childNode);
                }
                sibling = childNode;
            }
        }
    }

    public List<Integer> preorder() {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.getLeftChild() != null) {
                TreeNode mostRight = cur.getLeftChild();
                while (mostRight.getRightSibling() != null && mostRight.getRightSibling() != cur) {
                    mostRight = mostRight.getRightSibling();
                }

                if (mostRight.getRightSibling() == null) {
                    res.add(cur.val);
                    mostRight.setRightSibling(cur);
                    cur = cur.getLeftChild();
                    continue;
                }

                mostRight.setRightSibling(null);
            } else {
                res.add(cur.val);
            }
            cur = cur.getRightSibling();
        }
        return res;
    }

    public List<Integer> inorder() {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.getLeftChild() != null) {
                TreeNode mostRight = cur.getLeftChild();
                while (mostRight.getRightSibling() != null && mostRight.getRightSibling() != cur) {
                    mostRight = mostRight.getRightSibling();
                }

                if (mostRight.getRightSibling() != cur) {
                    mostRight.setRightSibling(cur);
                    cur = cur.getLeftChild();
                    continue;
                }

                res.add(cur.val);
                mostRight.setRightSibling(null);
            } else {
                res.add(cur.val);
            }
            cur = cur.getRightSibling();
        }

        return res;
    }

    private static class TreeNode {
        private final int val;
        private TreeNode leftChild;
        private TreeNode rightSibling;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightSibling(TreeNode rightSibling) {
            this.rightSibling = rightSibling;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public TreeNode getRightSibling() {
            return rightSibling;
        }
    }
}
