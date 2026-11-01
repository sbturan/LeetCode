import java.util.Collection;
import java.util.HashMap;

public class RestoreTheArray {
    public static void main(String[] args) {
        System.out.println(new RestoreTheArray().maxSumDistinctTriplet(new int[]{1,2,1,
                3,2}, new int[]{5,3,4,6,2}));
    }


    public int numberOfArrays(String s, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Collection<Integer> values = map.values();
        long[] dp = new long[s.length()];
        char arr[] = s.toCharArray();
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] != '0') {
                int cur = 0;
                int j = i;
                while (j < arr.length && cur <= k) {

                    if (j + 1 < arr.length) {
                        dp[i] += dp[j + 1];
                    } else {
                        dp[i]++;
                    }
                    cur = 10 * cur + (arr[j] - '0');
                    j++;
                }
            }
        }
        return (int) (dp[0] % 1000000007);
    }

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int[] map = new int[1000001];
        int mapMax = 0;
        for (int i = 0; i < x.length; i++) {
            map[x[i]] = Math.max(map[x[i]], y[i]);
            mapMax = Math.max(mapMax, map[x[i]]);
        }
        int[] max = new int[3];
        for (int i=0;i<map.length;i++) {
            if (map[i] > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = map[i];
            } else if (map[i] > max[1]) {
                max[2] = max[1];
                max[1] = map[i];
            } else if (map[i] > max[2]) {
                max[2] = map[i];
            }

        }
        if (max[0] == 0 || max[1] == 0 || max[2] == 0)
            return -1;
        return max[0] + max[1] + max[2];
    }
}
