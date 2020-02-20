// Source: https://leetcode.com/problems/maximum-69-number/

public class E1323Max69Number {
    public int totalDigits(int num) {
        int count = 0;

        while (num/10 != 0) {
            count++;
            num = num/10;
        }

        return count;
    }

    public int power(int a, int b) {
        int num = 1;

        for (int i = 0; i < b; i++) {
            num *= a;
        }

        return num;
    }

    public int maximum69Number(int num) {
        int digit = 0;
        int newNumber = 0;
        boolean isModified = false;
        int currentTotalDigit = totalDigits(num);
        int powerTen = power(10, currentTotalDigit);

        while (currentTotalDigit >= 0) {
            digit = (num / powerTen) % 10;

            if (digit != 9 && !isModified) {
                digit = 9;
                isModified = true;
            }

            newNumber += digit * powerTen;
            powerTen /= 10;
            currentTotalDigit--;
        }

        return newNumber;
    }

    public static void main(String[] args) {
        E1323Max69Number program = new E1323Max69Number();

        System.out.println(program.maximum69Number(9696));
        System.out.println(program.maximum69Number(9966));
        System.out.println(program.maximum69Number(9699));
        System.out.println(program.maximum69Number(9999));
    }
}
