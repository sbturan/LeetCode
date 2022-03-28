import java.util.*;

public class IncreasingSubsequences {
    public static void main(String[] args) {
        System.out.println(new IncreasingSubsequences().findSubsequences(new int[]{1,5,3,4}));
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        int[] biggerIndexes=new int[nums.length];
        for(int i=nums.length-1;i>-1;i--){
            int j=i+1;
            while(j<nums.length && nums[j]<nums[i]){
                j++;
            }
            biggerIndexes[i]=j;
        }
        HashSet<List<Integer>> result=new HashSet<>();
        ArrayList<ArrayList<Integer>>[] dp = new ArrayList[nums.length];
        for(int i=nums.length-1;i>-1;i--){
            ArrayList<ArrayList<Integer>> curResult=new ArrayList<>();
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<=nums[j]){
                    if(dp[j]!=null){
                        for(List<Integer> cc:dp[j]){
                            ArrayList<Integer> ll=new ArrayList<>();
                            ll.add(nums[i]);
                            ll.addAll(cc);
                            curResult.add(ll);
                        }
                    }

                    curResult.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j])));
                    if(nums[i]==nums[j])
                        break;
                }
            }
            if(curResult.size()>0){
                dp[i]=curResult;
                result.addAll(curResult);
            }

        }
        return new ArrayList<>(result);
    }

}
