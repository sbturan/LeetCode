import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        System.out.println(new BusRoutes()
        .numBusesToDestination(new int[][]{{1,2,7},{3,6,7}},1,6));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, Set<Integer>> stopToBus = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                stopToBus.putIfAbsent(routes[i][j], new HashSet<>());
                stopToBus.get(routes[i][j]).add(i);
            }
        }
        if (!stopToBus.containsKey(source) || !stopToBus.containsKey(target))
            return -1;
        if (source == target)
            return 0;
        int level = 0;
        Queue<Integer> busQ = new LinkedList<>();
        busQ.addAll(stopToBus.get(source));
        stopToBus.remove(source);
        boolean[] visitedBus=new boolean[routes.length];
        Set<Integer> visitedStops=new HashSet<>();
        visitedStops.add(source);
        while (!busQ.isEmpty()) {
            level++;
            int size = busQ.size();
            for (int j = 0; j < size; j++) {
                Integer curBus = busQ.poll();
                    int[] nextStops = routes[curBus];
                    for (int i : nextStops) {
                        if (i == target) {
                            return level;
                        }
                        if (!visitedStops.contains(i)) {
                            for(int b:stopToBus.get(i)){
                                if(!visitedBus[b]){
                                    busQ.add(b);
                                    visitedBus[b]=true;
                                }

                            }
                            visitedStops.add(i);
                        }
                    }
            }

        }
        return -1;
    }
}
