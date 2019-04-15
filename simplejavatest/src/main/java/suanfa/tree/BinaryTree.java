package suanfa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/10/18
 */
public class BinaryTree {
    public class TreeNode {
        private String value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }

        public TreeNode(String value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    private TreeNode root;

    private int size;

    private int depth;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public List<String> preOrder() {
        List<String> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode node, List<String> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public List<String> midOrder() {
        List<String> result = new ArrayList<>();
        midOrder(root, result);
        return result;
    }

    public void midOrder(TreeNode node, List<String> list) {
        if (node == null) {
            return;
        }
        midOrder(node.left, list);
        list.add(node.value);
        midOrder(node.right, list);
    }

    public List<String> postOrder() {
        List<String> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode node, List<String> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.value);
    }

    public void createTree() {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode h = new TreeNode("h");
        TreeNode i = new TreeNode("i");
        TreeNode j = new TreeNode("j");
        TreeNode k = new TreeNode("k");
        TreeNode l = new TreeNode("l");
        TreeNode m = new TreeNode("m");
        TreeNode n = new TreeNode("n");
        TreeNode o = new TreeNode("o");
        TreeNode p = new TreeNode("p");
        TreeNode q = new TreeNode("q");
        TreeNode r = new TreeNode("r");
        TreeNode s = new TreeNode("s");
        TreeNode t = new TreeNode("t");
        TreeNode u = new TreeNode("u");
        TreeNode v = new TreeNode("v");
        TreeNode w = new TreeNode("w");
        TreeNode x = new TreeNode("x");
        TreeNode y = new TreeNode("y");
        TreeNode z = new TreeNode("z");
        b.setLeft(a);
        b.setRight(c);
        f.setLeft(e);
        d.setLeft(b);
        d.setRight(f);
        h.setRight(i);
        k.setRight(l);
        j.setLeft(h);
        j.setRight(k);
        g.setLeft(d);
        g.setRight(j);
        o.setLeft(n);
        q.setRight(r);
        p.setLeft(o);
        p.setRight(q);
        u.setLeft(t);
        u.setRight(v);
        z.setLeft(y);
        x.setRight(z);
        w.setLeft(u);
        w.setRight(x);
        s.setLeft(p);
        s.setRight(w);
        m.setLeft(g);
        m.setRight(s);
        this.root = m;
    }

    public void createTree2() {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        a.setLeft(b);
        a.setRight(c);
        this.root=a;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree2();
        List<String> preOrder = tree.preOrder();
        System.out.println(preOrder);
        List<String> midOrder = tree.midOrder();
        System.out.println(midOrder);
        List<String> postOrder = tree.postOrder();
        System.out.println(postOrder);
    }

}
