// Source: https://leetcode.com/problems/sort-array-by-parity-ii/

public class E922SortArrayOddEven {
    public int[] sortArrayByParityII(int[] a) {
        int[] sortedA = new int[a.length];
        int countOdd = 1;
        int countEven = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sortedA[countEven] = a[i];
                countEven += 2;
            } else {
                sortedA[countOdd] = a[i];
                countOdd += 2;
            }
        }

        return sortedA;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        E922SortArrayOddEven program = new E922SortArrayOddEven();

        printArray(program.sortArrayByParityII(new int[] {4, 2, 5, 7}));
        printArray(program.sortArrayByParityII(new int[] {0, 2, 9, 7, 5, 10}));
        printArray(program.sortArrayByParityII(new int[] {}));
    }
}
