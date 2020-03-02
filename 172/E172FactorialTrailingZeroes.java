// Source: https://leetcode.com/problems/factorial-trailing-zeroes/

public class E172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        long multipleFive = 5;

        while (multipleFive <= n) {
            count += n / multipleFive;
            multipleFive *= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        E172FactorialTrailingZeroes program = new E172FactorialTrailingZeroes();

        System.out.println(program.trailingZeroes(5));
        System.out.println(program.trailingZeroes(20));
        System.out.println(program.trailingZeroes(25));
        System.out.println(program.trailingZeroes(50));
        System.out.println(program.trailingZeroes(2147483647));
    }
}
