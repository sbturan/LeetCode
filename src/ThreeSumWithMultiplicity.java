

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        System.out.println(new ThreeSumWithMultiplicity()
                .threeSumMulti(new int[]{0, 0, 0}, 0));
    }

    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        int[] counts = new int[101];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        long result = 0;
        for (int i = 0; i <= 100; i++) {
            if (counts[i] == 0) continue;
            if (i > target || i + i > target) break;
            for (int j = i; j <= 100; j++) {
                if (counts[j] == 0) continue;
                if (i + j > target || i + j + j > target) break;
                int curTarget = target - (i + j);
                if (curTarget < 101 && counts[curTarget] > 0) {
                    if (curTarget == i && curTarget == j) {
                        int n = counts[i];
                        result = (result + (((1L * n * (n - 1)) % MOD) * (n - 2) / 6L) % MOD);
                    } else if (curTarget == i) {
                        int n = counts[i];
                        result = (result + ((1L * counts[j] * ((n * (n - 1) / 2L) % MOD)) % MOD));
                    } else if (curTarget == j) {
                        int n = counts[j];
                        result = (result + ((1L * counts[i] * ((n * (n - 1) / 2L) % MOD)) % MOD));
                    } else if (i == j) {
                        int n = counts[j];
                        result = (result + ((1L * counts[curTarget] * ((n * (n - 1) / 2L) % MOD)) % MOD));
                    } else {
                        result = (result + ((1L * counts[i] * counts[j] * counts[curTarget]) % MOD));
                    }
                }

            }
        }
        return (int) (result );
    }
}
