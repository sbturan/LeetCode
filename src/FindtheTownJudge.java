

public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1)
            return 1;
        int[] counts = new int[N + 1];
        for (int[] ar : trust) {
            counts[ar[1]]++;
            counts[ar[0]] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < counts.length; i++)
            if (counts[i] == N - 1)
                return i;
        return -1;
    }
}
