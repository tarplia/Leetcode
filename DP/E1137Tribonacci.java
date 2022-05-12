// Source: https://leetcode.com/problems/n-th-tribonacci-number/

public class E1137Tribonacci {
    Integer[] arr = new Integer[100];

    public int tribonacci(int n) {
        int result = 0;

        if (arr[n] != null) return arr[n];

        if (n <= 1) return n;
        else if (n == 2) return 1;
        else result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

        arr[n] = result;

        return result;
    }

    public static void main(String[] args) {
        E1137Tribonacci program = new E1137Tribonacci();

        System.out.println(program.tribonacci(0));
        System.out.println(program.tribonacci(5));
        System.out.println(program.tribonacci(15));
        System.out.println(program.tribonacci(25));
        System.out.println(program.tribonacci(35));
    }
}
