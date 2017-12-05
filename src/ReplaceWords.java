import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {

    	Set<String> set=new HashSet<>();
    	for(String s:dict) {
    		set.add(s);
    	}
    	String[] split = sentence.split(" ");
    	for(String s:split ) {
    		for(int i=1;i<s.length();i++) {
    			if(set.contains(s.substring(0, i))) {
                     for(int k=0;k<split.length;k++) {
                    	 if(split[k]==s) {
                    		 split[k]=s.substring(0, i);
                    	 }
                     }
    				break;
    			}
    		}
    	}
    		StringBuilder result=new StringBuilder();
    		for(String s:split) {
    			result.append(s+" ");
    		}
    		return result.toString().trim();
    }
    
}
