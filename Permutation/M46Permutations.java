import java.util.ArrayList;
import java.util.List;

class M46Permutations {
//     // Backtracking - rcv
//     private void pick(int[] nums, List<Integer> partial, List<List<Integer>> result) {
//         if (partial.size() == nums.length) {
//             result.add(new ArrayList<>(partial));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (partial.contains(nums[i])) continue;
//             partial.add(nums[i]);
//             pick(nums, partial, result);
//             partial.remove(partial.size() - 1);
//         }
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         pick(nums, new ArrayList<>(), result);
//         return result;
//     }

        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(nums, 0, result);
            return result;
        }

        private static void backtracking(int[] nums, int pos, List<List<Integer>> result) {
            if (pos == nums.length) {
                List<Integer> temp = new ArrayList<>();
                for (int num : nums) {
                    temp.add(num);
                }
                result.add(temp);
                return;
            }

            for (int i = pos; i < nums.length; i++) {
                swap(nums, pos, i);
                backtracking(nums, pos+1, result);
                swap(nums, pos, i);
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

//     // DFS -rcv
//     private int[] findOther(int cur, int[] nums) {
//         int[] result = new int[nums.length - 1];
//         int j = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (cur == i) continue;
//             result[j++] = nums[i];
//         }
//         return result;
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();

//         if (nums.length == 0) {
//             result.add(new ArrayList<>());
//             return result;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             int first = nums[i];
//             int[] other = findOther(i, nums);
//             List<List<Integer>> inners = permute(other);

//             for (List<Integer> inner : inners) {
//                 inner.add(0, first);
//                 result.add(inner);
//             }
//         }

//         return result;
//     }

    public static void main(String[] args) {
        int[] input1 = new int[] {1, 2, 3};
        int[] input2 = new int[] {1, 2, 3, 4};
        int[] input3 = new int[] {};
        int[] input4 = new int[] {1};

        System.out.println(permute(input1));
        System.out.println(permute(input2).size());
        System.out.println(permute(input3));
        System.out.println(permute(input4));
    }
}
