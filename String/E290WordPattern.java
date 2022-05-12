// Source: https://leetcode.com/problems/word-pattern/

import java.util.HashMap;
import java.util.HashSet;

public class E290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> wordBank = new HashMap<Character, String>();
        HashSet<String> wordSet = new HashSet<String>();
        String[] strArr = str.split(" ");

        for (int i = 0; i < pattern.length(); i++) {
            if (!wordBank.containsKey(pattern.charAt(i))) {
                if (wordSet.contains(strArr[i])) {
                    return false;
                } else {
                    wordBank.put(pattern.charAt(i), strArr[i]);
                    wordSet.add(strArr[i]);
                }
            } else if (!wordBank.get(pattern.charAt(i)).equals(strArr[i])) {
                return false;
            }
        }
        
        return true;
    }

    private void test(String pattern, String str) {
        System.out.println(pattern + " - " + str + " --> " + wordPattern(pattern, str));
    }

    public static void main(String[] args) {
        E290WordPattern program = new E290WordPattern();

        program.test("abba", "dog cat cat dog");
        program.test("abba", "dog cat cat fish");
        program.test("aaaa", "dog cat cat dog");
        program.test("aaaa", "dog dog dog dog");
        program.test("abba", "dog dog dog dog");
    }
}
