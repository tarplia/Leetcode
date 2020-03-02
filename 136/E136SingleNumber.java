// Source: https://leetcode.com/problems/single-number/

public class E136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        E136SingleNumber program = new E136SingleNumber();

        System.out.println(program.singleNumber(new int[] {2,2,1}));
        System.out.println(program.singleNumber(new int[] {2,2,1,1,4}));
        System.out.println(program.singleNumber(new int[] {2,4,2,5,1,1,4}));
    }
}
