import java.util.TreeMap;

public class FindAndReplaceinString {
	public static void main(String[] args) {
	System.out.println(new FindAndReplaceinString()
			.findReplaceString("abcd", new int[] {0,2}, 
					new String[] {"a", "cd"}, new String[] {"eee", "ffff"}));
	}
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
       StringBuilder sb=new StringBuilder(S);
       int buffer=0;
       TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
       for(int i=0;i<indexes.length;i++) {
    	   map.put(indexes[i],i);
       }
       for(int index:map.keySet()) {
    	   String source=sources[map.get(index)];
    	   String target=targets[map.get(index)];
    	   if(S.indexOf(source,index)==index) {
    		   sb.replace(index+buffer,index+buffer+source.length(), target);
    		   buffer+=target.length()-source.length();
    	   }
       }
       return sb.toString();
	}
}
