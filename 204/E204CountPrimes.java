// Source: https://leetcode.com/problems/count-primes/

import java.util.ArrayList;

public class E204CountPrimes {
    public boolean isPrime (int num, ArrayList<Integer> primes) {
        if (num < 2) return false;

        for (int i = 0; primes.get(i) <= Math.sqrt(num); i++) {
            if (num % primes.get(i) == 0) return false;
        }

        return true;
    }

    public int countPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<Integer>();

        if (n <= 2) return 0;

        primes.add(0, 2);

        for (int i = 3; i < n; i += 2) {
            int index = primes.size();
            if (isPrime(i, primes)) primes.add(index, i);
        }

        return primes.size();
    }

    public static void main(String[] args) {
        E204CountPrimes program = new E204CountPrimes();

        System.out.println("Total prime numbers less than 0 : " + program.countPrimes(0));
        System.out.println("Total prime numbers less than 2 : " + program.countPrimes(2));
        System.out.println("Total prime numbers less than 5 : " + program.countPrimes(5));
        System.out.println("Total prime numbers less than 10 : " + program.countPrimes(10));
        System.out.println("Total prime numbers less than 20 : " + program.countPrimes(20));
        System.out.println("Total prime numbers less than 499999 : " + program.countPrimes(499999));
    }
}
