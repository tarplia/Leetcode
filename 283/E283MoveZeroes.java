// Source: https://leetcode.com/problems/move-zeroes/

public class E283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    private void test(int[] nums) {
        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        E283MoveZeroes program = new E283MoveZeroes();

        program.test(new int[] {0, -1, 0, 0, 5});
        program.test(new int[] {0, 1, 0, -3, 5});
        program.test(new int[] {0});
    }
}
