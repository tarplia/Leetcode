// Source: https://leetcode.com/problems/valid-palindrome/

public class E125ValidPalindrome {
    private StringBuffer cleanString(String s) {
        return new StringBuffer(s.replaceAll("[^a-zA-Z0-9]", ""));
    }

    public boolean isPalindrome(String s) {
        StringBuffer cleanStr = cleanString(s);

        return cleanStr.toString().equalsIgnoreCase(cleanStr.reverse().toString());
    }

    public static void main(String[] args) {
        E125ValidPalindrome program = new E125ValidPalindrome();

        System.out.println(program.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(program.isPalindrome("race a car"));
        System.out.println(program.isPalindrome(""));
    }
}
