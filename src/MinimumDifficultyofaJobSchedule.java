public class MinimumDifficultyofaJobSchedule {
    public static void main(String[] args) {
        System.out.println(new MinimumDifficultyofaJobSchedule().minDifficulty(
                new int[]{380,302,102,681,863,676,243,671,651,612,162,561,394,856,601,30,6,257,921,405,716,126,158,476,889,699,668,930,139,164,641,801,480,756,797,915,275,709,161,358,461,938,914,557,121,964,315},10
        ));
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length)
            return -1;
        Integer[][] dp =new Integer[d][jobDifficulty.length];
        dp[0][jobDifficulty.length-1]=jobDifficulty[jobDifficulty.length-1];
        for(int i=jobDifficulty.length-2;i>-1;i--){
            dp[0][i]=Math.max(jobDifficulty[i],dp[0][i+1]);
        }

        int result= helper(0, jobDifficulty, d,dp);
        return result;
    }

    private int helper(int startIndex, int[] jobDifficulty, int d,Integer[][] dp) {
        if(dp[d-1][startIndex]!=null)
            return dp[d-1][startIndex];
        int taskCount = jobDifficulty.length - startIndex;
        int maxTaskCount = taskCount-(d-1);
        int result = Integer.MAX_VALUE, curResult = Integer.MIN_VALUE;
        for (int i = 0; i < maxTaskCount; i++) {
            curResult = Math.max(curResult, jobDifficulty[startIndex + i ]);
            result = Math.min(result, helper(startIndex + i +1, jobDifficulty, d - 1,dp) + curResult);
        }
        dp[d-1][startIndex]=result;
        return result;
    }


}
