// Source: https://leetcode.com/problems/reverse-string/

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

    public static void main(String[] args) {
        E344ReverseString program = new E344ReverseString();

        program.test(new char[] {'h', 'e', 'l', 'l', 'o'});
        program.test(new char[] {'A', 'b', 'C'});
        program.test(new char[] {});
    }
}
