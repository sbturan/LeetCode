import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(i -> i[1]));
        int result = 1;
        int left=0,right=1;
        while(right<pairs.length){
            if(pairs[left][1]<pairs[right][0]){
                result++;
                left=right;
            }
            right++;
        }
        return result;
    }
}
