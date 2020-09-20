import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleIV {
	public static void main(String[] args) {
		CourseScheduleIV c = new CourseScheduleIV();
		System.out.println(c.checkIfPrerequisite(5, new int[][] {{3,4},{2,3},{1,2},{0,1}}, new int[][] {{0,4},{4,0},{1,3},{3,0}}));
	}
	   public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
	    	List<Boolean> result=new ArrayList<Boolean>();
	    	HashMap<Integer,Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
	    	for(int[] i:prerequisites) {
	    		Set<Integer> orDefault = map.getOrDefault(i[1], new HashSet<Integer>());
	    		orDefault.add(i[0]);
	    		map.put(i[1],orDefault);
	    	}
	    	for(int i[]:queries) {
	    		result.add(helper(map, i));
	    	}
	    	return result;
	    }
	    private boolean helper(HashMap<Integer,Set<Integer>> map,int[] elem) {
	    	if(!map.containsKey(elem[1])) {
	    		return false;
	    	}
	    	Set<Integer> set = map.get(elem[1]);
			if(set.contains(elem[0])) {
	    		return true;
	    	}
	    	for(int i:set) {
	    		if(helper(map, new int[] {elem[0],i})) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
}
