import java.util.*;

public class LeastNumberofUniqueIntegersafterKRemovals {
    public static void main(String[] args) {
        System.out.println(new LeastNumberofUniqueIntegersafterKRemovals()
        .findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3));
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        List<Map.Entry<Integer,Integer>> sortedList=new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
       int remainCount=map.size();
       int index=0;
       while(k>0){
           k-=sortedList.get(index++).getValue();
           remainCount--;
       }
       if(k!=0)
           remainCount++;
       return remainCount;
    }
}
