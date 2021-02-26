public class MinimumInsertionStepstoMakeaStringPalindrome {
    public static void main(String[] args) {
        System.out.println(new MinimumInsertionStepstoMakeaStringPalindrome()
        .minInsertions("leetcodeleetcode"));
    }
    Integer[][] dp;

    public int helper(int i, int j, String s){

        if(i>j)
            return 0;

        if(dp[i][j] != null)
            return dp[i][j];
        int val;

        if(s.charAt(i) == s.charAt(j))
            val = helper(i+1,j-1,s);
        else
            val = Math.min(helper(i+1,j,s),helper(i,j-1,s)) + 1;

        dp[i][j] = val;

        return dp[i][j];
    }
    public int minInsertions(String s) {
        dp = new Integer[s.length()][s.length()];
        return helper(0,s.length()-1,s);
    }
}
