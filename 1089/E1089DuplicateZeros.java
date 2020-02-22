// Source: https://leetcode.com/problems/duplicate-zeros/

public class E1089DuplicateZeros {
    public int totalZeros(int[] arr) {
        int countZeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                countZeros++;
        }

        return countZeros;
    }

    public void duplicateZeros(int[] arr) {
        int count = arr.length - 1 + totalZeros(arr);
        int i = arr.length - 1;

        while (count >= 0 && i >= 0) {
            if (count < arr.length)
                arr[count] = arr[i];

            if (arr[i] == 0 && --count < arr.length)
                arr[count] = arr[i];

            i--;
            count--;
        }
    }

    public static void main(String[] args) {
        E1089DuplicateZeros program = new E1089DuplicateZeros();

        program.duplicateZeros(new int[] {1,0,2,3,0,4,5,0});
        program.duplicateZeros(new int[] {1,5,2,0,6,8,0,6,0});
        program.duplicateZeros(new int[] {8,4,5,0,0,0,0,7});
        program.duplicateZeros(new int[] {0,0});

    }
}
