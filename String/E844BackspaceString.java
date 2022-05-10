// Source: https://leetcode.com/problems/backspace-string-compare/

import java.io.*;
import java.util.*;

public class E844BackspaceString {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<Character>();
        Stack<Character> stackT = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') stackS.push(S.charAt(i));
            else if (!stackS.empty()) stackS.pop();
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') stackT.push(T.charAt(i));
            else if (!stackT.empty()) stackT.pop();
        }

        return stackS.equals(stackT);
    }

    private void test(String s, String t) {
        System.out.println("Comparing \"" + s + "\" and \"" + t + "\": " + backspaceCompare(s, t));
    }

    public static void main(String[] args) {
        E844BackspaceString program = new E844BackspaceString();

        program.test("ab#c", "ad#c");
        program.test("ab##", "c#d#");
        program.test("a##c", "#a#c");
        program.test("a#c", "b");
    }
}
