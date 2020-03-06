// Source: https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class E20ValidParan {
    public boolean isCharAClosingBracket(char c) {
        return (c == ')' || c == '}' || c == ']');
    }

    public boolean isMatching(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isCharAClosingBracket(c)) {
                if (stack.size() == 0) return false;

                if (isMatching(stack.peek(), c)) stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }

        return stack.empty();
    }

    private void test(String s) {
        System.out.println("Is \"" + s + "\" valid? " + isValid(s));
    }

    public static void main(String[] args) {
        E20ValidParan program = new E20ValidParan();

        program.test("()");
        program.test("()[]{}");
        program.test("[)");
        program.test("[)]");
        program.test("[{]}");
        program.test("{[]}");
        program.test("[]}");
    }

}
