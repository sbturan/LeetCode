import java.util.HashMap;

public class HandofStraights {
    public static void main(String[] args) {
        System.out.println(new HandofStraights()
                .isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;
        int m = hand.length / W;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            counts.put(hand[i], counts.getOrDefault(hand[i], 0) + 1);
        }

        for (int i : counts.keySet()) {
            int countPrev = counts.getOrDefault(i - 1, 0);
            int countSelf = counts.get(i);
            if (countSelf > countPrev) {
                int diff = countSelf - countPrev;
                m -= diff;
                if (m < 0)
                    return false;
                for (int j = 1; j < W; j++) {
                    int countNext = counts.getOrDefault(i + j, 0);
                    if (countNext < diff)
                        return false;
                    counts.put(i + j, countNext - diff);
                }
                counts.put(i, countSelf - diff);
            }
        }
        return m == 0;
    }
}
