import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
	public static void main(String[] args) {
		FindRightInterval f=new FindRightInterval();
		Interval[] intervals=new Interval [3];
		intervals[0]=new Interval(3, 4);
		intervals[1]=new Interval(2, 3);
		intervals[2]=new Interval(1, 2);
		System.out.println(Arrays.toString(f.findRightInterval(intervals)));
	}
    public int[] findRightInterval(Interval[] intervals) {
        
    	Map<Interval,Integer> indexes=new HashMap<>();
    	for(int i=0;i<intervals.length;i++) {
    		indexes.put(intervals[i],i);
    	}
    	
    	Arrays.sort(intervals, (a,b)->a.start-b.start);
    	int result[]=new int[intervals.length];
    	for(int i=0;i<intervals.length;i++) {
    		int j=i+1;
    		while(j<intervals.length&&intervals[j].start<intervals[i].end) {
    			j++;
    		}
    		if(j==intervals.length) {
    			result[indexes.get(intervals[i])]=-1;
    		}else {
    			result[indexes.get(intervals[i])]=indexes.get(intervals[j]);	
    		}
    		
    		
    	}
    	return result;
    }
}


/*
 * Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
*/
