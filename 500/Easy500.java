import java.util.*;

public class Easy500 {
    private boolean isCharInArray(char c, char[] row) {
        for (int i = 0; i < row.length; i++) {
            if (Character.toUpperCase(c) == row[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllCharInRow(String word, char[] row) {
        // This is a change related to count variable.
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (isCharInArray(word.charAt(i), row)) {
                count++;
            }
        }

        return count == word.length();
    }

    private boolean isOneRow(String word) {
        char[] row1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        char[] row2 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
        char[] row3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

        return isAllCharInRow(word, row1) || isAllCharInRow(word, row2) || isAllCharInRow(word, row3);
    }

    public String[] findWords(String[] words) {
        ArrayList<String> output = new ArrayList<String>();

        // This is also a change.
        for (int i = 0; i < words.length; i++) {
            if (isOneRow(words[i])) {
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
        Easy500 program = new Easy500();

        printStringArray(program.findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"}));
    }
}
