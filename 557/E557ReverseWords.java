// Source: https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class E557ReverseWords {
    public String reverseWords(String s) {
        String[] stringArr = s.split(" ");
        StringBuffer newString = new StringBuffer();

        for (String word : stringArr) {
            if (newString.length() > 0) {
                newString.append(" ");
            }

            newString.append(new StringBuffer(word).reverse());
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        E557ReverseWords program = new E557ReverseWords();

        System.out.println(program.reverseWords("Let's take LeetCode contest"));
        System.out.println(program.reverseWords("Our Hong2 is a good boy today"));
        System.out.println(program.reverseWords(""));

    }
}
