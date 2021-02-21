public class MinimumDeletionCosttoAvoidRepeatingLetters {
    public static void main(String[] args) {
        System.out.println(new MinimumDeletionCosttoAvoidRepeatingLetters()
        .minCost("aabaa",new int[]{1,2,3,4,1}));
    }
    public int minCost(String s, int[] cost) {
        int result=0;
        char cur=s.charAt(0);
        int curMax=cost[0];
        int curTotal=cost[0];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==cur){
                curMax=Math.max(curMax,cost[i]);
                curTotal+=cost[i];
            }else{
                result+=curTotal-curMax;
                cur=s.charAt(i);
                curMax=cost[i];
                curTotal=cost[i];
            }
        }
        result+=curTotal-curMax;
        return result;
    }
}
