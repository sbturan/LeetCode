import java.util.TreeMap;

public class OddEvenJump {
	public static void main(String[] args) {
		System.out.println(new OddEvenJump().oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));
	}

	public int oddEvenJumps(int[] arr) {
		boolean[][] dp=new boolean[arr.length][2];
		dp[dp.length-1][0]=true;
		dp[dp.length-1][1]=true;
		int result=1;
		TreeMap<Integer,Integer> map=new TreeMap<>();
		map.put(arr[arr.length-1],arr.length-1);
		for(int i=arr.length-2;i>-1;i--){
			Integer lower=map.lowerKey(arr[i]+1);
			Integer higher=map.higherKey(arr[i]-1);
			if(lower!=null){
				dp[i][0]=dp[map.get(lower)][1];
			}
			if(higher!=null){
				dp[i][1]=dp[map.get(higher)][0];
			}
			if(dp[i][1]){
				result++;
			}
			map.put(arr[i],i);

		}
		return result;
	}
}
