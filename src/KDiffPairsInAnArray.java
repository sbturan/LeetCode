import java.util.HashSet;
import java.util.Set;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
    	if(k<0) return 0;
        Set<Integer> elements=new HashSet<>();
        Set<Integer> pairs=new HashSet<>();
        int result=0;
        for(int i:nums) {
        	if(elements.contains(i)&&!pairs.contains(i)) {
        		result++;
        		pairs.add(i);
        	}
        	
        	elements.add(i);
        }
        
        if(k==0) {
        	return result;
        }
        pairs.clear();
        result=0;
        for(int i:elements) {
        	if(elements.contains(i-k)) {
        		result++;
        	}

        }
        
        return result;
    }
}
