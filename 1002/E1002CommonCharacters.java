// Source: https://leetcode.com/problems/find-common-characters/

import java.util.*;

public class E1002CommonCharacters {
    private int[] globalLetterCount = new int[26];

    public void updateLetter(String s) {
        int[] tempLetterCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            tempLetterCount[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (globalLetterCount[i] > tempLetterCount[i])
                globalLetterCount[i] = tempLetterCount[i];
        }
    }

    public List<String> commonChars(String[] a) {
        ArrayList<String> output = new ArrayList<String>();

        for (int i = 0; i < 26; i++) {
            globalLetterCount[i] = 100;
        }

        for (int i = 0; i < a.length; i++) {
            updateLetter(a[i]);
        }

        for (int i = 0; i < 26; i++) {
            if (globalLetterCount[i] > 0) {
                char c = (char)(i + 'a');

                for (int j = 0; j < globalLetterCount[i]; j++) {
                    output.add(Character.toString(c));
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        E1002CommonCharacters program = new E1002CommonCharacters();

        System.out.println(program.commonChars(new String[] {"cool","look","cook"}));
        System.out.println(program.commonChars(new String[] {"breed","bed","shed"}));
        System.out.println(program.commonChars(new String[] {"wool","sheep","check"}));

    }
}
