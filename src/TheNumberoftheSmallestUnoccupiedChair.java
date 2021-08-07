import java.util.*;

public class TheNumberoftheSmallestUnoccupiedChair {
    public static void main(String[] args) {
        System.out.println(new TheNumberoftheSmallestUnoccupiedChair().
                smallestChair(
                        new int[][]{{4,5},{12,13},{5,6},{1,2},{8,9},{9,10},{6,7},{3,4},{7,8},{13,14},{15,16},{14,15},{10,11},{11,12},{2,3},{16,17}},15));
    }
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArriveTime = times[targetFriend][0];
        HashSet<Integer> arrivalTimes = new HashSet<>();
        HashMap<Integer, List<Integer>> leaveTimes = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            arrivalTimes.add(times[i][0]);
            leaveTimes.putIfAbsent(times[i][1], new ArrayList<>());
            leaveTimes.get(times[i][1]).add(times[i][0]);
        }
        TreeSet<Integer> emptySeats = new TreeSet<>();
        int nextEmpty = 0;
        HashMap<Integer, Integer> arrivalToSeat = new HashMap<>();
        for (int i = 0; i <= targetArriveTime; i++) {
            if (leaveTimes.containsKey(i)) {
                List<Integer> arrTime = leaveTimes.get(i);
                for (int j : arrTime) {
                    emptySeats.add(arrivalToSeat.get(j));
                }
            }
            if (arrivalTimes.contains(i)) {
                if (emptySeats.isEmpty()) {
                    arrivalToSeat.put(i, nextEmpty++);
                } else {
                    arrivalToSeat.put(i, emptySeats.pollFirst());
                }
            }

        }
        return arrivalToSeat.get(targetArriveTime);
    }
}
