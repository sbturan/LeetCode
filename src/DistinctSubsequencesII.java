

public class DistinctSubsequencesII {
    public static void main(String[] args) {
        System.out.println(new DistinctSubsequencesII().distinctSubseqII("aba"));
    }


    public int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long) 1e9 + 7;
        long sum = 0;
        for (char c : S.toCharArray()) {
            long temp = end[c - 'a'];
            end[c - 'a'] = sum % mod + 1;
            sum += end[c - 'a'] - temp;
        }
        return (int) (sum % mod);
    }


}
