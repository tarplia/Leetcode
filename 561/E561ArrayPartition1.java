// Source: https://leetcode.com/problems/array-partition-i/

public class E561ArrayPartition1 {
    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;      // start of first half
        int j = mid + 1;    // start of second half
        int k = 0;

        while (i <= mid || j <= end) {
            if (i > mid)
                temp[k++] = nums[j++];
            else if (j > end)
                temp[k++] = nums[i++];
            else if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        for (i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);    // first half
            mergeSort(nums, mid + 1, end);  // second half
            merge(nums, start, mid, end);
        }
    }

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public int arrayPairSum(int[] nums) {
        mergeSort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        E561ArrayPartition1 program = new E561ArrayPartition1();

        System.out.println(program.arrayPairSum(new int[] {3, -1}));
        System.out.println(program.arrayPairSum(new int[] {1, 4, 2, 3}));
        System.out.println(program.arrayPairSum(new int[] {-1, 4, 2, -3, 5, 3}));
    }
}
