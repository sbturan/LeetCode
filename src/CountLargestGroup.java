public class CountLargestGroup {
    public static void main(String[] args) {
        System.out.println(new CountLargestGroup()
                .countLargestGroup(19));
    }

    public int countLargestGroup(int n) {
        int[] counts = new int[String.valueOf(n).length() * 9 + 1];
        int count = 0;
        int max = 0;
        int prev = 0;
        for (int i = 1; i <= n; i++) {
            int cur = 0;
            if (i % 10 == 0) {
                int temp = i - 1;
                int totalNines = 0;
                while (temp % 10 == 9) {
                    totalNines++;
                    temp /= 10;
                }
                cur = prev - (totalNines * 9) + 1;
            } else {
                cur = prev + 1;
            }
            prev = cur;
            counts[cur]++;
            if (counts[cur] == max) {
                count++;
            } else if (counts[cur] > max) {
                max = counts[cur];
                count = 1;
            }
        }
        return count;
    }
}
