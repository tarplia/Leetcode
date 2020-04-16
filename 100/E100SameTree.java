// Source: https://leetcode.com/problems/same-tree/

public class E100SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val;}
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        E100SameTree program = new E100SameTree();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        A.left = B;
        A.right = C;
        B.left = D;

        TreeNode W = new TreeNode(1);
        TreeNode X = new TreeNode(2);
        TreeNode Y = new TreeNode(3);
        TreeNode Z = new TreeNode(4);
        W.left = X;
        W.right = Y;
        X.left = Z;

        System.out.println(program.isSameTree(null, W));
        System.out.println(program.isSameTree(A, W));
    }
}
