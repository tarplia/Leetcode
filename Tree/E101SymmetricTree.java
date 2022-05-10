class E101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public void test() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        A.left = B;
        A.right = C;
        B.left = D;

        TreeNode W = new TreeNode(1);
        TreeNode X = new TreeNode(2);
        TreeNode Y = new TreeNode(2);
        W.left = X;
        W.right = Y;

        System.out.println(isSymmetric(A));
        System.out.println(isSymmetric(W));
    }

    public static void main(String[] args) {
        E101SymmetricTree prog = new E101SymmetricTree();
        prog.test();
    }
}
