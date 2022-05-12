import java.util.HashMap;

public class E169MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (!freqs.containsKey(num)) {
                freqs.put(num, 1);
            } else {
                int newValue = freqs.get(num) + 1;
                freqs.put(num, newValue);
            }

            if (freqs.get(num) > nums.length/2) {
                return num;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        E169MajorityElement program = new E169MajorityElement();

        System.out.println(program.majorityElement(new int[]{-1,1,1,1,1,2,8}));
        System.out.println(program.majorityElement(new int[]{2,2,1,3,3,3,3,3,3,3,3,1,1,2,2}));
    }
}
