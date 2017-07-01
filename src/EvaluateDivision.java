import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	       
		HashMap<String,List<String[]>> map=new HashMap<>();
		for(int i=0;i<equations.length;i++){
			String divided=equations[i][0];
			String divisor=equations[i][1];
			double val=values[i];
			String a[]=new String[]{divisor,String.valueOf(val)};
			List<String[]> orDefault = map.getOrDefault(divided, new ArrayList<>());
			orDefault.add(a);
			map.put(divided, orDefault);
			String b[]=new String[]{divided,String.valueOf((1.0)/val)};
			orDefault = map.getOrDefault(divisor, new ArrayList<>());
			orDefault.add(b);
			map.put(divisor, orDefault);
		}
		double[] result=new double[queries.length];
		for(int i=0;i<queries.length;i++){
			result[i]=getResult(queries[i][0], queries[i][1], new HashSet<>(), map,1.0);
		}
		return result;
	}
	private double getResult(String a,String b,Set<String> path,HashMap<String,List<String[]>> map,double mult){
		if(path.contains(a))return -1.0;
		if(a.equals(b)&&map.containsKey(a)) return 1*mult;
		List<String[]> list = map.get(a);
		if(list==null||list.isEmpty()) return -1.0;
		for(String[] array:list){
			if(array[0]==b){
				return Double.valueOf(array[1])*mult;
			}
		}
		path.add(a);
		for(String[] array:list){
			double result = getResult(array[0], b, path, map,mult*Double.valueOf(array[1]));
			if(result!=-1){
				return result;
			}
		}
		path.remove(a);
		return -1.0;
	}
}
