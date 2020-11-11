import java.util.HashMap;

public class DesignUndergroundSystem {
    public static void main(String[] args) {
        UndergroundSystem us=new DesignUndergroundSystem().new UndergroundSystem();
        us.checkIn(45,"l",3);
        us.checkIn(32,"p",8);
        us.checkOut(45,"w",15);
        System.out.println(us.getAverageTime("l","w"));
    }

    class UndergroundSystem {

        private HashMap<String, HashMap<String, Double>> times;
        private HashMap<String, HashMap<String, Integer>> counts;
        private HashMap<Integer, String> checkinStations;
        private HashMap<Integer, Integer> checkintimes;
        public UndergroundSystem() {
            counts=new HashMap<>();
            times=new HashMap<>();
            checkinStations=new HashMap<>();
            checkintimes=new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
             checkinStations.put(id,stationName);
             checkintimes.put(id,t);
        }

        public void checkOut(int id, String stationName, int t) {
            String checkinStation=checkinStations.get(id);
            int checinTime=checkintimes.get(id);
            HashMap<String,Double> curTimes=times.getOrDefault(checkinStation,new HashMap<>());
            HashMap<String, Integer> curCount = counts.getOrDefault(checkinStation, new HashMap<>());
            Double previousTimeAverage = curTimes.getOrDefault(stationName, Double.valueOf(0));
            Integer previousCount = curCount.getOrDefault(stationName, 0);
            curTimes.put(stationName,
                    (previousTimeAverage*(previousCount*1.0) + (t-checinTime))/((previousCount+1)*1.0)
            );
            curCount.put(stationName,curCount.getOrDefault(stationName,0)+1);
            times.put(checkinStation,curTimes);
            counts.put(checkinStation,curCount);
        }

        public double getAverageTime(String startStation, String endStation) {
           return times.getOrDefault(startStation,new HashMap<>()).getOrDefault(endStation,Double.valueOf(0));
        }
    }
}
