import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class M47PermutationsII {
    // --------------------------- Backtracking with Swapping -----------------------------
    //
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         permute(ans, nums, 0);
//         return ans;
//     }

//     private void permute(List<List<Integer>> ans, int[] nums, int pos) {
//         if (pos == nums.length) {
//             List<Integer> temp = new ArrayList<>();
//             for (int num: nums) { temp.add(num); }
//             ans.add(temp);
//             return;
//         }

//         Set<Integer> appeared = new HashSet<>();

//         for (int i=pos; i<nums.length; ++i) {
//             if (appeared.add(nums[i])) {
//                 swap(nums, pos, i);
//                 permute(ans, nums, pos+1);
//                 swap(nums, pos, i);
//             }
//         }
//     }

//     private void swap(int[] nums, int i, int j) {
//         int save = nums[i];
//         nums[i] = nums[j];
//         nums[j] = save;
//     }

    // --------------------------------- Backtracking with picking --------------------------
    // Q: Permute [1, 1, 2]
    // Algo
    // Started off with the root     .  In here, the pool of remaning numbers going down [1, 2, 3]
    //                              /
    // Building partial            1    the pool [2, 3]
    //                            /
    //                           2      the pool [3]
    //                          /
    //                         3        the pool []
    // Once you reach the end, store the partial to result.
    // then backtrack!
    //                              .
    //                             /
    //                            1
    //                           /
    //                          2       there is only one option in the pool, so move up again.
    //
    //                              .
    //                             /
    //                            1     there are 2 options here, so we've done the first, now second
    //                             \
    //                              3   pool [2]
    // Setting up the code
    // What I have?
    // a pool of numbers (List<Integer>) --> because the pool need to shrink to indicate what's
    // the remaining pool of numbers to be picked, we can't use the original DS provide
    // (int[]).
    // What needs to be constructred?
    // 1. GOAL: a container to keep the final result (result List<List<Integer>>)
    // 2. a helper container to keep the progress made so far (partial List<Integer>)

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        permute(numsList, new ArrayList<>(), result);

        return result;
    }

    private static void permute(List<Integer> nums, List<Integer> partial, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(partial));
            return;
        }

        HashSet<Integer> isVisited = new HashSet<>();

        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            if (isVisited.add(nums.get(i))) {
                partial.add(nums.get(i));
                nums.remove(i);
                permute(nums, partial, result);
                nums.add(i, curr);
                partial.remove(partial.size() - 1);
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] input1 = new int[] {1, 2, 3, 3};
        int[] input2 = new int[] {3, 3, 3, 4};
        int[] input3 = new int[] {};
        int[] input4 = new int[] {3, 3};

        System.out.println(permuteUnique(input1));
        System.out.println(permuteUnique(input2));
        System.out.println(permuteUnique(input3));
        System.out.println(permuteUnique(input4));
    }
}
