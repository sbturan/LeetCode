public class JumpGameV {
    public static void main(String[] args) {
        System.out.println(new JumpGameV()
        .maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12},2));
    }
    public int maxJumps(int[] arr, int d) {
        Integer dp[]=new Integer[arr.length];
        int result=1;
        for(int i=0;i<arr.length;i++){
            result=Math.max(result,helper(arr,dp,i,d));
        }
        return result;
    }
    private int helper(int[] arr,Integer dp[],int i,int d){
        if(dp[i]!=null)
            return dp[i];
        int j=i+1;
        int result=0;
        while(j<arr.length && j-i<=d && arr[j]<arr[i]){
            result=Math.max(result,helper(arr,dp,j++,d));
        }
        j=i-1;
        while(j>-1&& i-j<=d && arr[j]<arr[i]){
            result=Math.max(result,helper(arr,dp,j--,d));
        }
        dp[i]=result+1;
        return result+1;
    }

}
