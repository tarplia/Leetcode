/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.
*/

public class E20ValidParantheses {
    public boolean isMatched(String s, int start, int end) {
        boolean isClosed = false;
        int open = (start + end) / 2;
        int close = open + 1;

        if (s.length() == 2) {
            if ((s.charAt(open) == '(' && s.charAt(close) == ')') ||
                (s.charAt(open) == '{' && s.charAt(close) == '}') ||
                (s.charAt(open) == '[' && s.charAt(close) == ']')) {
                return true;
            }
        }

        if (s.length() > 2 && (close - open) % 2 == 0) {
            return false;
        }

        while (open != start) {
            if (s.charAt(open) == ')' || s.charAt(open) == '}' ||   s.charAt(open) == ']') {
                return false;
            }

            if ((s.charAt(open) == '(' && s.charAt(close) == ')') ||
                (s.charAt(open) == '{' && s.charAt(close) == '}') ||
                (s.charAt(open) == '[' && s.charAt(close) == ']')) {
                isClosed = true;
            }
            open = open - 1;
            close = close + 1;
        }
        return isClosed;
    }

    public boolean isValid(String s) {
        int end = 0;
        int start = 0;
        int endOfString = s.length() - 1;

        if (s.length() % 2 != 0){
            return false;
        }

        if (s == "") {
            return true;
        }

        //System.out.println("start = " + start);
        //System.out.println("end = " + end);
        //System.out.println(isMatched(s, start, end));

        if (s.length() == 2 && !(isMatched(s, start, endOfString))) {
            return false;
        }

        while (s.length() > 2 && start <= endOfString) {
            if (s.charAt(start) == ')' || s.charAt(start) == '}' || s.charAt(start) == ']') {
                return false;
            }

            if (s.charAt(start) == '(') {
                end = s.indexOf(')');
            }

            if (s.charAt(start) == '{') {
                end = s.indexOf('}');
            }

            if (s.charAt(start) == '[') {
                end = s.indexOf(']');
            }

            if(!isMatched(s, start, end)) {
                return false;
            }

            start = end + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        E20ValidParantheses program = new E20ValidParantheses();
        System.out.println(program.isValid("()"));
        System.out.println(program.isValid("[)"));
        System.out.println(program.isValid("()[]"));
        System.out.println(program.isValid("([)"));
        System.out.println(program.isValid("({[]})"));
        System.out.println(program.isValid("({)}"));
        System.out.println(program.isValid(""));
        System.out.println(program.isValid("(()("));
    }
}
