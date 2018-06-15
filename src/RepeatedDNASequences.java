import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> result=new HashSet<>();
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length()-9;i++){
        	String subStr=sb.substring(i, i+10);
        	if(set.contains(subStr)){
        		result.add(subStr);
        	}else{
        		set.add(subStr);
        	}
        }
        return new ArrayList<String>(result);
    }
}
