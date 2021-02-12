public class MinimumNumbersofFunctionCallstoMakeTargetArray {
    public static void main(String[] args) {
        System.out.println(32>>1);
    }
    public int minOperations(int[] nums) {
        int maxDouble=0;
        int oneAdding=0;
        for(int i:nums){
            int currentDouble=0;
            while(i>1){
                oneAdding+=i&1;
                currentDouble++;
                i>>=1;
            }
            maxDouble=Math.max(currentDouble,maxDouble);
            if(i>0)
                oneAdding++;
        }
        return maxDouble+oneAdding;
    }

}
