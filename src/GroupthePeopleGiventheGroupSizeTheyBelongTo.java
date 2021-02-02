import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        System.out.println(new GroupthePeopleGiventheGroupSizeTheyBelongTo()
        .groupThePeople(new int[]{3,3,2,3,2,1,3}));
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<groupSizes.length;i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i],new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i:map.keySet()){
            List<Integer> list = map.get(i);
            for(int j=0;j<list.size();j+=i){
                result.add(list.subList(j,j+i));
            }
        }
        return result;
    }
}
