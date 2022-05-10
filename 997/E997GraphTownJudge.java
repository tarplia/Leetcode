// Source: https://leetcode.com/problems/find-the-town-judge/

public class E997GraphTownJudge {

    // how does trust look like?
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];

        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        E997GraphTownJudge program = new E997GraphTownJudge();
    }
}
