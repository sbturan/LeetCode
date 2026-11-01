public class MinimumOperationstoMakeArrayModuloAlternatingI {
    public static void main(String[] args) {
        System.out.println(new MinimumOperationstoMakeArrayModuloAlternatingI().minOperations(
                new int[]{78,339182,56,83568},8
        ));
    }
    public int minOperations(int[] nums, int k) {
        Integer[] min1=new Integer[2];
        Integer[] min2=new Integer[2];
        for(int i=0;i<k;i++){
            int cost=0;
            for(int j=0;j<nums.length;j+=2){
                int mod=nums[j]%k;
                cost += Math.min(Math.abs(i - mod), k - Math.abs(i - mod));
            }
            if(min1[0]==null||cost<min1[0]){
                min2[0]=min1[0];
                min2[1]=min1[1];
                min1[0]=cost;
                min1[1]=i;

            }else if(min2[0]==null||cost<=min2[0]){
                min2[0]=cost;
                min2[1]=i;
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            int cost=0;
            for(int j=1;j<nums.length;j+=2){
                int mod=nums[j]%k;
                cost += Math.min(Math.abs(i - mod), k - Math.abs(i - mod));
            }
            if(min1[1]!=i){
                cost+=min1[0];
            }else{
                cost+=min2[0];
            }
            result=Math.min(result,cost);
        }
        return result;
    }
}
