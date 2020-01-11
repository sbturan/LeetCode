//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.TreeMap;
//
//public class SmallestSufficientTeam {
//    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
//        TreeMap<Integer,List<Integer>> map=new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
//        for(int i=0;i<people.size();i++) {
//        	int length=people.get(i).size();
//        	List<Integer> list=map.getOrDefault(length,new ArrayList<>());
//        	list.add(i);
//        	map.put(length,list);
//        }
//        
//    }
//    private List<Integer> helper(int countOfPeople,List<Integer> reqSkils)
//}
