import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
     Map <String,Integer> first=new HashMap<>();
     for(int i=0;i<list1.length;i++){
    	 first.put(list1[i], i);
     }
     List<String> result=new ArrayList<>();
     int minTotal=Integer.MAX_VALUE;
     for(int i=0;i<list2.length;i++){
    	 if(first.containsKey(list2[i])){
    		 if(first.get(list2[i])+i<minTotal){
    			 result.clear();
    			 result.add(list2[i]);
    			 minTotal=first.get(list2[i])+i;
    		 }else if(first.get(list2[i])+i==minTotal){
    			 result.add(list2[i]);
    		 }
    	 }
     }
     
     return result.toArray(new String[result.size()]);
	}
}
