// Source: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

import java.util.Random;

public class E921MinAddValidParantheses {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int addParan = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;

            if (count < 0) {
                addParan++;
                count = 0;
            }
        }

        return addParan + Math.abs(count);
    }

    static class TestCaseGeneratorImpl implements TestCaseGenerator {
        private String generateRandomTestCase(int n) {
            char[] chars = new char[n];
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                chars[i] = r.nextInt(2) == 1 ? '(' : ')';
            }
            return new String(chars);
        }

        @Override
        public void runTestCase(int n) {
            new E921MinAddValidParantheses().minAddToMakeValid(generateRandomTestCase(n));
        }
    }

    public static void main(String[] args) {
        E921MinAddValidParantheses program = new E921MinAddValidParantheses();

        System.out.println(program.minAddToMakeValid(")()"));
        System.out.println(program.minAddToMakeValid(""));
        System.out.println(program.minAddToMakeValid("()))("));
        System.out.println(program.minAddToMakeValid(")(()"));

        TimeGrapher.graphTime(new TestCaseGeneratorImpl(), 10000000);
    }
}
