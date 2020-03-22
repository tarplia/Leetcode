// Source: https://leetcode.com/problems/reverse-string/

import java.util.Random;

public class E344ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    private void test(char[] letters) {
        reverseString(letters);

        for (char letter : letters) {
            System.out.print(letter);
        }

        System.out.println();
    }

    static class TestCaseGeneratorImpl implements TestCaseGenerator {
        private char[] generateRandomTestCase(int n) {
            char[] chars = new char[n];
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                chars[i] = (char)(r.nextInt(26) + 65);
            }
            return chars;
        }

        @Override
        public void runTestCase(int n) {
            new E344ReverseString().reverseString(generateRandomTestCase(n));
        }
    }

    public static void main(String[] args) {
        E344ReverseString program = new E344ReverseString();

        program.test(new char[] {'h', 'e', 'l', 'l', 'o'});
        program.test(new char[] {'A', 'b', 'C'});
        program.test(new char[] {});

        TimeGrapher.graphTime(new TestCaseGeneratorImpl(), 10000000);
    }
}
