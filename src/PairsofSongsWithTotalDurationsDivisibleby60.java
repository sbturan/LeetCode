public class PairsofSongsWithTotalDurationsDivisibleby60 {
	public static void main(String[] args) {
		System.out.println(numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
	}
	public static int numPairsDivisibleBy60(int[] time) {
		int [] map=new int[60];
		int result = 0;
		for (int i = 0; i < time.length; i++) {
			int mod = time[i] % 60;
			result+=map[(60 - mod) % 60];
			map[mod]++;
		}
		return result;
	}
}
