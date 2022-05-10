/* Given the root of a binary tree, return the postorder traversal of its nodes' values.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class E145BinaryTreePostorderTraversal {
    // BFS Approach
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(0, curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        return list;
    }

    // // DFS Approach (Recursive)
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //
    //     helper(root, list);
    //
    //     return list;
    // }
    //
    // public void helper(TreeNode root, List<Integer> list) {
    //     if (root == null) return;
    //
    //     helper(root.left, list);
    //     helper(root.right, list);
    //     list.add(root.val);
    //
    //     return;
    // }

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

        System.out.println(postorderTraversal(A));
        System.out.println(postorderTraversal(W));
    }

    public static void main(String[] args) {
        E145BinaryTreePostorderTraversal prog = new E145BinaryTreePostorderTraversal();
        prog.test();
    }
}
