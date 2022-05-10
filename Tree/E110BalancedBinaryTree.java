class E110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;

        int right = depth(root.right);
        int left = depth(root.left);

        return right > left ? right + 1 : left + 1;
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
        TreeNode Y = new TreeNode(3);
        TreeNode Z = new TreeNode(4);
        W.left = X;
        X.left = Y;
        Y.left = Z;

        System.out.println(isBalanced(A));
        System.out.println(isBalanced(W));
    }

    public static void main(String[] args) {
        E110BalancedBinaryTree prog = new E110BalancedBinaryTree();
        prog.test();
    }
}
