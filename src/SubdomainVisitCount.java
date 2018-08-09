import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {
	public static void main(String[] args) {
		SubdomainVisitCount s=new SubdomainVisitCount();
		System.out.println(s.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
	}
	public List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> counts = new HashMap<>();
		
		for(String s:cpdomains) {
			String[] split = s.split(" ");
			int count=Integer.valueOf(split[0]);
			String[] val = split[1].split("\\.");
			String sb=val[val.length-1];
			counts.put(sb.toString(),counts.getOrDefault(sb.toString(), 0)+count);
			for(int i=val.length-2;i>-1;i--) {
				sb=val[i]+"."+sb;
				counts.put(sb,counts.getOrDefault(sb.toString(), 0)+count);	
			}
		}
		List<String> result=new ArrayList<>();
		for(String s:counts.keySet()) {
			result.add(counts.get(s)+" "+s);
		}
		return result;
	}
}
