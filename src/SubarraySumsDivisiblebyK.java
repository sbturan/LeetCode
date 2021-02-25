

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        System.out.println(new SubarraySumsDivisiblebyK()
                .subarraysDivByK(new int[]{1,2,3,4,5}, 3));
    }

    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }


}
