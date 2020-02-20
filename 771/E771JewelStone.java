// Source: https://leetcode.com/problems/jewels-and-stones/

import java.util.*;

public class E771JewelStone {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> freqs = new HashMap<Character, Integer>();

        for (int i = 0; i < jewels.length(); i++) {
            freqs.put(jewels.charAt(i), 0);
        }

        for (int j = 0; j < stones.length(); j++) {
            if (freqs.get(stones.charAt(j)) != null)
                freqs.put(stones.charAt(j), freqs.get(stones.charAt(j)) + 1);
        }

        int total = 0;

        for (int k = 0; k < jewels.length(); k++) {
            total += freqs.get(jewels.charAt(k));
        }

        return total;
    }

    public static void main(String[] args) {
        E771JewelStone program = new E771JewelStone();

        System.out.println(program.numJewelsInStones("aA", "aAAbbbbb"));
        System.out.println(program.numJewelsInStones("z", "ZZ"));
    }
}
