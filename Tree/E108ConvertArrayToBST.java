public class E108ConvertArrayToBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return constructBSTRecursive(nums, 0, nums.length - 1);
    }

    public static TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if (right < left) return null;

        int mid = (right + left)/2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBSTRecursive(nums, left, mid - 1);
        current.right = constructBSTRecursive(nums, mid + 1, right);

        return current;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};

        System.out.println(sortedArrayToBST(nums));
    }
}
