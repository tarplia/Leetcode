import java.util.Queue;
import java.util.LinkedList;

class E111MinDepthOfBinaryTree {
    // // DFS Approach
    // public int minDepth(TreeNode root) {
    //     if (root == null) return 0;
    //
    //     int left = minDepth(root.left);
    //     int right = minDepth(root.right);
    //
    //     if (left == 0 || right == 0) return left > right ? left + 1 : right + 1;
    //
    //     return left < right ? left + 1 : right + 1;
    // }

    // BFS Approach
    public int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return depth;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left == null && curr.right == null) return depth;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return depth;
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

        System.out.println(minDepth(A));
        System.out.println(minDepth(W));
    }

    public static void main(String[] args) {
        E111MinDepthOfBinaryTree prog = new E111MinDepthOfBinaryTree();
        prog.test();
    }
}
