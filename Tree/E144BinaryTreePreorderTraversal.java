/* Given the root of a binary tree, return the preorder traversal of its nodes' values.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class E144BinaryTreePreorderTraversal {
    // BFS Approach
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      if (root == null) return list;

      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);

      while (!stack.isEmpty()) {
          while (root != null) {
              list.add(root.val);
              stack.push(root);
              root = root.left;
          }

          root = stack.pop();
          root = root.right;
      }

      return list;
    }

//     // DFS Approach (Recursive)
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();

//         helper(root, list);

//         return list;

//     }

//     public void helper(TreeNode root, List<Integer>list) {
//         if (root == null) return;

//         list.add(root.val);
//         helper(root.left, list);
//         helper(root.right, list);

//         return;
//     }
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

        System.out.println(preorderTraversal(A));
        System.out.println(preorderTraversal(W));
    }

    public static void main(String[] args) {
        E144BinaryTreePreorderTraversal prog = new E144BinaryTreePreorderTraversal();
        prog.test();
    }
}
