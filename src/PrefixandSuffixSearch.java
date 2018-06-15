
public class PrefixandSuffixSearch {
	class WordFilter {
        private char[][] words;
	    public WordFilter(String[] words) {
        	for(int i=0;i<words.length;i++) {
        		this.words[i]=words[i].toCharArray();
        	}
	    }
	    
	    public int f(String prefix, String suffix) {
	        char[] precharArray = prefix.toCharArray();
	        char[] sufcharArray = suffix.toCharArray();
	    	for(int i=this.words.length-1;i>-1;i--) {
	             char[] cur=this.words[i];
	             if(precharArray.length>cur.length||
	            		 sufcharArray.length>cur.length) {
	            	 continue;
	             }
	            	 
	             int j=0;
	             while(j<cur.length&&j<precharArray.length
	            		 &&precharArray[j]==cur[j]) {
	            	 j++;
	             }
	             if(j<precharArray.length) {
	            	 continue;
	             }
                
	             j=sufcharArray.length-1;
	             while(j>-1&&cur[j+cur.length-sufcharArray.length]==sufcharArray[j]) {
	            	 j--;
	             }
	             if(j==-1) return i;
	             
	        }
	        return -1;
	    }
	}
}
