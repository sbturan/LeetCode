public class KthSmallestNumberinMultiplicationTable {
    public static void main(String[] args) {
        int x=5,y=8;
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                System.out.print((i*j)+" ");
            }
            System.out.println();
        }
    }
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m && count < k; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
}
