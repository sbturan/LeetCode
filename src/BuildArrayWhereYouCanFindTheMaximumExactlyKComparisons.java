public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    public static void main(String[] args) {
        System.out.println(
                new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons().numOfArrays(2,3,1)
        );
    }
    public int numOfArrays(int n, int m, int k) {
       int result=0;
       if(m<k || n<k)
           return result;
       int mod=1000000007;
       for(int i=0;i<n;i++){
           int min = Math.min(i + 1, k);
           int start=Math.max(k-Math.min(k,(n-i)),1);
           result=(int)(((1L*result)+(m-k)+1)%mod);
           for(int j = start+1; j<= min; j++){
               // devam case i
               result=(int)(((1L*result)+j)%mod);
               result=(int)(((1L*result)+(m-j+1))%mod);
           }
       }
       return (int)(((result*1L)*m)%mod);
    }
}
