/* You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
*/

class M213HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);


        int[] startFromFirst = new int[n];
        int[] startFromSecond = new int[n];
        startFromFirst[0] = nums[0];
        startFromFirst[1] = Math.max(nums[0], nums[1]);
        startFromSecond[0] = 0;
        startFromSecond[1] = nums[1];

        for (int i = 2; i < n; i++) {
            startFromFirst[i] = Math.max(startFromFirst[i - 1], startFromFirst[i - 2] + nums[i]);
            startFromSecond[i] = Math.max(startFromSecond[i - 1], startFromSecond[i - 2] + nums[i]);
        }

        return Math.max(startFromFirst[n - 2], startFromSecond[n - 1]);
    }

    public void test() {
        int[] input1 = new int[] {1,2,3,1};
        int[] input2 = new int[] {2,3,2};
        int[] input3 = new int[0];

        System.out.println("The max money robbed: " + rob(input1));
        System.out.println("The max money robbed: " + rob(input2));
        System.out.println("The max money robbed: " + rob(input3));
    }

    public static void main(String[] args) {
        M213HouseRobberII prog = new M213HouseRobberII();
        prog.test();
    }
}
