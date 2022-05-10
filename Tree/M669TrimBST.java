class M669TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
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

        System.out.println(trimBST(A, 1, 3).val);
        System.out.println(trimBST(W, 1, 2).val);
    }

    public static void main(String[] args) {
        M669TrimBST prog = new M669TrimBST();
        prog.test();
    }
}
