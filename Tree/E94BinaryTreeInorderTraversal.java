import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class E94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();

//         helper(root, list);

//         return list;
//     }

//     public void helper(TreeNode root, List<Integer> list) {
//         if (root == null) return;

//         helper(root.left, list);
//         list.add(root.val);
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

        System.out.println(inorderTraversal(A));
        System.out.println(inorderTraversal(W));
    }

    public static void main(String[] args) {
        E94BinaryTreeInorderTraversal prog = new E94BinaryTreeInorderTraversal();
        prog.test();
    }
}
