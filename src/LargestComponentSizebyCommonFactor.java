import java.util.*;

public class LargestComponentSizebyCommonFactor {
    public static void main(String[] args) {
        System.out.println(new LargestComponentSizebyCommonFactor().largestComponentSize(
                new int[]{1,2,3,4,5,6,7,8,9}
        ));
    }
    int[] par;
    int[] cnt;
    private int find(int i) {
        if (i == par[i]) return i;
        return par[i] = find(par[i]);
    }
    private void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) return ;
        par[pi] = pj;
        cnt[pj] += cnt[pi];
    }
    public int largestComponentSize(int[] A) {
        int N = A.length;
        par = new int[N];
        cnt = new int[N];
        Map<Integer, Set<Integer>> prime2Idx = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int d = 2, x = A[i];
            while (d * d <= x) {
                if (x % d == 0) {
                    while (x % d == 0) x /= d;
                    prime2Idx.putIfAbsent(d, new HashSet<>());
                    prime2Idx.get(d).add(i);
                }
                d++;
            }
            if (x > 1) {
                prime2Idx.putIfAbsent(x, new HashSet<>());
                prime2Idx.get(x).add(i);
            }
        }
        for (int i = 0; i < N; i++) par[i] = i;
        Arrays.fill(cnt, 1);
        int max = 1;
        for (Set<Integer> s : prime2Idx.values()) {
            int fir = s.iterator().next();
            for (int idx : s) {
                union(idx, fir);
                max = Math.max(cnt[find(idx)],max);
            }
        }
        return max;
    }
}
