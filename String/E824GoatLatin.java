// Source: https://leetcode.com/problems/goat-latin/

public class E824GoatLatin {
    private final boolean[] isVowel = new boolean[]
    {true, false, false, false, true, false, false,false, true, false, false, false, false,
        false, true, false, false, false, false, false, true, false, false, false, false, false};

    private boolean isWordStartWithVowel(String word) {
        char firstLetter = Character.toUpperCase(word.charAt(0));

        return isVowel[firstLetter - 'A'];
    }

    private String modifiedWord(String word) {
        StringBuffer s = new StringBuffer();

        if (isWordStartWithVowel(word)) {
            return s.append(word).append("ma").toString();
        } else {
            return s.append(word.substring(1)).append(word.charAt(0)).append("ma").toString();
        }
    }

    private String appendA(int n) {
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < n; i++) {
            s.append('a');
        }

        return s.toString();
    }

    public String toGoatLatin(String s) {
        String[] arrayOfWords = s.split(" ");
        StringBuffer newString = new StringBuffer();

        if (s.equals(""))
            return "";

        for (int i = 0; i < arrayOfWords.length; i++) {
            if (i > 0)
                newString.append(" ");

            newString.append(modifiedWord(arrayOfWords[i])).append(appendA(i + 1));
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        E824GoatLatin program = new E824GoatLatin();

        System.out.println(program.toGoatLatin("My name is Aaron Sasaka"));
        System.out.println(program.toGoatLatin("My sister name is Ellie"));
        System.out.println(program.toGoatLatin(""));
        System.out.println(program.toGoatLatin("x"));
    }
}
