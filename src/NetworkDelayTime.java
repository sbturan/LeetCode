import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NetworkDelayTime {
	public static void main(String[] args) {
		System.out.println(
				new NetworkDelayTime().networkDelayTime(new int[][] {{1,2,1},{2,3,7},{1,3,4},{2,1,2}}, 3, 1));
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		HashMap<Integer,List<int[]>> map=new HashMap<>();
		for(int[] i:times){
			map.putIfAbsent(i[0],new ArrayList<>());
			map.get(i[0]).add(new int[]{i[1],i[2]});
		}
		int[] receiveTimes=new int[n+1];
		Arrays.fill(receiveTimes,Integer.MAX_VALUE);
		receiveTimes[k] = 0;
		receiveTimes[0]=-1;
		helper(0,map,receiveTimes,k);
		int result=0;
		for(int i:receiveTimes){
			if(i==Integer.MAX_VALUE)
				return -1;
			result=Math.max(result,i);
		}
		return result;
	}
	private void helper(int curTime,HashMap<Integer,List<int[]>> map,int[] receiveTimes,int node){
		if(!map.containsKey(node))
			return;
		for(int[] i:map.get(node)){
			    if(receiveTimes[i[0]]>curTime+i[1]){
					receiveTimes[i[0]]=curTime+i[1];
					helper(curTime+i[1],map,receiveTimes,i[0]);
				}
		}
	}
}
