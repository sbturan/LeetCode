
public class DecodedStringatIndex {
	public static void main(String[] args) {
		DecodedStringatIndex d=new DecodedStringatIndex();
		System.out.println(d.decodeAtIndex("vzpp636m8y",2920));
	} // leetleetcode leetleetcode leetleetcode
    public String decodeAtIndex(String S, int K) {
        char[] charArray = S.toCharArray();
        int index=0;
        int letterCount=0;
        for(int i=0;i<charArray.length;i++) {
        	if(charArray[i]<=57) {
        	   int value=(int)(charArray[i]-'0');
        	   index=(index)*value;
        	   letterCount*=value;
        	}else {
        		index++;
        		letterCount++;
        	}   
        	   if(index==K) {
        		   return String.valueOf(charArray[i]);
        	   }
        	   else if(index>K) {
        	   letterCount/=(int)(charArray[i]-'0');
      		   K=(K)%letterCount;
      		   return getReturnValue(charArray,K);
      	   }
        }
    	return "";
    }
    private String getReturnValue(char[] charArray,int K) {
    	int i=-1;
    	while(K>0) {
    		K--;
    		i++;
    		if(charArray[i]<58) {
    			if(charArray[i]=='1') {
    				i++;
    			}else {
    				charArray[i]--;
    				i=0;
    			}
    		}
    	}
    	return String.valueOf(charArray[i]);
    }
}
