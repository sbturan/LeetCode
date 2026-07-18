import java.util.Arrays;

public class GetMaxAdditionalDinersCount {
    public static void main(String[] args) {
        System.out.println(new GetMaxAdditionalDinersCount()
         .getMaxAdditionalDinersCount(15,2,3,new long[]{11,6,14}));
        System.out.println(new GetMaxAdditionalDinersCount().getMaxAdditionalDinersCount(10,1,2,new long[]{2,6}));
    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here
        Arrays.sort(S);
        long left=1;
        long result=0;
        for(long i:S){
            long diff=i-K-1-left;
            result+=Math.max(0,diff/(K+1));
            if(diff>-1)
                result++;
            left=i+K+1;
        }
        long diff=N-left;
        result+=Math.max(0,diff/(K+1));
        if(diff>-1)
            result++;
        return result;
    }
}
