public class LC226InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void swapTree(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        invertTree(root.left);
        invertTree(root.right);

        swapTree(root);

        return root;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);

        A.left = B;
        A.right = C;

        invertTree(A);
        System.out.println(A.val);
        System.out.println(A.left.val);
        System.out.println(A.right.val);
    }
}
