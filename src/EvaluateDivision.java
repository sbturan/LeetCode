import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
	public static void main(String[] args) {
		double a=2;
		double b=1d/3;
		System.out.println(a/b);
	}
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		HashMap<String,HashMap<String,Double>> map=new HashMap<>();
		for(int i=0;i<equations.size();i++){
			String divided=equations.get(i).get(0);
			String divisor=equations.get(i).get(1);
			double val=values[i];
			if(!map.containsKey(divided)){
				map.put(divided,new HashMap<>());
			}
		   map.get(divided).put(divisor,val);
			if(!map.containsKey(divisor)){
				map.put(divisor,new HashMap<>());
			}
			map.get(divisor).put(divided,1/val);

		}
		double[] result=new double[queries.size()];
		for(int i=0;i<queries.size();i++){
			List<String> cur = queries.get(i);
			double curResult=-1;
			if(map.containsKey(cur.get(1))){
			  curResult=helper(cur.get(0),cur.get(1),map,new HashSet<>());;
			}
			result[i]=curResult;
		}
		return result;
	}
	private double helper(String a, String b, HashMap<String,HashMap<String,Double>> map, HashSet<String> visited){
		if(visited.contains(a)||!map.containsKey(a))
			return -1;
		if(a==b)
			return 1;
		HashMap<String, Double> values = map.get(a);
		if(values.containsKey(b))
			return values.get(b);
		visited.add(a);
		for(String s:values.keySet()){
			double res=helper(s,b,map,visited);
           if(res!=-1){
           	res*= values.get(s);
           	values.put(b,res);
           	map.get(b).put(a,1/res);
           	return res;
		   }
		}
		visited.remove(a);
		values.put(b,-1.0);
		map.get(b).put(a,-1.0);
		return -1;
	}
}
