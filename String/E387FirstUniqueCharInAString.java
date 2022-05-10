/* Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, (map.get(c) + 1));
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                char res = entry.getKey();

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == res) return i;
                }
            }
        }

        return -1;
    }

    public void test() {
        String input1 = "leetcode";
        String input2 = "loveleetcode";
        String input3 = "aabb";
        String input4 = "a";
        String input5 = "";

        System.out.println("The position of first unique char of \"" + input1 + "\": " + firstUniqChar(input1));
        System.out.println("The position of first unique char of \"" + input2 + "\": " + firstUniqChar(input2));
        System.out.println("The position of first unique char of \"" + input3 + "\": " + firstUniqChar(input3));
        System.out.println("The position of first unique char of \"" + input4 + "\": " + firstUniqChar(input4));
        System.out.println("The position of first unique char of \"" + input5 + "\": " + firstUniqChar(input5));
    }

    public static void main(String[] args) {
        Solution prog = new Solution();
        prog.test();
    }
}
