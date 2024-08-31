public class CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {
        System.out.println(new CountSubarraysWithScoreLessThanK().countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));
    }

    public long countSubarrays(int[] nums, long k) {
        long result = 0;
        long[] totals=new long[nums.length];
        totals[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            totals[i]=totals[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int left=i,right=nums.length-1;
            while(left<=right){
                int mid=(left+right)/2;
                long val=getScore(i,mid,totals);
                if(val>=k){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            result+=left-i;
        }
        return result;
    }
    private long getScore(int i,int j,long[] totals){
        long total=totals[j]-(i==0?0:totals[i-1]);
        return total*(j-i+1);
    }
}
