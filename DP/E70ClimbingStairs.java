/* You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class E70ClimbingStairs {
//     public int climbStairs(int n) {
//         if (n <= 0) return 0;
//         if (n == 1) return 1;
//         if (n == 2) return 2;

//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }

//     public int climbStairs(int n) {
//         HashMap<Integer, Integer> memo = new HashMap<>();
//         memo.put(1, 1);
//         memo.put(2, 2);

//         return climbStairs(n, memo);
//     }

//     private int climbStairs(int n, HashMap<Integer, Integer> memo) {
//         if (memo.containsKey(n)) return memo.get(n);

//         memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
//         return memo.get(n);
//     }

//     int[] dp;

//     public int climbStairs(int n) {
//         if (n <= 1) return  1;

//         dp = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;

//         return helper(n);
//     }

//     private int helper(int n) {
//         if (dp[n] > 0) return dp[n];

//         return dp[n - 1] + dp[n - 2];
//     }

    // DP Approach.
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int[] noOfStepsTo = new int[n + 1];
        noOfStepsTo[1] = 1;
        noOfStepsTo[2] = 2;

        for (int i = 3; i <= n; i++) {
            noOfStepsTo[i] = noOfStepsTo[i - 1] + noOfStepsTo[i - 2];
        }

        return noOfStepsTo[n];
    }

    public void test() {
        int input1 = 2;
        int input2 = 4;
        int input3 = 1;

        System.out.println("How many distinct way to climb " + input1 + " steps? " + climbStairs(input1));
        System.out.println("How many distinct way to climb " + input2 + " steps? " + climbStairs(input2));
        System.out.println("How many distinct way to climb " + input3 + " steps? " + climbStairs(input3));
    }

    public static void main(String[] args) {
        E70ClimbingStairs prog = new E70ClimbingStairs();
        prog.test();
    }
}
