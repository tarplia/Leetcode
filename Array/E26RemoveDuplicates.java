// Source:
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class E26RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) nums[count++] = nums[i];
        }

        return count;
    }

    public static void main(String[] args) {
        E26RemoveDuplicates program = new E26RemoveDuplicates();

        System.out.println(program.removeDuplicates(new int[] {1, 1, 2}));
        System.out.println(program.removeDuplicates(new int[] {0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 5}));
        System.out.println(program.removeDuplicates(new int[] {}));
    }
}
