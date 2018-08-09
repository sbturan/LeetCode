public class CustomSortString {
	public static void main(String[] args) {
		CustomSortString c = new CustomSortString();
		System.out.println(c.customSortString("cba", "abcd"));
	}

	public  String customSortString(String S, String T) {
        int[] charIndexes=new int[26];
        
   char[] charArray = S.toCharArray();
   for(int i=0;i<charArray.length;i++) {
   	charIndexes[charArray[i]-'a']=i;
   }
   int lenght=T.length();
   char[] result=new char[26*lenght];
   for(Character c:T.toCharArray()) {
   	int index=charIndexes[c-'a']*lenght;
   	while(result[index]!=0) {
   		index++;
   	}
   	result[index]=c;
   }
   StringBuilder resultStr=new StringBuilder();
   for(Character c:result) {
   	if(c!=0&&c!=' ') {
   		resultStr.append(c);
   	}
   }
   return resultStr.toString();
	}
}
