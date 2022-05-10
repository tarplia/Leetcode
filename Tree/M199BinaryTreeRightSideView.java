/* Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class M199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

                if (i == size - 1) result.add(curr.val);
            }
        }

        return result;
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

        System.out.println(rightSideView(A));
        System.out.println(rightSideView(W));
    }

    public static void main(String[] args) {
        M199BinaryTreeRightSideView prog = new M199BinaryTreeRightSideView();
        prog.test();
    }
}
