// Source: https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;

public class E217Duplicates {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();

        for (int num : nums) {
            if (numSet.contains(num)) return true;

            numSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        E217Duplicates program = new E217Duplicates();

        System.out.println(program.containsDuplicate(new int[] {}));
        System.out.println(program.containsDuplicate(new int[] {1}));
        System.out.println(program.containsDuplicate(new int[] {1,2,3,1}));
        System.out.println(program.containsDuplicate(new int[] {1,2,3,4}));
        System.out.println(program.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
}
