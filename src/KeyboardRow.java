import java.util.ArrayList;

public class KeyboardRow {
	
	
	public static void main(String[] args) {
		
	}
    public String[] findWords(String[] words) {
        int[] map=new int[26];
        for(char c:new char[] {'q','w','e','r','t','y','u','i','o','p'}) {
        	map[c-'a']=1;
        }
        for(char c:new char[] {'a','s','d','f','g','h','j','k','l'}) {
        	map[c-'a']=2;
        }
        for(char c:new char[] {'z','x','c','v','b','n','m'}) {
        	map[c-'a']=3;
        }
        ArrayList<String> list=new ArrayList<>();
        
        for(String s:words) {
        	if(s.length()==0) continue;
        	char[] charArray = s.toLowerCase().toCharArray();
        	int row=map[charArray[0]-'a'];
            boolean result=true;
            int i=1;
            while(i<charArray.length&&result) {
            	if(map[charArray[i++]-'a']!=row) {
            		result=false;
            	}
            }
            if(result) {
            	list.add(s);
            }
        }
        
        return list.toArray(new String[list.size()]);
        
    }
}
