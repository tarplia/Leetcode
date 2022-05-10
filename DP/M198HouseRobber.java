/* You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */

class M198HouseRobber {
    // // Iterative Approach.
    // public int rob(int[] nums) {
    //     int rob1 = 0;
    //     int rob2 = 0;
    //
    //     for (int num : nums) {
    //         int temp = Math.max(rob1 + num, rob2);
    //         rob1 = rob2;
    //         rob2 = temp;
    //     }
    //
    //     return rob2;
    // }

    // DP Approach.
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] moneyTo = new int[n];
        moneyTo[0] = nums[0];
        moneyTo[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            moneyTo[i] = Math.max(moneyTo[i - 1], moneyTo[i - 2] + nums[i]);
        }

        return moneyTo[n - 1];
    }

    public void test() {
        int[] input1 = new int[] {1,2,3,1};
        int[] input2 = new int[] {2,7,9,3,1};
        int[] input3 = new int[0];

        System.out.println("The max money robbed: " + rob(input1));
        System.out.println("The max money robbed: " + rob(input2));
        System.out.println("The max money robbed: " + rob(input3));
    }

    public static void main(String[] args) {
        M198HouseRobber prog = new M198HouseRobber();
        prog.test();
    }
}
