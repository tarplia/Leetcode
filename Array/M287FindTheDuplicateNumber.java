/* Given an array of integers nums containing n + 1 integers
 * where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */

class M287FindTheDuplicateNumber {
    // Two Pointers Approach.
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    // // Cyclic Sort Algo
    // public int findDuplicate(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == i + 1) continue;
    //
    //         while (nums[i] != nums[nums[i] - 1]) {
    //             int temp = nums[i];
    //             nums[i] = nums[temp - 1];
    //             nums[temp - 1] = temp;
    //         }
    //     }
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != i + 1) return nums[i];
    //     }
    //
    //     return 0;
    // }

    public void test() {
        int[] input1 = new int[] {1,3,4,2,2};
        int[] input2 = new int[] {3,1,3,4,2};
        int[] input3 = new int[0];

        System.out.println("The duplicate number is: " + findDuplicate(input1));
        System.out.println("The duplicate number is: " + findDuplicate(input2));
        System.out.println("The duplicate number is: " + findDuplicate(input3));
    }

    public static void main(String[] args) {
        M287FindTheDuplicateNumber prog = new M287FindTheDuplicateNumber();
        prog.test();
    }
}
