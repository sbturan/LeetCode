import java.util.LinkedList;
import java.util.Queue;

public class StudentAttendanceRecordII {

	public static void main(String[] args) {
		StudentAttendanceRecordII s = new StudentAttendanceRecordII();
		System.out.println(s.checkRecord(100));
		// Arrays.sort(a);985598218

	}

	private Queue<Integer> digitQueue;

	public int checkRecord(int n) {
		int MOD = 1000000007;

        int[][][] dp = new int[n+1][2][3];
        dp[0] = new int[][]{{1,1,1}, {1,1,1}}; // 0 length, everything is 1
        for (int i = 1; i <= n; i++) 
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int value = dp[i-1][j][2]; // P for present
                    if (j > 0) value = (value + dp[i-1][j-1][2]) % MOD; // A for absent
                    if (k > 0) value = (value + dp[i-1][j][k-1]) % MOD; // L for late
                    dp[i][j][k] = value;
                }
        return dp[n][1][2];
	}


}

// Input: n = 2
// Output: 8
// Explanation:
// There are 8 records with length 2 will be regarded as rewardable:
// "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
// Only "AA" won't be regarded as rewardable owing to more than one absent
// times.