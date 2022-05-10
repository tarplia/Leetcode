import java.util.*;

public class Easy500V2 {
    int[] rowOf = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3,
                   3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

    private boolean isAllCharInOneRow(String word) {
        int whichRow = 0;
        int row = 0;

        for (int i = 0; i < word.length(); i++) {
            row = whichRow;

            whichRow = rowOf[Character.toUpperCase(word.charAt(i)) - 'A'];

            if (row != whichRow && i != 0) {
                return false;
            }
        }

        return true;
    }

    public String[] findWords(String[] words) {
        ArrayList<String> output = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            if (isAllCharInOneRow(words[i])) {
                output.add(words[i]);
            }
        }

        String[] outputArray = new String[output.size()];
        return output.toArray(outputArray);
    }

    static void printStringArray(String[] words) {
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    public static void main(String[] args) {
        Easy500V2 program = new Easy500V2();

        printStringArray(program.findWords(new String[] {"Hello", "Alaska", "Dad", "Peace", "BMC"}));
    }
}
