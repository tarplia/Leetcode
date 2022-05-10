/* Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * (1) Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * (2) Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * (3) Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * (4) '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */

import java.util.Stack;

class M678ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Character> open = new Stack<>();
        Stack<Character> star = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') open.push('(');
            else if (s.charAt(i) == '*') star.push('*');
            else if (!open.empty()) open.pop();
            else if (!star.empty()) star.pop();
            else return false;

            i++;
        }

        return open.size() <= star.size();
    }

    public void test() {
        String input1 = "()";
        String input2 = "(*))";
        String input3 = "(*)))";
        String input4 = ")";
        String input5 = "";


        System.out.println("Is \"" + input1 + "\" a valid parenthesis? " + checkValidString(input1));
        System.out.println("Is \"" + input2 + "\" a valid parenthesis? " + checkValidString(input2));
        System.out.println("Is \"" + input3 + "\" a valid parenthesis? " + checkValidString(input3));
        System.out.println("Is \"" + input4 + "\" a valid parenthesis? " + checkValidString(input4));
        System.out.println("Is \"" + input5 + "\" a valid parenthesis? " + checkValidString(input5));
    }

    public static void main(String[] args) {
        M678ValidParenthesisString prog = new M678ValidParenthesisString();
        prog.test();
    }
}
