// Source: https://leetcode.com/problems/fizz-buzz/

import java.util.*;

public class E412FizzBuzz {
    private boolean isMultipleOf3(int num) {
        return (num % 3 == 0);
    }

    private boolean isMultipleOf5(int num) {
        return (num % 5 == 0);
    }

    public List<String> fizzBuzz(int n) {
        ArrayList<String> output = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            if (isMultipleOf3(i) && isMultipleOf5(i)) {
                output.add("FizzBuzz");
            } else if (isMultipleOf3(i)) {
                output.add("Fizz");
            } else if (isMultipleOf5(i)) {
                output.add("Buzz");
            } else {
                output.add(Integer.toString(i));
            }
        }

        return output;
    }

    public static void main(String[] args) {
        E412FizzBuzz program = new E412FizzBuzz();

        System.out.println(program.fizzBuzz(15));
        System.out.println(program.fizzBuzz(1));
        System.out.println(program.fizzBuzz(20));
    }
}
