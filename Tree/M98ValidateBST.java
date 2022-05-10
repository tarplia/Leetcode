/* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
*/

class M98ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public void test() {
        TreeNode A = new TreeNode(2);
        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(3);
        A.left = B;
        A.right = C;

        TreeNode W = new TreeNode(1);
        TreeNode X = new TreeNode(2);
        TreeNode Y = new TreeNode(3);
        TreeNode Z = new TreeNode(4);
        W.left = X;
        X.left = Y;
        Y.left = Z;

        System.out.println(isValidBST(A));
        System.out.println(isValidBST(W));
    }

    public static void main(String[] args) {
        M98ValidateBST prog = new M98ValidateBST();
        prog.test();
    }
}
