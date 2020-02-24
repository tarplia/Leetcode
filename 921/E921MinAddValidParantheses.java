// Source: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

public class E921MinAddValidParantheses {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int addParan  = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else
                count--;

            if (count < 0) {
                addParan++;
                count = 0;
            }
        }

        return addParan + Math.abs(count);
    }

    public static void main(String[] args) {
        E921MinAddValidParantheses program = new E921MinAddValidParantheses();

        System.out.println(program.minAddToMakeValid(")()"));
        System.out.println(program.minAddToMakeValid(""));
        System.out.println(program.minAddToMakeValid("()))("));
        System.out.println(program.minAddToMakeValid(")(()"));
    }
}
