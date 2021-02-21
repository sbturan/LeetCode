import java.util.*;

public class AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod {
    public static void main(String[] args) {
        System.out.println(new AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod()
        .alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"},new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
    }
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String,List<Integer>> map=new HashMap<>();
        for(int i=0;i<keyTime.length;i++){
             map.putIfAbsent(keyName[i],new ArrayList<>());
             map.get(keyName[i]).add(Integer.valueOf(new String(new char[]{keyTime[i].charAt(0),keyTime[i].charAt(1),keyTime[i].charAt(3),keyTime[i].charAt(4)})));
        }
        List<String> result=new ArrayList<>();
        for(String s:map.keySet()){
            List<Integer> list = map.get(s);
            Collections.sort(list);
            boolean found=false;
            for(int i=0;i<list.size()-2&&!found;i++){
                if(list.get(i+2)-list.get(i)<=100){
                    found=true;
                    result.add(s);
                }
            }
        }
        Collections.sort(result);
       return result;
    }
}
